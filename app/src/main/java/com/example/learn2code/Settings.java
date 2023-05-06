package com.example.learn2code;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button logoutButton = findViewById(R.id.logoutButton);

        logoutButton.setOnClickListener(view -> startActivity(new Intent(Settings.this, LogIn.class)));
    }
}