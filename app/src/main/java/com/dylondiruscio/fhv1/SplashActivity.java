package com.dylondiruscio.fhv1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by dylon on 01/02/2019.
 */

public class SplashActivity extends AppCompatActivity {

    //length of splash
    private static int timeout=4000;
    ImageView img, img2;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        //assigning top image to ImageView img
        img = findViewById(R.id.img);
        //assigning bottom image to ImageView img2
        img2 = findViewById(R.id.img2);


        //Create two animations based on both animations in res/anim
        Animation animation = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.myanim);
        Animation animation2 = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.myanim2);


        //start both animations
        img.startAnimation(animation);
        img2.startAnimation(animation2);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, InfoActivity.class);
                startActivity(intent);

            }
        },timeout);
    }
}
