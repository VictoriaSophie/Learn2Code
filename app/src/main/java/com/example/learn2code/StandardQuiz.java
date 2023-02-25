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
//    String txt;
//    private Button butNext;
//    private Button radioButtonA, radioButtonB, radioButtonC, radioButtonD;
//
//    private TextView question, newQuestionNumber, text1, text2, text3, text4;
//    private int questionNumber = 0; // tracks what question we are on
//    private int correctAnswer = 0;
//    private List<String> questions;
//    private Map<String, Map<String, Boolean>> questionsAnswerMap;
//    private ArrayList<String> getQuestionsAnswerMap;
//
//    private ProgressBar progressBar;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_standard_quiz);
//        //Intent intent = getIntent();
//
//        questionsAnswerMap = Questions.getQuestions();
//        initView();
//        //optionClickA();
////        optionClickB();
////        optionClickC();
////        optionClickD();
////
//        findViewById(R.id.nextButton).setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                if (!txt.isEmpty()) {
//                    boolean answer = questionsAnswerMap.get(questions.get(questionNumber)).get(txt);
//                    if (answer) {
//                        correctAnswer++;
//                    }
//                    questionNumber++;
//                    optionsClear();
//                }
//                if (butNext.getText().equals("Next")) {
//                    displayNextQuestions();
//                } else {
//                    // result page Intent intentResults = new Intent(StandardQuiz.this, )
//                }
//            }
//        });
////
//        displayData();
//
//    }
//
//    private void optionsClear() {
//        txt = "";
//    }
//
//    private void displayData() {
//    }
//
//    private void displayNextQuestions() {
//        setAnswerstoOptions();
//        question.setText(questions.get(questionNumber));
//        newQuestionNumber.setText("" + (questionNumber + 1));
//        progressBar.setProgress(questionNumber * 10);
//        progressBar.setMax(100);
//
//        // when finished qs
//    }
//
//    private void setAnswerstoOptions() {
//        ArrayList<String> questionKey = new ArrayList(questionsAnswerMap.get(questions.get(questionNumber)).keySet());
//
//        radioButtonA.setText(questionKey.get(0));
//        radioButtonB.setText(questionKey.get(1));
//        radioButtonC.setText(questionKey.get(2));
//        radioButtonD.setText(questionKey.get(3));
//    }
//
//    private void optionClickD() {
//        radioButtonD.setOnClickListener( v -> {
//            txt = text4.getText().toString();
//        });
//    }
//
//    private void optionClickC() {
//        radioButtonC.setOnClickListener( v -> {
//            txt = text3.getText().toString();
//        });
//    }
//
//    private void optionClickB() {
//        radioButtonB.setOnClickListener( v -> {
//            txt = text2.getText().toString();
//        });
//    }
//
//    private void optionClickA() {
//        //radioButtonA.setText()
//        //});
//    }
//
//    public void onRadioButtonClicked(View view) {
//        boolean checked = ((RadioButton) view).isChecked();
//        switch(view.getId()) {
//            case R.id.radioButtonOptionC:
//                if (checked) {
//                    Toast toastC = Toast.makeText(getApplicationContext(), "button C pressed", Toast.LENGTH_LONG);
//                    toastC.show();
//                }
//                break;
//            case R.id.radioButtonOptionA:
//                if (checked) {
//                    Toast toastA = Toast.makeText(getApplicationContext(), "button A pressed", Toast.LENGTH_LONG);
//                    toastA.show();
//                }
//                break;
//            case R.id.radioButtonOptionB:
//                if (checked) {
//                    Toast toastB = Toast.makeText(getApplicationContext(), "button B pressed", Toast.LENGTH_LONG);
//                    toastB.show();
//                }
//                break;
//            case R.id.radioButtonOptionD:
//                if (checked) {
//                    Toast toastD = Toast.makeText(getApplicationContext(), "button D pressed", Toast.LENGTH_LONG);
//                    toastD.show();
//                }
//                break;

//        }
//    }
//
//    private void initView() {
//        View radioButtonA = findViewById(R.id.radioButtonOptionA);
//        View radioButtonB = findViewById(R.id.radioButtonOptionA);
//        View radioButtonC = findViewById(R.id.radioButtonOptionA);
//        View radioButtonD = findViewById(R.id.radioButtonOptionA);
//        txt = "";
//        questions = new ArrayList<>(questionsAnswerMap.keySet());
//
//        question = findViewById(R.id.QuestionText);
//
//    }
    TextView questionAmountTextView;
    TextView questionTextView;
    Button ans1, ans2, ans3, ans4;
    Button submitBtn;

    int score=0;
    int totalQuestions= Questions.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard_quiz);

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
        if (score > totalQuestions*0.60) {
            passStatus = "Passed";
        }else{
            passStatus = "Failed";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is " + score + " out of " + totalQuestions)
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