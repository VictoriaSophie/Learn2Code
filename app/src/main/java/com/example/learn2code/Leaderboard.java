package com.example.learn2code;

import android.os.Bundle;
import android.view.Menu;

public class Leaderboard extends CommonMethods {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_leaderboard);
        getLayoutResource();


    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_leaderboard;
    }

    @Override
    public boolean onCreateOptionsMenu() {
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

}