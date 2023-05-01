package com.example.learn2code.data;

import android.media.Image;
import android.widget.Button;

import com.example.learn2code.R;

public class Information {
    public static String title[][] = {
            // programming basics
            {"How are websites created?", "What is Learn2Code?", "How do I use this application?"},
            // HTML Basics
            {"Introduction to HTML", "History", "Structure"},
            //css basics
            {"What is CSS?",
            "Oops!", "third thing"},

    };

    // card info has to be around 210 characters or less

    public static String cardOneInfo[] = {
            "Websites and other applications are created by developers who write code to create any features you see on the screen. There are a variety of programming languages that developers uses which all have their uses and drawbacks.", // programming basics
            "HTML stands for Hypertext markup language and is used to create and structure websites. It is not considered an official programming language but is usually used with programming languages such as JavaScript and PHP to create a functional website.", // HTML basics
            "So far, we have learned how to create basic elements on a website but we want our application to look pretty. To do this, we can use CSS (Cascading Style Sheets) which tells the computer how we want to design our website.", // CSS Basics
            "I forgot index starts at 0"

    };

    public static String cardTwoInfo[] = {
            "This application will teach you how to create your very own website. It will give you all the tools and knowledge needed to create any website you want.", // P Basics
            "HTML has been used since 1993 and was written by Tim Berners-Lee. It was originally developed to support linking between online resources.", // HTML basics

    };

    public static String cardThreeInfo[] = {
            "Learn2Code uses a variety of techniques to allow you to read and understand the information you need. An example of one of these techniques is quizzes, please click the button below to begin your first quiz!", // P basics
            "A HTML document always begins with <!DOCTYPE> to define the document to the computer, then the rest of the code is placed in a HTML tag: <html> information </html>. The <body> tag contains all the information a user can see.",
            };

    public static int[][] image = {
            {R.drawable.building_website, R.drawable.placeholder, R.drawable.placeholder},
            {R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder},
            {R.drawable.css_logo}


    };

    public static Button buttons[][] = {

    };
}
