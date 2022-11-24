package com.example.learn2code;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CRUD extends AppCompatActivity {

    private EditText question_edit, wrong_answer_edit, correct_answer_edit;
    private Button add_question_button;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);

        // initialising variables
        question_edit = findViewById(R.id.edit_question);
        wrong_answer_edit = findViewById(R.id.edit_wrong_ans);
        correct_answer_edit = findViewById(R.id.edit_right_ans);
        add_question_button = findViewById(R.id.add_q_button);

        dbHandler = new DBHandler(CRUD.this);

        add_question_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // getting data
                String question = question_edit.getText().toString();
                String wrongAnswer = wrong_answer_edit.getText().toString();
                String correctAnswer = correct_answer_edit.getText().toString();

                // validate data
                if (question.isEmpty() && wrongAnswer.isEmpty() && correctAnswer.isEmpty()) {
                    Toast.makeText(CRUD.this, "Please fill in everything.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // call method to add question to db
                dbHandler.addNewQuestion(question, wrongAnswer, correctAnswer);
                Toast.makeText(CRUD.this, "Question has been added to database.", Toast.LENGTH_LONG).show();
                // reset
                question_edit.setText("");
                wrong_answer_edit.setText("");
                correct_answer_edit.setText("");
            }
        });
    }
}