package com.example.learn2code;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StandardQuiz extends AppCompatActivity {
    String txt;
    private Button butNext;
    private CardView radioButtonA, radioButtonB, radioButtonC, radioButtonD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard_quiz);
        Intent intent = getIntent();

        initView();
        variantClickA();
        variantClickB();
        variantClickC();
        variantClickD();

        findViewById(R.id.nextButton).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (!txt.isEmpty()) {
                    // get answer
                    // if answer right, add one
                }
                if (butNext.getText().equals("Next")) {
                    displayNextQuestions();
                } // else results
            }
        });

        displayData();

    }

    private void displayData() {
    }

    private void displayNextQuestions() {
    }

    private void variantClickD() {
        radioButtonD.setOnClickListener( v -> {

        });
    }

    private void variantClickC() {
    }

    private void variantClickB() {
    }

    private void variantClickA() {
    }

    private void initView() {
    }
}