package com.example.learn2code.data;

import android.media.Image;
import android.widget.Button;

import com.example.learn2code.R;

public class Information {
    public static String title[][] = {
            // programming basics
            {"How are websites created?", "What is Learn2Code?", "How do I use this application?"},
            //css basics
            {"What is CSS?",
            "Oops!", "third thing"},

    };

    public static String cardOneInfo[] = {
            "Websites and other applications are created by developers who write code to create any features you see on the screen. There are a variety of programming languages that developers uses which all have their uses and drawbacks.", // programming basics
            "So far, we have learned how to create basic elements on a website but we want our application to look pretty. To do this, we can use CSS (Cascading Style Sheets) which tells the computer how we want to design our website.", // CSS Basics
            "I forgot index starts at 0"

    };

    public static String cardTwoInfo[] = {
            "This application will teach you how to create your very own website. It will give you all the tools and knowledge needed to create any website you want."

    };

    public static String cardThreeInfo[] = {
            "Learn2Code uses a variety of techniques to allow you to read and understand the information which is being given to you. An example of one of these techniques is quizzes, please click the button below to begin your first quiz!"
    };

    public static int[][] image = {
            {R.drawable.building_website, R.drawable.placeholder, R.drawable.placeholder},
            {R.drawable.css_logo}


    };

    public static Button buttons[][] = {

    };
}
