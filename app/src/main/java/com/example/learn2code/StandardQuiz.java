package com.example.learn2code;

import static android.content.ContentValues.TAG;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.learn2code.data.Questions;
import com.example.learn2code.data.XPDatabase;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class StandardQuiz extends CommonMethods implements View.OnClickListener {

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
    ProgressBar progressBar;
    int progressNo, progressMultiple;

    int currentQuestionIndex = 0;

    FirebaseAuth auth;
    FirebaseUser user;
    String userName;
    String passStatus;
    String userXP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_standard_quiz);
//        setAppBar();
        FirebaseApp.initializeApp(this);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        xphandler = new XPDatabase(StandardQuiz.this);
        progressBar = findViewById(R.id.progressBar);
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
            case 0: //b
                startingQuestionIndex = 0;
                totalQuestions = 3;
                break;
            case 1: // html
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
            case 4: //css
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
            case 7: // js
                startingQuestionIndex = 28;
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

        questionAmountTextView.setText("Total questions: "  + totalQuestions);
        questionsLeft = totalQuestions;
        currentQuestionIndex = startingQuestionIndex;
        progressMultiple = 100/totalQuestions;
        progressNo = progressMultiple;
        loadNewQuestion();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_standard_quiz;
    }

    @Override
    public boolean onCreateOptionsMenu() {
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
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
        progressBar.setProgress(progressNo);
    }

    private void finishQuiz() {
        String passStatus =  "";
        int xp = xphandler.getXP("xp"); // get current xp value
        if (score > totalQuestions*0.60) {
            passStatus = "Passed";
            // add 50 xp
            xp +=50;
            xphandler.saveXP("xp", xp); // changes xp
//            if (user != null) {
//                String userId = user.getUid();
//                String userName = user.getDisplayName();
//                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference();
//                dataRef.child("users").child(userId).child("xp").setValue(xp);
//                String userXP = dataRef.child("users").child(userId).child("xp").getValue();
//                Toast.makeText(StandardQuiz.this, "User: " + userName + ", XP: " + userXP, Toast.LENGTH_SHORT ).show();
//            }
//            if (user != null) {
//                String userId = user.getUid();
//                userName = user.getDisplayName();
//                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference();
//                // Set the ValueEventListener to retrieve the "xp" value
//                dataRef.child("users").child(userId).child("xp").addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        // Retrieve the "xp" value from the dataSnapshot
//                        String userXP = dataSnapshot.getValue(String.class);
//
//                        // Display the retrieved data
//                        Toast.makeText(StandardQuiz.this, "User: " + userName + ", XP: " + userXP, Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//                        // Handle the error, if any
//                        Toast.makeText(StandardQuiz.this, "Failed to retrieve data: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });


//            } else {
//                Toast.makeText(this, "User is null", Toast.LENGTH_SHORT).show();
//            }



        }else{
            passStatus = "Failed";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
//                .setMessage("User: " + userName + ", XP: " + userXP)
                .setMessage("Score is " + score + " out of " + totalQuestions + "\n" + "Your current XP is: " + xp)
                .setPositiveButton("Restart", (dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();
    }


    private void restartQuiz() {
        score = 0;
        progressNo = progressMultiple;
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
            progressNo = progressNo + progressMultiple;
            questionsLeft--;
            currentQuestionIndex++;
            loadNewQuestion(); // load new question from index +1


        }else{
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.CYAN);

        }

    }
}