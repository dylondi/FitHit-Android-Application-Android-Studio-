package com.dylondiruscio.fhv1;

import android.widget.EditText;

public class User {

    public String uname, email, weight, height, BMI;

    public User(){
    }

    public User(String uname, String email, String weight, String height, String BMI) {
        this.uname = uname;
        this.email = email;
        this.weight = weight;
        this.height = height;
        this.BMI = BMI;
    }
}
