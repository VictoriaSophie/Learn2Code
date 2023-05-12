package com.example.learn2code;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;

public class MainActivity extends CommonMethods {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Toolbar bottomToolbar = findViewById(R.id.bottomAppBar2);
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

    @Override
    public int getLayoutResource() {
        return R.layout.activity_main;
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

}