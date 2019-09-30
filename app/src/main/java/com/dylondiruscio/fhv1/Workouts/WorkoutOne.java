package com.dylondiruscio.fhv1.Workouts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.dylondiruscio.fhv1.MainActivity;
import com.dylondiruscio.fhv1.MyProfile;
import com.dylondiruscio.fhv1.Overflow.Goals;
import com.dylondiruscio.fhv1.Overflow.MapSettings;
import com.dylondiruscio.fhv1.Overflow.Nutrition;
import com.dylondiruscio.fhv1.Overflow.Settings;
import com.dylondiruscio.fhv1.Overflow.Statistics;
import com.dylondiruscio.fhv1.Overflow.WorkoutPlans;
import com.dylondiruscio.fhv1.R;

public class WorkoutOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_one);
    }

    public void startBtn(View view){
        Intent intent = new Intent (WorkoutOne.this, com.dylondiruscio.fhv1.RegisterActivity.class);
        startActivity(intent);
    }

    //Loads the overflow menu and Profile button on the action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_btn, menu);
        return true;
    }

    //Fills in the options and intents for the overflow menu and the home button
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings_id:
                Intent intent = new Intent(WorkoutOne.this, Settings.class);
                startActivity(intent);
                break;

            case R.id.stats_id:
                Intent intent2 = new Intent(WorkoutOne.this, Statistics.class);
                startActivity(intent2);
                break;

            case R.id.workout_plans_id:
                Intent intent3 = new Intent(WorkoutOne.this, WorkoutPlans.class);
                startActivity(intent3);
                break;

            case R.id.nutrition_id:
                Intent intent4 = new Intent(WorkoutOne.this, Nutrition.class);
                startActivity(intent4);
                break;

            case R.id.goals_id:
                Intent intent5 = new Intent(WorkoutOne.this, Goals.class);
                startActivity(intent5);
                break;

            case R.id.map_settings_id:
                Intent intent6 = new Intent(WorkoutOne.this, MapSettings.class);
                startActivity(intent6);
                break;

            case R.id.myProfile1:
                Intent intent7 = new Intent(WorkoutOne.this, MyProfile.class);
                startActivity(intent7);
                break;
        }

        // case blocks for other MenuItems (if any)

        return super.onOptionsItemSelected(item);
    }
}
