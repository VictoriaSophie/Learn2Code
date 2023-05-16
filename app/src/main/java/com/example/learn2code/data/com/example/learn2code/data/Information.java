package com.example.learn2code.data;

import com.example.learn2code.R;

public class Information {
    public static String[][] title = {
            // programming basics
            {"How are websites created?", "What is Learn2Code?", "How do I use this application?"},
            // HTML Basics
            {"Introduction to HTML", "History", "Structure"},
            // HTML 1
            {"Elements", "Text Elements", "Other Elements"},
            // HTML 2
            {"Attributes", "Common Attribute Examples", "Comments"},
            //css basics
            {"CSS (Cascading Style Sheets)", "CSS Syntax", "Properties and Values"},
            // css 1
            {"Comments", "Colours 1", "Colours 2"},
            // css 2
            {"Text Formatting", "Decoration & Transformation", "Margins and Padding"},
            // js basic
            {"What is JavaScript (JS)?", "Why JavaScript", "How is JavaScript useful?"},
            // js 1
            {"HTML IDs", "Using IDs in JS", "Changing CSS"},
            // js 2
            {"Best Practice", "Variables", "Alerts and Logs"}

    };

    // card info has to be around 210 characters or less

    public static String[] cardOneInfo = {
            "Websites and other applications are created by developers who write code to create any features you see on the screen. There are a variety of programming languages that developers uses which all have their uses and drawbacks.", // programming basics
            "HTML stands for Hypertext markup language and is used to create and structure websites. It is not considered an official programming language but is usually used with programming languages such as JavaScript.", // HTML basics
            "HTML uses different elements to create different items on your webpage. There are 111 (as of 2022) elements you can use to make an interesting website. An HTML element is defined using tags.", // HTML 1
            "Many HTML elements need attributes to function. Attributes provide additional information for the element and are found nested in the opening tag.", // HTML 2
            "So far, we have learned how to create basic elements on a website but we want our application to look pretty. To do this, we can use CSS which tells the computer how we want to design our website.", // CSS Basics
            "Just like HTML you can create comments in CSS. However, in CSS comments are contained within '/*' and '*/' with whatever you want to comment in-between. Comments can continue over multiple lines.", // css 1
            "As well as changing the colour of text, CSS can handle changing the alignment (e.g. text-align: center;), spacing (e.g. letter-spacing: 3px;), shadow (e.g. text-shadow: 3px 3px;), decorations and transformations.", // css 2
            "JavaScript is a programming language used to create interactive web pages. HTML and CSS are not technically programming languages so JavaScript will be the first programming language you learn.", // js basics
            "To find an HTML element in your JavaScript code, it is helpful to add an ID to your HTML element. This goes in the opening tag e.g: <h1 id='heading'>.",// js 1
            "There are ways to have all your HTML, CSS and JavaScript within the same document however, the best practice within the industry is to keep them in separate documents. This keeps your code more maintainable."// js 2

    };

    public static String[] cardTwoInfo = {
            "This application will teach you how to create your very own website. It will give you all the tools and knowledge needed to create any website you want.", // P Basics
            "HTML has been used since 1993 and was written by Tim Berners-Lee. It was originally developed to support linking between online resources.", // HTML basics
            "<h1> Heading </h1>\n<p> Paragraph </p>\n<br> Line break\n<strong> Important Text </strong>", // HTML 1
            "As seen on the previous page, the link element contains a href attribute that allows you to choose the link you want to share. Similarly, the image element requires a src attribute to choose what image to be displayed.", // HTML 2
            "CSS consists of three basic parts. A selector, property and a value. The selector is any of the HTML tags previously mentioned (and more!) that you want to apply the style to.",// CSS basics
            "Text colour and background colour of elements can easily be changed using CSS. To set text colour, the property is simply 'color' and to change the background colour the property is 'background-color'.", // css 1
            "'text-decoration-____' allows you to change how the text looks. You can add multiple to the same element and the options are: 'line, color, style, thickness'.\n'text-transform' allows you to toggle capitalisation.", // css 2
            "JavaScript is the most popular programming language and it allows you to program the behaviour of a website. This means JavaScript allows you to create buttons or change the content you've created on HTML.", // js b
            "To select an element from your HTML code, you can use the getElementById() method. For example: document.getElementById('heading').innerHTML. This allows you to change the content of the element, or hide it.",// js 1
            "JavaScript allows you to work with variables, which allows you to store values. For example, if you want to keep track of a number you can declare 'let x =0;', then later on in your code you can do 'x=x+1'."// js 2

    };

    public static String[] cardThreeInfo = {
            "Learn2Code uses a variety of techniques to allow you to read and understand the information you need. An example of one of these techniques is quizzes, please click the button below to begin your first quiz!", // P basics
            "A HTML document always begins with <!DOCTYPE> to define the document to the computer, then the rest of the code is placed in a HTML tag: <html> information </html>. The <body> tag contains all the information a user can see.", // HTML b
            "<a href= https://> Link </a>\n<img src='.jpg' alt= 'Image'>\n<ul> List </ul>\n<li> List Item </li>",
            "Comments are not read by the browser and are used throughout all languages. This is used to explain what the code is doing or remind you of what you're doing next. In HTML comments are contained within '<!--' and '-->'.", // html 2
            "The property is the object that you want to style (e.g. colour, margin-top, font-family) and the value is what you want to make the object (e.g yellow, 100px, Comic sans).", // css b
            "There are 140 supported colour names that you can choose from in CSS, click read more to see them all. If you can't find the specific colour you want, CSS also allows HEX, HSL, HSLA, RGB and RGBA values.", // css 1
            "Margins create space around the elements, whereas padding creates space within the element. Both allow you to specify the side of the element, 'top, bottom, left, right' e.g 'margin-top' or 'padding-bottom'.", // css 2
            "The information so far, might seem a little abstract. In more detail, JavaScript allows you to choose what HTML element you want and change the content of it, such as choosing a text box and changing the words to something else.", // js b
            "JavaScript can also be used to change things within your CSS. For example, changing the colour of a button when it's clicked: document.getElementById('button').style.backgroundColor= 'Blue';",// js 1
            "JavaScript allows you to create a pop-up box to alert the user of something e.g: alert('Closing soon!');. Additionally, you can write to the log using JS to allow you to debug e.g, if you have a variable x: 'console.log(x);"// js 2
            };

    public static int[][] image = {
            // pictures taken from Wikipedia or created on Visual Studio Code if not otherwise stated
            // p basics
            {R.drawable.building_website, R.drawable.learn_2_code_logo, R.drawable.quiz_image}, // building_website from www.theartsdevelopmentompany.org.uk, logo created from www.looka.com quiz_image from www.freepik.com
            // html basics
            {R.drawable.html5_logo, R.drawable.tim_berners_lee, R.drawable.html_structure},
            // html 1
            {R.drawable.html_elements, R.drawable.text_elements, R.drawable.other_elements},
            // html 2
            {R.drawable.html_attributes, R.drawable.common_attributes, R.drawable.html_comments}, //html_attributes from Learning Web Design, P.64
            // css b
            {R.drawable.css_logo, R.drawable.css_selector, R.drawable.properties_values}, // css_selector and properties_values taken from www.w3schools.com
            // css 1
            {R.drawable.css_comments, R.drawable.css_colours, R.drawable.colour_table},
            // css 2
            {R.drawable.text_formatting, R.drawable.decoration_transformation, R.drawable.margins_padding},
            // js b
            {R.drawable.javascript_logo, R.drawable.used_languages, R.drawable.javascript_uses}, // javascript_logo taken from www.pngwing.com, used_languages from www.educba.com, javascript_uses from www.learnacademy.org
            // js 1
            {R.drawable.html_id, R.drawable.js_id, R.drawable.changing_css},
            // js 2
            {R.drawable.standard_practice, R.drawable.js_variables, R.drawable.alerts_logs},

    };

    public static String[][] buttons = {
            {"", "", ""}, // p basics
            {"", "", ""}, // html basics
            {"", "", ""}, // html1
            {"", "", ""}, // html 2
            {"", "", ""}, // css basics
            {"", "", "https://www.w3schools.com/colors/colors_names.asp"}, // css 1
            {"", "", ""}, // css 2
            {"", "", ""}, // js basics
            {"", "", ""}, // js 1
            {"", "", ""} // js 2
    };
}
