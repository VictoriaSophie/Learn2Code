package com.example.learn2code;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class LessonProgrammingBasics extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_programming_basics);
        setAppBar();
        Button quiz_button = findViewById(R.id.startButton);
        quiz_button.setOnClickListener(view -> CommonMethods.beginQuiz(LessonProgrammingBasics.this, 1));
    }
    private void setAppBar() {
        BottomAppBar bottomAppBar;
        bottomAppBar = findViewById(R.id.bottomAppBar2);
        FloatingActionButton home_button = findViewById(R.id.home);
        CommonMethods.setAppBar(LessonProgrammingBasics.this, bottomAppBar, home_button);
    }
}