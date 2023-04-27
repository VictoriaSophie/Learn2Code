package com.example.learn2code;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class LessonHtmlBasics extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_one_html);
        Button quiz_button = findViewById(R.id.testButton);
        quiz_button.setOnClickListener(view -> buttonPressed());
    }

    private void buttonPressed() {
        Intent i = new Intent(getBaseContext(), StandardQuiz.class);
        int quizNo = 2;
        i.putExtra("quizNumber", quizNo);
        startActivity(i);
    }
}