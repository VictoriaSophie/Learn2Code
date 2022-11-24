package com.example.learn2code;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Lesson extends AppCompatActivity {

    private Button correct_answer_button, wrong_answer_button, view_xp_button;
    private XPDatabase xphandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        correct_answer_button = findViewById(R.id.correct_button);
        wrong_answer_button = findViewById(R.id.wrong_button);
        view_xp_button = findViewById(R.id.view_xp_button);
        xphandler = new XPDatabase(Lesson.this);

        correct_answer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Lesson.this, "you pressed the correct answer", Toast.LENGTH_SHORT).show();
                int current_xp = xphandler.getXP("xp"); // get current xp value
                int updated_xp = current_xp +50;
                xphandler.saveXP("xp", updated_xp); // changes xp
            }
        });

        view_xp_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int current_xp = xphandler.getXP("xp"); // get current xp
                String current_xp_str = String.valueOf(current_xp);
                Toast.makeText(Lesson.this, current_xp_str, Toast.LENGTH_SHORT).show();
            }
        });

    }
}