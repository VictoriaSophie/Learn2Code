package com.example.learn2code;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

//    BottomAppBar bottomAppBar;
//    FloatingActionButton home_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        bottomAppBar=findViewById(R.id.bottomAppBar2);
//        home_button=findViewById(R.id.home);
//        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                if (item.getItemId()==R.id.settings)
//                {
//                    Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_LONG).show();
//                }
//                return false;
//            }
//        });
//        home_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//             Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_LONG).show();
//            }
//        });

        Button html_button = findViewById(R.id.htmlBasics_button);
        html_button.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, LessonOneHTML.class)));
//        Toolbar toolbar;
//        toolbar = findViewById(R.id.bottomAppBar2);
//        setSupportActionBar(toolbar);

    }
}