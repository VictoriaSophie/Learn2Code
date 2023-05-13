package com.example.learn2code;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ProfilePicture extends CommonMethods {

    Button blueButton, tealButton, whiteButton, blackButton;
    ImageView cookieIcon, bunnyIcon, cakeIcon, fireIcon, curlyIcon, straightIcon, baldIcon, hairIcon, currentPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutResource();

        blueButton = findViewById(R.id.blueButton);
        tealButton = findViewById(R.id.tealButton);
        whiteButton = findViewById(R.id.whiteButton);
        blackButton = findViewById(R.id.blackButton);
//        cookieIcon = findViewById(R.id.cookieIcon);
//        bunnyIcon = findViewById(R.id.bunnyIcon);
//        cakeIcon = findViewById(R.id.cakeIcon);
//        fireIcon = findViewById(R.id.fireIcon);
//        curlyIcon = findViewById(R.id.curlyIcon);
//        straightIcon = findViewById(R.id.straightIcon);
//        baldIcon = findViewById(R.id.baldIcon);
//        hairIcon = findViewById(R.id.hairIcon);
        currentPic = findViewById(R.id.currentPic);
        blueButton.setOnClickListener(clickListener);
        tealButton.setOnClickListener(clickListener);
        whiteButton.setOnClickListener(clickListener);
        blackButton.setOnClickListener(clickListener);
//        cookieIcon.setOnClickListener(clickListener);
//        bunnyIcon.setOnClickListener(clickListener);
//        cakeIcon.setOnClickListener(clickListener);
//        fireIcon.setOnClickListener(clickListener);
//        curlyIcon.setOnClickListener(clickListener);
//        straightIcon.setOnClickListener(clickListener);
//        baldIcon.setOnClickListener(clickListener);
//        hairIcon.setOnClickListener(clickListener);


    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_profile_picture;
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

    View.OnClickListener clickListener = new View.OnClickListener() {
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.blueButton:
                    currentPic.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.purple_500));
                    break;
                case R.id.tealButton:
                    currentPic.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.teal_200));
                    break;
                case R.id.whiteButton:
                    currentPic.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white));
                    break;
                case R.id.blackButton:
                    currentPic.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.black));
                    break;
                    // images
//                case R.id.cookieIcon:
//                    break;
//                case R.id.bunnyIcon:
//                    break;
//                case R.id.cakeIcon:
//                    break;
//                case R.id.fireIcon:
//                    break;
//                case R.id.curlyIcon:
//                    break;
//                case R.id.straightIcon:
//                    break;
//                case R.id.baldIcon:
//                    break;
//                case R.id.hairIcon:
//                    break;

            }


        }
    };
}