package com.example.learn2code;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class HTMLBasicsLesson extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_one_html);
        Button quiz_button = findViewById(R.id.testButton);
        quiz_button.setOnClickListener(view -> startActivity(new Intent(HTMLBasicsLesson.this, StandardQuiz.class)));
    }
}