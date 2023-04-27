package com.example.learn2code;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAppBar();

        Button html_button = findViewById(R.id.htmlBasics_button);

        Button programming_basics= findViewById(R.id.programmingBasics_button);

        html_button.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, LessonHtmlBasics.class)));

        programming_basics.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, LessonProgrammingBasics.class)));
    }

    private void setAppBar() {
        BottomAppBar bottomAppBar;
        bottomAppBar = findViewById(R.id.bottomAppBar2);
        FloatingActionButton home_button = findViewById(R.id.home);
        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.settings) {
                    Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        bottomAppBar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "back", Toast.LENGTH_SHORT).show();

            }
        });
        home_button.setOnClickListener(view -> Toast.makeText(MainActivity.this, "Home button", Toast.LENGTH_LONG).show());

    }
}