package com.example.learn2code.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Connection;

public class DBHandler {

}


//    Connection conn;
//    String DB_USERNAME, DB_PASSWORD, DB_IP, DB_PORT, DATABASE_NAME;
//    public String ConnectionURL;

    // const variables for db
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

    // method for creating db
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
//
//
////    public static final String SERVER_NAME = ;
////
////    public static final String TABLE_NAME = "db";
////    public static final String id_col = "ID";
////    public static final String user_col = "USERNAME";
////    public static final String email_col = "EMAIL";
////    public static final String COL4 = "";
//
//    public Connection connection() {
//        DB_IP = "azllngr01.uad.ac.uk";
//        DATABASE_NAME = "sql2004466";
//        DB_USERNAME = "sql2004466";
//        DB_PASSWORD = "wvMf4hGQuCSK";
//        DB_PORT = "3306";
//
//        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//        StrictMode.setThreadPolicy(policy);
//        Connection connection = null;
//        ConnectionURL = null;
//
//        try {
//            Class.forName("net.sourceforge.jtds.jdbc.Driver");
//            ConnectionURL= "jdbc:jtds:sqlserver://" + DB_IP + ":" + DB_PORT+";"+ "databasename=" + DATABASE_NAME+";user="+DB_USERNAME+";password="+ DB_PASSWORD+";";
//            connection = DriverManager.getConnection(ConnectionURL);
//
//        }
//        catch (Exception ex) {
//            Log.e("Connection error ", ex.getMessage()); // this trips
//        }
////        Toast.makeText(f, "", Toast.LENGTH_SHORT).show();
//        return connection;
//
//}}
//
//// public class DBHandler extends SQLiteOpenHelper {
//
////=======
////<<<<<<< Updated upstream:app/src/main/java/com/example/learn2code/DBHandler.java
////package com.example.learn2code;
////
////import android.content.ContentValues;
////import android.content.Context;
////import android.database.sqlite.SQLiteDatabase;
////import android.database.sqlite.SQLiteOpenHelper;
////
////import androidx.annotation.Nullable;
//
////>>>>>>> Stashed changes:app/src/main/java/com/example/learn2code/DBHandler.java
////>>>>>>> Stashed changes:app/src/main/java/com/example/learn2code/data/com/example/learn2code/data/DBHandler.java
////>>>>>>> Stashed changes:app/src/main/java/com/example/learn2code/DBHandler.java
////
////import android.content.ContentValues;
////import android.content.Context;
////import android.database.sqlite.SQLiteDatabase;
////import android.database.sqlite.SQLiteOpenHelper;
////
////public class DBHandler extends SQLiteOpenHelper {
////    public static final String SERVER_NAME = "lochnagar.abertay.ac.uk";
////    public static final String DATABASE_NAME = "sql2004466";
////    public static final String DB_USERNAME = "sql2004466";
////    public static final String DB_PASSWORD = "wvMf4hGQuCSK";
////    public static final String TABLE_NAME = "db";
////    public static final String id_col = "ID";
////    public static final String user_col = "USERNAME";
////    public static final String email_col = "EMAIL";
//////    public static final String COL4 = "";
////
////
////    public DBHandler(Context context) {
////        super(context, DATABASE_NAME, null, 1);
////    }
////
////
////    @Override
////    public void onCreate(SQLiteDatabase sqLiteDatabase) {
////        String createTable = "CREATE TABLE " + TABLE_NAME + "(" + id_col  +  "INTEGER PRIMARY KEY AUTOINCREMENT, " + user_col + " TEXT," + email_col + " TEXT)";
////        sqLiteDatabase.execSQL(createTable);
////    }
////
////    @Override
////    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
////        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
////        onCreate(sqLiteDatabase);
////
////    }
////    public boolean addData(String username, String email) {
////        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
////        ContentValues contentValues = new ContentValues();
////        contentValues.put(user_col,username);
////        contentValues.put(email_col,email);
////
////        long result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
////        return result != -1;
////    }
////}
//
////
////    // const variables for db
////    private static final String DATABASE_NAME = "QuizDB";
////    private static final int DATABASE_VERSION = 1;
////    private static final String TABLE_NAME = "QuizTable";
////    private static final String ID_COL = "id";
////    private static final String QUESTION_COL = "question";
////    private static final String ANSWER1_COL = "answer1";
////    private static final String ANSWER2_COL = "answer2";
////
////    // constructor for db handler
////    public DBHandler(Context context) {
////        super(context, DATABASE_NAME, null, DATABASE_VERSION);
////    }
////
////    // method for creating db
////    @Override
////    public void onCreate(SQLiteDatabase db) {
////        String query = "CREATE TABLE " + TABLE_NAME + " ("
////                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
////                + QUESTION_COL + " TEXT,"
////                + ANSWER1_COL + " TEXT,"
////                + ANSWER2_COL + " TEXT)";
////        db.execSQL(query); // executes query
////    }
////
////    // method for adding new questions
////    public void addNewQuestion(String question, String answer1, String answer2) {
////        SQLiteDatabase db = this.getWritableDatabase();
////        ContentValues values = new ContentValues();
////
////        // passing all values with key/value pair
////        values.put(QUESTION_COL, question);
////        values.put(ANSWER1_COL, answer1);
////        values.put(ANSWER2_COL, answer2);
////
////        // pass content values to our table
////        db.insert(TABLE_NAME, null, values);
////        db.close();
////    }
////
////    @Override
////    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
////        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
////        onCreate(db);
////    }
////
//}