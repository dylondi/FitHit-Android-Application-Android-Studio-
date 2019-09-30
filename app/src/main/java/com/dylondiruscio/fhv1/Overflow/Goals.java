package com.dylondiruscio.fhv1.Overflow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.dylondiruscio.fhv1.MyProfile;
import com.dylondiruscio.fhv1.R;

public class Goals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_btn, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings_id:
                Intent intent = new Intent(Goals.this, Settings.class);
                startActivity(intent);
                break;

            case R.id.stats_id:
                Intent intent2 = new Intent(Goals.this, Statistics.class);
                startActivity(intent2);
                break;

            case R.id.workout_plans_id:
                Intent intent3 = new Intent(Goals.this, WorkoutPlans.class);
                startActivity(intent3);
                break;

            case R.id.nutrition_id:
                Intent intent4 = new Intent(Goals.this, Nutrition.class);
                startActivity(intent4);
                break;

            case R.id.goals_id:
                Intent intent5 = new Intent(Goals.this, Goals.class);
                startActivity(intent5);
                break;

            case R.id.map_settings_id:
                Intent intent6 = new Intent(Goals.this, MapSettings.class);
                startActivity(intent6);
                break;

            case R.id.myProfile1:
                Intent intent7 = new Intent(Goals.this, MyProfile.class);
                startActivity(intent7);
                break;
        }

        // case blocks for other MenuItems (if any)

        return super.onOptionsItemSelected(item);
    }
}
