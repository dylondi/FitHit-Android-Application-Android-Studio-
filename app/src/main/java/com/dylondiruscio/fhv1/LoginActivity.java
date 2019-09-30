package com.dylondiruscio.fhv1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText txtEmailLogin;
    private EditText txtPwd;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtEmailLogin = (EditText) findViewById(R.id.txtEmailLogin);
        txtPwd = (EditText) findViewById(R.id.txtPwd);
        mAuth = FirebaseAuth.getInstance();
    }

    //if login button is clicked
    public void login(View view) {

        if (txtEmailLogin.getText().toString().length() == 0 && txtPwd.getText().toString().length() == 0) {
            Toast.makeText(LoginActivity.this, "Please enter your email and password.", Toast.LENGTH_LONG).show();
        } else if (txtEmailLogin.getText().toString().length() == 0) {
            Toast.makeText(LoginActivity.this, "Please enter your email.", Toast.LENGTH_LONG).show();
        } else if (txtPwd.getText().toString().length() == 0) {
            Toast.makeText(LoginActivity.this, "Please enter your password.", Toast.LENGTH_LONG).show();
        } else {

            final ProgressDialog progressDialog = ProgressDialog.show(LoginActivity.this, "Please Wait...", "Processing...", true);

            (mAuth.signInWithEmailAndPassword(txtEmailLogin.getText().toString(), txtPwd.getText().toString()))
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();
                            if (task.isSuccessful()) {
                                Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_LONG).show();
                                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                                i.putExtra("Email", mAuth.getCurrentUser().getEmail());
                                startActivity(i);
                            } else {
                                Log.e("ERROR", task.getException().toString());
                                Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });

        }
    }
    public void signUpBtn(View view){
        Intent intent = new Intent (LoginActivity.this, com.dylondiruscio.fhv1.RegisterActivity.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed(){

    }
}
