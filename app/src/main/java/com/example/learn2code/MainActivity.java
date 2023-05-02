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

        Button programming_basics= findViewById(R.id.programmingBasics_button);
        Button html_button = findViewById(R.id.htmlBasics_button);
        Button html_one = findViewById(R.id.htmlOne_button);
        Button html_two = findViewById(R.id.htmlTwo_button);
        Button css_basics= findViewById(R.id.cssBasics_button);
        Button css_one = findViewById(R.id.cssOne_button);
        Button css_two = findViewById(R.id.cssTwo_button);
        Button javascript_basics = findViewById(R.id.javascriptBasics_button);
        Button javascript_one = findViewById(R.id.javascriptOne_button);
        Button javascript_two = findViewById(R.id.javascriptTwo_button);

        programming_basics.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, StandardInfoPage.class).putExtra("pageNumber", 0)));
        html_button.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, StandardInfoPage.class).putExtra("pageNumber", 1)));
        html_one.setOnClickListener(view-> startActivity(new Intent(MainActivity.this, StandardInfoPage.class).putExtra("pageNumber", 2)));
        html_two.setOnClickListener(view-> startActivity(new Intent(MainActivity.this, StandardInfoPage.class).putExtra("pageNumber", 3)));
        css_basics.setOnClickListener(view -> startActivity(new Intent (MainActivity.this, StandardInfoPage.class).putExtra("pageNumber", 4)));
        css_one.setOnClickListener(view -> startActivity(new Intent (MainActivity.this, StandardInfoPage.class).putExtra("pageNumber", 5)));
        css_two.setOnClickListener(view -> startActivity(new Intent (MainActivity.this, StandardInfoPage.class).putExtra("pageNumber", 6)));
        javascript_basics.setOnClickListener(view -> startActivity(new Intent (MainActivity.this, StandardInfoPage.class).putExtra("pageNumber", 7)));
        javascript_one.setOnClickListener(view -> startActivity(new Intent (MainActivity.this, StandardInfoPage.class).putExtra("pageNumber", 8)));
        javascript_two.setOnClickListener(view -> startActivity(new Intent (MainActivity.this, StandardInfoPage.class).putExtra("pageNumber", 9)));

    }

    private void setAppBar() {
        BottomAppBar bottomAppBar;
        bottomAppBar = findViewById(R.id.bottomAppBar2);
        FloatingActionButton home_button = findViewById(R.id.home);
        CommonMethods.setAppBar(MainActivity.this, bottomAppBar, home_button);
    }

}