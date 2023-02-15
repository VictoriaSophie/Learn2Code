package com.example.learn2code;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StandardQuiz extends AppCompatActivity {
    String txt;
    private Button butNext;
    private Button radioButtonA, radioButtonB, radioButtonC, radioButtonD;

    private TextView question, newQuestionNumber, text1, text2, text3, text4;
    private int questionNumber = 0; // tracks what question we are on
    private int correctAnswer = 0;
    private List<String> questions;
    private Map<String, Map<String, Boolean>> questionsAnswerMap;
    private ArrayList<String> getQuestionsAnswerMap;

    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard_quiz);
        //Intent intent = getIntent();

        questionsAnswerMap = Questions.getQuestions();
        initView();
        //optionClickA();
//        optionClickB();
//        optionClickC();
//        optionClickD();
//
        findViewById(R.id.nextButton).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (!txt.isEmpty()) {
                    boolean answer = questionsAnswerMap.get(questions.get(questionNumber)).get(txt);
                    if (answer) {
                        correctAnswer++;
                    }
                    questionNumber++;
                    optionsClear();
                }
                if (butNext.getText().equals("Next")) {
                    displayNextQuestions();
                } else {
                    // result page Intent intentResults = new Intent(StandardQuiz.this, )
                }
            }
        });
//
        displayData();

    }

    private void optionsClear() {
        txt = "";
    }

    private void displayData() {
    }

    private void displayNextQuestions() {
        setAnswerstoOptions();
        question.setText(questions.get(questionNumber));
        newQuestionNumber.setText("" + (questionNumber + 1));
        progressBar.setProgress(questionNumber * 10);
        progressBar.setMax(100);

        // when finished qs
    }

    private void setAnswerstoOptions() {
        ArrayList<String> questionKey = new ArrayList(questionsAnswerMap.get(questions.get(questionNumber)).keySet());

        radioButtonA.setText(questionKey.get(0));
        radioButtonB.setText(questionKey.get(1));
        radioButtonC.setText(questionKey.get(2));
        radioButtonD.setText(questionKey.get(3));
    }

    private void optionClickD() {
        radioButtonD.setOnClickListener( v -> {
            txt = text4.getText().toString();
        });
    }

    private void optionClickC() {
        radioButtonC.setOnClickListener( v -> {
            txt = text3.getText().toString();
        });
    }

    private void optionClickB() {
        radioButtonB.setOnClickListener( v -> {
            txt = text2.getText().toString();
        });
    }

    private void optionClickA() {
        //radioButtonA.setText()
        //});
    }

    private void initView() {
        View radioButtonA = findViewById(R.id.radioButtonOptionA);
        View radioButtonB = findViewById(R.id.radioButtonOptionA);
        View radioButtonC = findViewById(R.id.radioButtonOptionA);
        View radioButtonD = findViewById(R.id.radioButtonOptionA);
        txt = "";
        questions = new ArrayList<>(questionsAnswerMap.keySet());

        question = findViewById(R.id.QuestionText);

    }
}