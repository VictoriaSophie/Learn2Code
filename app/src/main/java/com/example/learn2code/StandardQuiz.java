package com.example.learn2code;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.learn2code.data.Questions;
import com.example.learn2code.data.XPDatabase;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class StandardQuiz extends AppCompatActivity implements View.OnClickListener {

    TextView questionAmountTextView;
    TextView questionTextView;
    Button ans1, ans2, ans3, ans4;
    Button submitBtn;
    private XPDatabase xphandler;
    int score=0;
    int totalQuestions =0;
    int questionsLeft= 0;
    int startingQuestionIndex = 0;
    String selectedAnswer = "";

    int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard_quiz);
        setAppBar();

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

        Intent intent = getIntent();
        int quizNumber = intent.getIntExtra("quizNumber", 0);
        switch (quizNumber) {
            case 0:
                startingQuestionIndex = 0;
                totalQuestions = 3;
                break;
            case 1:
                startingQuestionIndex = 3;
                totalQuestions = 4;
                break;
            case 2:
                startingQuestionIndex = 7;
                totalQuestions =9;
                break;
            case 3:
                startingQuestionIndex = 16;
                totalQuestions = 2;
                break;
            case 4:
                startingQuestionIndex = 18;
                totalQuestions = 2;
                break;
            case 5:
                startingQuestionIndex = 20;
                totalQuestions = 3;
                break;
            case 6:
                startingQuestionIndex = 23;
                totalQuestions = 5;
                break;
            case 7:
                startingQuestionIndex = 28; // it does not like 28 for some reason
                totalQuestions = 2;
                break;
            case 8:
                startingQuestionIndex =30;
                totalQuestions = 2;
                break;
            case 9:
                startingQuestionIndex =32;
                totalQuestions = 2;
                break;

        }

        questionAmountTextView.setText("Total questions: " + totalQuestions);
        questionsLeft = totalQuestions;
        currentQuestionIndex = startingQuestionIndex;
        loadNewQuestion();
    }

    private void loadNewQuestion() {

        if(questionsLeft == 0){
            finishQuiz();
            return;
        }

        questionTextView.setText(Questions.question[currentQuestionIndex]);
        ans1.setText(Questions.options[currentQuestionIndex][0]);
        ans2.setText(Questions.options[currentQuestionIndex][1]);
        ans3.setText(Questions.options[currentQuestionIndex][2]);
        ans4.setText(Questions.options[currentQuestionIndex][3]);
        if (questionsLeft != totalQuestions) {
            questionAmountTextView.setText("Questions left: " + questionsLeft);
        }
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
        questionsLeft=totalQuestions;
        questionAmountTextView.setText("Total questions: " + totalQuestions);
        currentQuestionIndex=startingQuestionIndex;
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
            questionsLeft--;
            currentQuestionIndex++;
            loadNewQuestion(); // load new question from index +1


        }else{
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.CYAN);

        }

    }
    private void setAppBar() {
        BottomAppBar bottomAppBar;
        bottomAppBar = findViewById(R.id.bottomAppBar2);
        FloatingActionButton home_button = findViewById(R.id.home);
        CommonMethods.setAppBar(StandardQuiz.this, bottomAppBar, home_button);
    }
}