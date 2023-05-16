package com.example.learn2code;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.learn2code.data.Information;

public class StandardInfoPage extends CommonMethods {

    Button cardOneButton, cardTwoButton, cardThreeButton;
    TextView cardOneTitle, cardTwoTitle, cardThreeTitle, cardOneText, cardTwoText, cardThreeText;
    ImageView cardOneImage, cardTwoImage, cardThreeImage, cardOneLargeImage, cardTwoLargeImage, cardThreeLargeImage;
    ProgressBar progressBar;


    Button startQuizButton;
    //FloatingActionButton home_button = findViewById(R.id.home);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        progressBar=findViewById(R.id.progressBar);

        cardOneButton=findViewById(R.id.cardOneButton);
        cardTwoButton=findViewById(R.id.cardTwoButton);
        cardThreeButton=findViewById(R.id.cardThreeButton);

        cardOneTitle=findViewById(R.id.cardOneTitle);
        cardTwoTitle=findViewById(R.id.cardTwoTitle);
        cardThreeTitle=findViewById(R.id.cardThreeTitle);
        cardOneText=findViewById(R.id.cardOneText);
        cardTwoText=findViewById(R.id.cardTwoText);
        cardThreeText=findViewById(R.id.cardThreeText);

        cardOneImage=findViewById(R.id.cardOneImage);
        cardTwoImage=findViewById(R.id.cardTwoImage);
        cardThreeImage=findViewById(R.id.cardThreeImage);
        cardOneLargeImage=findViewById(R.id.cardOneLargeImage);
        cardTwoLargeImage=findViewById(R.id.cardTwoLargeImage);
        cardThreeLargeImage=findViewById(R.id.cardThreeLargeImage);

        startQuizButton = findViewById(R.id.startQuizButton);

        Intent intent = getIntent();
        int pageNumber = intent.getIntExtra("pageNumber", 0);
        loadInformation(pageNumber);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_standard_info_page;
    }

    @Override
    public boolean onCreateOptionsMenu() {
        return false;
    }

    private void loadInformation(int pageNumber) {
        cardOneTitle.setText(Information.title[pageNumber][0]);
        cardTwoTitle.setText(Information.title[pageNumber][1]);
        cardThreeTitle.setText(Information.title[pageNumber][2]);
        cardOneText.setText(Information.cardOneInfo[pageNumber]);
        cardTwoText.setText(Information.cardTwoInfo[pageNumber]);
        cardThreeText.setText(Information.cardThreeInfo[pageNumber]);

        cardOneImage.setImageDrawable(ContextCompat.getDrawable(this, Information.image[pageNumber][0]));
        cardTwoImage.setImageDrawable(ContextCompat.getDrawable(this, Information.image[pageNumber][1]));
        cardThreeImage.setImageDrawable(ContextCompat.getDrawable(this, Information.image[pageNumber][2]));
        cardOneLargeImage.setImageDrawable(ContextCompat.getDrawable(this, Information.image[pageNumber][0]));
        cardTwoLargeImage.setImageDrawable(ContextCompat.getDrawable(this, Information.image[pageNumber][1]));
        cardThreeLargeImage.setImageDrawable(ContextCompat.getDrawable(this, Information.image[pageNumber][2]));
        if (Information.buttons[pageNumber][0].isEmpty()) {
            cardOneButton.setVisibility(View.INVISIBLE);
            cardOneImage.setVisibility(View.INVISIBLE);
        }
        if (Information.buttons[pageNumber][1].isEmpty()) {
            cardTwoButton.setVisibility(View.INVISIBLE);
            cardTwoImage.setVisibility(View.INVISIBLE);
        }
        if (Information.buttons[pageNumber][2].isEmpty()) {
            cardThreeButton.setVisibility(View.INVISIBLE);
            cardThreeImage.setVisibility(View.INVISIBLE);
        } else {
            cardThreeLargeImage.setVisibility(View.INVISIBLE);
            startQuizButton.setVisibility(View.INVISIBLE);
            progressBar.setProgress(33);
            cardThreeButton.setOnClickListener(v -> {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(Information.buttons[pageNumber][2]));
                startActivity(i);
                progressBar.setProgress(66);
                startQuizButton.setVisibility(View.VISIBLE);
            });
        }


        startQuizButton.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), StandardQuiz.class).putExtra("quizNumber", pageNumber)));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

}