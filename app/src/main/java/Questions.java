import java.util.HashMap;
import java.util.Map;

public class Questions {
    public static Map<String, Map<String,Boolean>> getQuestions(){
        HashMap<String,Map<String,Boolean>> questions = new HashMap<>();

        HashMap<String,Boolean> answerOne = new HashMap<>();
        answerOne.put("<", true);
        answerOne.put("!", false);
        answerOne.put(":", false);
        answerOne.put(";", false);
        questions.put("What character is commonly used to identify a tag in HTML?", answerOne);

        return questions;

    }
}
