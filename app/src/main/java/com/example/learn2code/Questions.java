package com.example.learn2code;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Questions {
    public static String question[] = {
            "What character is commonly used to identify a tag in HTML?",
            "What is HTML most commonly used for?",
            "What is the opening tag for a paragraph element?",
            "Where should <!DOCTYPE html> be placed?",
            "What character is used to close tags?",
    };

    public static String options[][] = {
            {"<", "!", "/", ";"},
            {"Creating websites", "Machine learning", "Developing applications", "Databases"},
            {"<h1>", "<paragraph>", "p", "<p>"},
            {"Anywhere on the page", "Top of the document", "Bottom of the document", "Within an HTML tag"},
            {"<", "!", "/", ";"},
    };

    public static String answers[] = {
            "<",
            "Creating websites",
            "<p>",
            "Top of the document",
            "/"

    };

}
