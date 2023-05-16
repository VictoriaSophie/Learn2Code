package com.example.learn2code;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public abstract class CommonMethods extends AppCompatActivity {

    Toolbar bottomAppBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());
        configureToolbar();
        bottomAppBar.inflateMenu(R.menu.menu);
        FloatingActionButton home_button = findViewById(R.id.home);

        bottomAppBar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.settings) {
                Intent i = new Intent(CommonMethods.this, Settings.class);
                startActivity(i);
                return true;
            }
            if (item.getItemId() == R.id.leaderboard) {
                Intent i = new Intent(CommonMethods.this, Leaderboard.class);
                startActivity(i);
                return true;
            }
            return false;
        });

        home_button.setOnClickListener(view -> Toast.makeText(getApplicationContext(), "Home button", Toast.LENGTH_LONG).show());
        home_button.setOnClickListener(view -> {
            Intent i = new Intent(CommonMethods.this, MainActivity.class);
            startActivity(i);
        });
        bottomAppBar.getChildAt(0).setOnClickListener(v -> finish());
    }

    protected abstract int getLayoutResource();

    private void configureToolbar() {
        bottomAppBar = findViewById(R.id.bottomAppBar2);
        if (bottomAppBar != null) {
            setSupportActionBar(bottomAppBar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    public abstract boolean onCreateOptionsMenu();

}
