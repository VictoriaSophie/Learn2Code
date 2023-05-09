package com.example.learn2code.data;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Questions {
    public static String question[] = {
            // programming basics
            "What does a programming language do?",
            "What does a markup language do?",
            "Which of the options are NOT a programming language?",
            // html basics
            "What character is commonly used to identify a tag in HTML?",
            "What is HTML most commonly used for?",
            "What is the opening tag for a paragraph element?",
            "Where should <!DOCTYPE html> be placed?",
            // html 1
            "What character is used to close tags?",
            "What is the correct opening tag for creating a paragraph?",
            "What is the correct opening tag for creating the largest heading?",
            "What is the correct opening tag for creating important text (bold)?",
            "What is the correct opening tag for creating a line break?",
            "What is the correct opening tag for creating an image?",
            "What is the correct opening tag for creating a list?",
            "What is the correct opening tag for creating a list item?",
            "What is the correct opening tag for creating a link?",
            // html 2
            "What attribute is necessary within an image element?",
            "What attribute is necessary within a link element?",
            // js basics
            "Which of the following is considered a programming language?"
    };

    public static String options[][] = {
            {"Present information for a browser to interpret", "Give instructions to a computer to produce an output", "A set of information that allows people to choose which TV show to watch", "idk"}, {"Present information for a browser to interpret", "Give instructions to a computer to produce an output", "A set of information that allows people to choose which TV show to watch", "idk"}, {"Java", "JavaScript", "HTML", "Python"},
            {"<", "!", "/", ";"}, {"Creating websites", "Machine learning", "Developing applications", "Databases"}, {"<h1>", "<paragraph>", "p", "<p>"}, {"Anywhere on the page", "Top of the document", "Bottom of the document", "Within an HTML tag"},
            {"<", "!", "/", ";"}, {"<h1>", "<p>", "<br>", "<strong>"}, {"<h1>", "<p>", "<br>", "<strong>"}, {"<h1>", "<p>", "<br>", "<strong>"}, {"<h1>", "<p>", "<br>", "<strong>"}, {"<a>", "<img>", "<ul>", "<li>"}, {"<a>", "<img>", "<ul>", "<li>"}, {"<a>", "<img>", "<ul>", "<li>"}, {"<a>", "<img>", "<ul>", "<li>"},
            {"href", "src"}, {"href", "src"},  // html 2
            {"CSS", "JavaScript", "HTML"}, // js b
    };

    public static String answers[] = {
            "Give instructions to a computer to produce an output", "Present information for a browser to interpret", "HTML", // prog basics
            "<", "Creating websites", "<p>", "Top of the document", // html basics
            "/", "<p>", "<h1>", "<strong>", "<br>", "<img>", "<ul>", "<li>", "<a>",// html 1
            "src", "href", // html 2

            "JavaScript" // javascript basics

    };

}
