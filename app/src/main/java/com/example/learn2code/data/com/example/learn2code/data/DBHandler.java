//<<<<<<< Updated upstream:app/src/main/java/com/example/learn2code/data/com/example/learn2code/data/DBHandler.java
//package com.example.learn2code.data;
//=======
//<<<<<<< Updated upstream:app/src/main/java/com/example/learn2code/DBHandler.java
//package com.example.learn2code;
//=======
//<<<<<<< Updated upstream:app/src/main/java/com/example/learn2code/data/com/example/learn2code/data/DBHandler.java
//package com.example.learn2code.data;
//=======
//<<<<<<< Updated upstream:app/src/main/java/com/example/learn2code/DBHandler.java
//package com.example.learn2code;
//>>>>>>> Stashed changes:app/src/main/java/com/example/learn2code/DBHandler.java
//>>>>>>> Stashed changes:app/src/main/java/com/example/learn2code/data/com/example/learn2code/data/DBHandler.java
//>>>>>>> Stashed changes:app/src/main/java/com/example/learn2code/DBHandler.java
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//public class DBHandler extends SQLiteOpenHelper {
//
//    // const variables for db
//    private static final String DATABASE_NAME = "QuizDB";
//    private static final int DATABASE_VERSION = 1;
//    private static final String TABLE_NAME = "QuizTable";
//    private static final String ID_COL = "id";
//    private static final String QUESTION_COL = "question";
//    private static final String ANSWER1_COL = "answer1";
//    private static final String ANSWER2_COL = "answer2";
//
//    // constructor for db handler
//    public DBHandler(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//    // method for creating db
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        String query = "CREATE TABLE " + TABLE_NAME + " ("
//                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
//                + QUESTION_COL + " TEXT,"
//                + ANSWER1_COL + " TEXT,"
//                + ANSWER2_COL + " TEXT)";
//        db.execSQL(query); // executes query
//    }
//
//    // method for adding new questions
//    public void addNewQuestion(String question, String answer1, String answer2) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//
//        // passing all values with key/value pair
//        values.put(QUESTION_COL, question);
//        values.put(ANSWER1_COL, answer1);
//        values.put(ANSWER2_COL, answer2);
//
//        // pass content values to our table
//        db.insert(TABLE_NAME, null, values);
//        db.close();
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
//        onCreate(db);
//    }
//
//}
//=======
//package com.example.learn2code.data;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//public class DBHandler extends SQLiteOpenHelper {
//
//    // const variables for db
//    private static final String DATABASE_NAME = "QuizDB";
//    private static final int DATABASE_VERSION = 1;
//    private static final String TABLE_NAME = "QuizTable";
//    private static final String ID_COL = "id";
//    private static final String QUESTION_COL = "question";
//    private static final String ANSWER1_COL = "answer1";
//    private static final String ANSWER2_COL = "answer2";
//
//    // constructor for db handler
//    public DBHandler(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//    // method for creating db
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        String query = "CREATE TABLE " + TABLE_NAME + " ("
//                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
//                + QUESTION_COL + " TEXT,"
//                + ANSWER1_COL + " TEXT,"
//                + ANSWER2_COL + " TEXT)";
//        db.execSQL(query); // executes query
//    }
//
//    // method for adding new questions
//    public void addNewQuestion(String question, String answer1, String answer2) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//
//        // passing all values with key/value pair
//        values.put(QUESTION_COL, question);
//        values.put(ANSWER1_COL, answer1);
//        values.put(ANSWER2_COL, answer2);
//
//        // pass content values to our table
//        db.insert(TABLE_NAME, null, values);
//        db.close();
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
//        onCreate(db);
//    }
//
//}
//>>>>>>> Stashed changes:app/src/main/java/com/example/learn2code/data/com/example/learn2code/data/DBHandler.java
