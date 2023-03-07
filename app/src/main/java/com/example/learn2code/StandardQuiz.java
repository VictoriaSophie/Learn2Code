package com.example.learn2code;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StandardQuiz extends AppCompatActivity implements View.OnClickListener {

    TextView questionAmountTextView;
    TextView questionTextView;
    Button ans1, ans2, ans3, ans4;
    Button submitBtn;
    private XPDatabase xphandler;

    int score=0;
    int totalQuestions= Questions.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard_quiz);

        xphandler = new XPDatabase(StandardQuiz.this);
        questionAmountTextView =findViewById(R.id.totalQuestions);
        questionTextView=findViewById(R.id.question);
        ans1=findViewById(R.id.AnswerOne);
        ans2=findViewById(R.id.AnswerTwo);
        ans3=findViewById(R.id.AnswerThree);
        ans4=findViewById(R.id.AnswerFour);
        submitBtn=findViewById(R.id.submitButton);

        ans1.setOnClickListener(this);
        ans2.setOnClickListener(this);
        ans3.setOnClickListener(this);
        ans4.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        questionAmountTextView.setText("Total questions: " + totalQuestions);

        loadNewQuestion();
    }

    private void loadNewQuestion() {

        if(currentQuestionIndex== totalQuestions){
            finishQuiz();
            return;

        }

        questionTextView.setText(Questions.question[currentQuestionIndex]);
        ans1.setText(Questions.options[currentQuestionIndex][0]);
        ans2.setText(Questions.options[currentQuestionIndex][1]);
        ans3.setText(Questions.options[currentQuestionIndex][2]);
        ans4.setText(Questions.options[currentQuestionIndex][3]);



    }

    private void finishQuiz() {
        String passStatus =  "";
        int xp = xphandler.getXP("xp"); // get current xp value
        if (score > totalQuestions*0.60) {
            passStatus = "Passed";
            // add 50 xp
            xp +=50;
            xphandler.saveXP("xp", xp); // changes xp


        }else{
            passStatus = "Failed";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is " + score + " out of " + totalQuestions + "\n" + "Your current XP is: " + xp)
                .setPositiveButton("Restart", (dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();
    }

    private void restartQuiz() {
        score = 0;
        currentQuestionIndex=0;
        loadNewQuestion();

    }

    @Override
    public void onClick(View view) {

        ans1.setBackgroundColor(Color.WHITE);
        ans2.setBackgroundColor(Color.WHITE);
        ans3.setBackgroundColor(Color.WHITE);
        ans4.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.submitButton){
            if(selectedAnswer.equals(Questions.answers[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion(); // load new question from index +1


        }else{
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.CYAN);

        }

    }
}