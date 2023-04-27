package com.example.learn2code;

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
            "What character is used to close tags?",
    };

    public static String options[][] = {
            {"Present information for a browser to interpret", "Give instructions to a computer to produce an output", "A set of information that allows people to choose which TV show to watch", "idk"},
            {"Present information for a browser to interpret", "Give instructions to a computer to produce an output", "A set of information that allows people to choose which TV show to watch", "idk"},
            {"Java", "JavaScript", "HTML", "Python"},
            {"<", "!", "/", ";"},
            {"Creating websites", "Machine learning", "Developing applications", "Databases"},
            {"<h1>", "<paragraph>", "p", "<p>"},
            {"Anywhere on the page", "Top of the document", "Bottom of the document", "Within an HTML tag"},
            {"<", "!", "/", ";"},
    };

    public static String answers[] = {
            "Give instructions to a computer to produce an output",
            "Present information for a browser to interpret",
            "HTML",
            "<",
            "Creating websites",
            "<p>",
            "Top of the document",
            "/"

    };

}
