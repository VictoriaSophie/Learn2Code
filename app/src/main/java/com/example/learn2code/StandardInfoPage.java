package com.example.learn2code;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class StandardInfoPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard_info_page);
        setAppBar();
    }

    private void setAppBar() {
        BottomAppBar bottomAppBar;
        bottomAppBar = findViewById(R.id.bottomAppBar2);
        FloatingActionButton home_button = findViewById(R.id.home);
        CommonMethods.setAppBar(StandardInfoPage.this, bottomAppBar, home_button);
    }
}