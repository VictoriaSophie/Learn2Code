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
            // css basics
            "What does CSS stand for?",
            "Which of these is not a necessary part in declaring a style?",
            // css 1
            "What character is used when creating comments in CSS?",
            "There are only 140 colours you can use within CSS.",
            "What is NOT a valid value for CSS colours?",
            // css 2
            "What does 'text-align: right;' achieve in CSS?",
            "What does 'text-align: start;' achieve in CSS?",
            "What does 'text-decoration-line: underline;' achieve in CSS?",
            "What does 'text-transform: uppercase;' achieve in CSS?",
            "What does 'margin-top: 3px;' achieve in CSS?",
            // js basics
            "Which of the following is considered a programming language?",
            "When would JavaScript be useful?",
            // js 1
            "Where should a HTML id be stated?",
            "What method is used to find a HTML element by ID?",
            // js 2
            "HTML, CSS and JS should be kept in the same document.",
            "What keyword allows you to create a variable?",


    };

    public static String options[][] = {
            {"Present information for a browser to interpret", "Give instructions to a computer to produce an output", "A set of information that allows people to choose which TV show to watch", "idk"}, {"Present information for a browser to interpret", "Give instructions to a computer to produce an output", "A set of information that allows people to choose which TV show to watch", "idk"}, {"Java", "JavaScript", "HTML", "Python"},
            {"<", "!", "/", ";"}, {"Creating websites", "Machine learning", "Developing applications", "Databases"}, {"<h1>", "<paragraph>", "p", "<p>"}, {"Anywhere on the page", "Top of the document", "Bottom of the document", "Within an HTML tag"},
            {"<", "!", "/", ";"}, {"<h1>", "<p>", "<br>", "<strong>"}, {"<h1>", "<p>", "<br>", "<strong>"}, {"<h1>", "<p>", "<br>", "<strong>"}, {"<h1>", "<p>", "<br>", "<strong>"}, {"<a>", "<img>", "<ul>", "<li>"}, {"<a>", "<img>", "<ul>", "<li>"}, {"<a>", "<img>", "<ul>", "<li>"}, {"<a>", "<img>", "<ul>", "<li>"},
            {"href", "a", "img", "src"}, {"href", "a", "img", "src"},  // html 2
            {"Cascading System Styles", "Colors, Symbols, and Styles", "Cascading Style Sheets", "Certified Styling Section"}, {"Value", "Color", "Property", "Selector"},
            {"<", "/", ";", "!"}, {"True", "True, but more colours can be added externally", "False, more colours can be used by HEX codes", "False, there are 410 available colours"}, {"RGB", "HEX", "External Link", "Supported Color Names"},
            {"Positions the text to the left of the element", "Creates a line underneath the text", "Changes the text to capital letters", "Position text to the right of the element"}, {"Positions the text to the left of the element", "Creates a line underneath the text", "Changes the text to capital letters", "Position text to the right of the element"}, {"Positions the text to the left of the element", "Creates a line underneath the text", "Changes the text to capital letters", "Position text to the right of the element"}, {"Positions the text to the left of the element", "Creates a line underneath the text", "Changes the text to capital letters", "Position text to the right of the element"}, {"Creates 3px space to the left of the element", "Creates 3px space to the top of the element", "Creates 3px space to the left, inside the element", "Creates 3px space to the top, inside the element"}, // css2
            {"CSS", "JavaScript", "HTML"},  {"Changing the style of a web page", "Machine learning", "Creating elements for a webpage", "Programming a button"},// js b
            {"Top of the document", "Within the end tag", "Within the opening tag", "Before the element"}, {"getHtmlById()", "getElementById()", "htmlId()", "elementOfId()"}, // js 1
            {"True, otherwise the program will crash", "False, this makes your code less maintainable", "True, this makes your code more maintainable", "False, it doesn't matter either way"}, {"let", "variable", "value", "int"} // js 2
    };

    public static String answers[] = {
            "Give instructions to a computer to produce an output", "Present information for a browser to interpret", "HTML", // prog basics
            "<", "Creating websites", "<p>", "Top of the document", // html basics
            "/", "<p>", "<h1>", "<strong>", "<br>", "<img>", "<ul>", "<li>", "<a>",// html 1
            "src", "href", // html 2
            "Cascading Style Sheets", "Color", // CSS basics
            "/", "False, more colours can be used by HEX codes", "External Link", // CSS 1
            "Position text to the right of the element", "Positions the text to the left of the element", "Creates a line underneath the text", "Changes the text to capital letters", "Creates 3px space to the top of the element",
            "JavaScript", "Programming a button", // javascript basics
            "Within the opening tag", "getElementById()", // js 1
            "False, this makes your code less maintainable", "let"// js 2

    };

}
