package com.dylondiruscio.fhv1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


public class InfoActivity extends AppCompatActivity {

    ViewPager viewPager;
    CustomSwipeAdapter adapter;
    private static int MAX_LAYOUTS = 3;
    private boolean isLastPageSwiped;
    private int counterPageScroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        //Initialization of previously declared ViewPager and CustomViewAdapter
        viewPager = (ViewPager)findViewById(R.id.view_Pager);
        adapter = new CustomSwipeAdapter(this);

        //Setting the ViewPager's (viewpager) adapter to our new customViewAdapter (adapter)
        viewPager.setAdapter(adapter);

        //listening for swipes to screen
        ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
            }

            //If page swiped
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == MAX_LAYOUTS - 1 && positionOffset == 0 && !isLastPageSwiped) {

                    //If last page swiped
                    if (counterPageScroll != 0) {
                        isLastPageSwiped = true;

                        // go to login activity
                        Intent intent = new Intent(InfoActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                    counterPageScroll++;
                } else {
                    counterPageScroll = 0;
                }
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        };
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

    }

    @Override
    public void onBackPressed(){

    }
}
