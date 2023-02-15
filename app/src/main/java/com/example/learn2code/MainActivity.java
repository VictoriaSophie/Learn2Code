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

        Button lesson_button = findViewById(R.id.lesson_button);
        Button crud_button = findViewById(R.id.crud_button);
        Button quiz_button = findViewById(R.id.quizButton);

        lesson_button.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, Lesson.class)));
        crud_button.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, CRUD.class)));
        quiz_button.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, StandardQuiz.class)));

    }
}