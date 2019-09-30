package com.dylondiruscio.fhv1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {


    //EditTexts to complete registration
    private EditText txtUname;
    private EditText txtEmailAddress;
    private EditText txtPassword;
    private EditText txtWeight;
    private EditText txtHeight;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Assigning editTexts to matching fields in the xml file
        txtUname = (EditText)findViewById(R.id.unameEditText);
        txtEmailAddress = (EditText)findViewById(R.id.emailEditText);
        txtPassword = (EditText)findViewById(R.id.passwordEditText);
        txtWeight = (EditText)findViewById(R.id.weightEditText);
        txtHeight = (EditText)findViewById(R.id.heightEditText);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    //When register button is clicked
    public void Register(View view){

        //Show Please wait message to user
        final ProgressDialog progressDialog = ProgressDialog.show(RegisterActivity.this, "Please wait...", "Processing...", true);

        //Attempt to create user with email and password given
        (firebaseAuth.createUserWithEmailAndPassword(txtEmailAddress.getText().toString(), txtPassword.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();

                //If email and password given are valid
                if(task.isSuccessful()){

                    //Convert all info given (except password) to Strings to later insert into database
                    String uName = txtUname.getText().toString();
                    String email = txtEmailAddress.getText().toString();
                    String w = txtWeight.getText().toString();
                    String h = txtHeight.getText().toString();
                    //calculated BMI
                    double bmiDouble = (Double.parseDouble(w))/((Double.parseDouble(h))*(Double.parseDouble(h)));
                    String BMI = Double.toString(bmiDouble);

                    //Creates instance of each user
                    User user = new User(
                            uName, email, w, h, BMI
                    );

                    //Attempts to create user with given info and insert into db
                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {

                            //If database insert is successful
                            if(task2.isSuccessful()){
                                Toast.makeText(RegisterActivity.this, "Registration Successful!", Toast.LENGTH_LONG).show();
                            }
                            else{
                                Toast.makeText(RegisterActivity.this, "Not Successful!", Toast.LENGTH_LONG).show();
                            }
                        }
                    });

                    //Intent to navigate to Login activity
                    Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(i);
                }
                else{

                    //If authentication registration is unsuccessful
                    Log.e("ERROR", task.getException().toString());
                    Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
