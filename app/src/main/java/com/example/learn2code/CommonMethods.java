package com.example.learn2code;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CommonMethods {

    public static void beginQuiz(Context givenContext, int quizNo) {
        Intent i = new Intent(givenContext, StandardQuiz.class);
        i.putExtra("quizNumber", quizNo);
        givenContext.startActivity(i);
    }

    public static void setAppBar(Context givenContext, BottomAppBar bottomAppBar, FloatingActionButton home_button) {
        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.settings) {
                    Toast.makeText(givenContext, "Settings", Toast.LENGTH_SHORT).show();
                    //Toast.makeText(givenContext, "Settings", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(givenContext, Settings.class);
                    givenContext.startActivity(i);
                    return true;
                }
                return false;
            }
        });

        bottomAppBar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(givenContext, "back", Toast.LENGTH_SHORT).show();

            }
        });
//        home_button.setOnClickListener(view -> Toast.makeText(givenContext, "Home button", Toast.LENGTH_LONG).show());
        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(givenContext, MainActivity.class);
                givenContext.startActivity(i);
            }
        });

        // to do: make back button go back
        bottomAppBar.getChildAt(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(givenContext, MainActivity.class);
                givenContext.startActivity(i);
            }
        });
    }
//
//    private static void changeActivity(Context givenContext) {
//        Intent i = new Intent(givenContext, MainActivity.class);
//        givenContext.startActivity(i);
//    }

}
