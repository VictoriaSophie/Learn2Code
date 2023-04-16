package com.example.learn2code;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button html_button = findViewById(R.id.htmlBasics_button);

        html_button.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, LessonOneHTML.class)));
    }
}