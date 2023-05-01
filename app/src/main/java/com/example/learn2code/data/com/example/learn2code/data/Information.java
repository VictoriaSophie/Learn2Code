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
            // HTML 1
            {"Elements", "Text Elements", "Other Elements"},
            // HTML 2
            {"1", "2", "3"},
            //css basics
            {"CSS (Cascading Style Sheets)", "Oops!", "third thing"},
            // css 1
            {"1", "2", "3"},
            // css 2
            {"1", "2", "3"},
            // js basic
            {"What is JavaScript?", "Why JavaScript", "How is JavaScript useful?"}
            // js 1
            // js 2

    };

    // card info has to be around 210 characters or less

    public static String cardOneInfo[] = {
            "Websites and other applications are created by developers who write code to create any features you see on the screen. There are a variety of programming languages that developers uses which all have their uses and drawbacks.", // programming basics
            "HTML stands for Hypertext markup language and is used to create and structure websites. It is not considered an official programming language but is usually used with programming languages such as JavaScript.", // HTML basics
            "HTML uses different elements to create different items on your webpage. There are 111 (as of 2022) elements you can use to make an interesting website. An HTML element is defined using tags.", // HTML 1
            "I forgot index starts at 0", // HTML 2
            "So far, we have learned how to create basic elements on a website but we want our application to look pretty. To do this, we can use CSS which tells the computer how we want to design our website.", // CSS Basics
            "css 1", // css 1
            "css 2", // css 2
            "JavaScript is a programming language used to create interactive web pages. HTML and CSS are not technically programming languages so JavaScript will be the first programming language you learn.", // js basics
            // js 1
            // js 2

    };

    public static String cardTwoInfo[] = {
            "This application will teach you how to create your very own website. It will give you all the tools and knowledge needed to create any website you want.", // P Basics
            "HTML has been used since 1993 and was written by Tim Berners-Lee. It was originally developed to support linking between online resources.", // HTML basics
            "<h1> Heading </h1>\n<p> Paragraph </p>\n<br> Line break\n<strong> Important Text </strong>", // HTML 1
            "HI LISM", // HTML 2
            "CSS basics",// CSS basics
            "css 1", // css 1
            "css 2", // css 2
            "JavaScript is the most popular programming language and it allows you to program the behaviour of a website. This means JavaScript allows you to create buttons or change the content you've created on HTML."// js b
            // js 1
            // js 2

    };

    public static String cardThreeInfo[] = {
            "Learn2Code uses a variety of techniques to allow you to read and understand the information you need. An example of one of these techniques is quizzes, please click the button below to begin your first quiz!", // P basics
            "A HTML document always begins with <!DOCTYPE> to define the document to the computer, then the rest of the code is placed in a HTML tag: <html> information </html>. The <body> tag contains all the information a user can see.", // HTML b
            "<a href= https://> Link </a>\n<img src='.jpg' alt= 'Image'>\n<ul> List </ul>\n<li> List Item </li>",
            "HI LIM", // html 2
            "css b", // css b
            "css 1", // css 1
            "css 2", // css 2
            "The information so far, might seem a little abstract. In more detail, JavaScript allows you to choose what HTML element you want and change the content of it, such as choosing a text box and changing the words to something else.", // js b
            // js 1
            // js 2
            };

    public static int[][] image = {
            {R.drawable.building_website, R.drawable.placeholder, R.drawable.placeholder}, // p basic
            {R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder}, // html basic
            {R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder}, // html 1
            {R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder}, // html 2
            {R.drawable.css_logo, R.drawable.placeholder, R.drawable.placeholder}, // css b
            {R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder}, // css 1
            {R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder}, // css 2
            {R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder}, // js b
            {R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder}, // js 1
            {R.drawable.placeholder, R.drawable.placeholder, R.drawable.placeholder}, // js 2

    };

    public static Button buttons[][] = {

    };
}