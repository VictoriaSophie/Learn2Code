package com.example.learn2code;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Questions {
    public static String question[] = {
      "What character is commonly used to identify a tag in HTML?",
            "What is HTML most commonly used for?"
    };

    public static String options[][] = {
            {"<", "!", ":", ";"},
            {"Creating websites", "Machine learning", "Developing applications", "Databases"}
    };

    public static String answers[] = {
            "!",
            "Creating websites"

    };
//    public static Map<String, Map<String,Boolean>> getQuestions(){
//        HashMap<String,Map<String,Boolean>> questions = new HashMap<>();
//
//        HashMap<String,Boolean> answerOne = new HashMap<>();
//        answerOne.put("<", true);
//        answerOne.put("!", false);
//        answerOne.put(":", false);
//        answerOne.put(";", false);
//        questions.put("What character is commonly used to identify a tag in HTML?", answerOne);
//
//        return questions;
//
//    }
//
//    public static Map<String,Map<String,Boolean>> getRandomQuestion(Context context, int SIZE){
//        Map<String,Map<String,Boolean>> questionsMap = new HashMap<>();
//        Map<String, Map<String, Boolean>> getQuestions;
//        getQuestions = getQuestions();
//        int size = getQuestions.size();
//
//        ArrayList<String> keyList = new ArrayList<String>(getQuestions.keySet());
//
//        while (questionsMap.size()<=SIZE){
//            Random random = new Random();
//            int randomNumber = random.nextInt(size);
//            String question = keyList.get(randomNumber);
//            if (!questionsMap.containsKey(question)){
//                questionsMap.put(question, getQuestions.get(question));
//            }
//        }
//        return questionsMap;
//    }
}
