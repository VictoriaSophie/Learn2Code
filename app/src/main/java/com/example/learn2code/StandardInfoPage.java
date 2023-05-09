package com.example.learn2code;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.learn2code.data.Information;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class StandardInfoPage extends AppCompatActivity {

    Button cardOneButton, cardTwoButton, cardThreeButton;
    TextView cardOneTitle, cardTwoTitle, cardThreeTitle, cardOneText, cardTwoText, cardThreeText;
    ImageView cardOneImage, cardTwoImage, cardThreeImage;
    Button settings;

    Button startQuizButton;
    //FloatingActionButton home_button = findViewById(R.id.home);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard_info_page);
        setAppBar();

        cardOneTitle=findViewById(R.id.cardOneTitle);
        cardTwoTitle=findViewById(R.id.cardTwoTitle);
        cardThreeTitle=findViewById(R.id.cardThreeTitle);
        cardOneText=findViewById(R.id.cardOneText);
        cardTwoText=findViewById(R.id.cardTwoText);
        cardThreeText=findViewById(R.id.cardThreeText);

        cardOneImage=findViewById(R.id.cardOneImage);
        cardTwoImage=findViewById(R.id.cardTwoImage);
        cardThreeImage=findViewById(R.id.cardThreeImage);

        startQuizButton = findViewById(R.id.startQuizButton);

        Intent intent = getIntent();
        int pageNumber = intent.getIntExtra("pageNumber", 0);
//        switch (pageNumber) {
//            case 0:
//                cardOneTitle.setText("f");
//                break;
//            case 1:
//                cardOneTitle.setText(Information.title[pageNumber][0]);
//                break;
//            case 2:
//                cardOneTitle.setText("number two");
//                break;
//        }
        loadInformation(pageNumber);
    }

    private void loadInformation(int pageNumber) {
//        cardOneButton.setText((CharSequence) Information.buttons[pageNumber]);
        cardOneTitle.setText(Information.title[pageNumber][0]);
        cardTwoTitle.setText(Information.title[pageNumber][1]);
        cardThreeTitle.setText(Information.title[pageNumber][2]);
        cardOneText.setText(Information.cardOneInfo[pageNumber]);
        cardTwoText.setText(Information.cardTwoInfo[pageNumber]);
        cardThreeText.setText(Information.cardThreeInfo[pageNumber]);

        cardOneImage.setImageDrawable(ContextCompat.getDrawable(this, Information.image[pageNumber][0]));
        cardTwoImage.setImageDrawable(ContextCompat.getDrawable(this, Information.image[pageNumber][1]));
        cardThreeImage.setImageDrawable(ContextCompat.getDrawable(this, Information.image[pageNumber][2]));

        startQuizButton.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), StandardQuiz.class).putExtra("quizNumber", pageNumber)));

    }

    private void setAppBar() {
        BottomAppBar bottomAppBar;
        bottomAppBar = findViewById(R.id.bottomAppBar2);
        FloatingActionButton home_button = findViewById(R.id.home);
        CommonMethods.setAppBar(StandardInfoPage.this, bottomAppBar, home_button);
    }

    }