package com.example.learn2code;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class XPDatabase {

    private static Context context;
    public XPDatabase(Context context){
        this.context = context;
    }

    public final static String PREFS_NAME = "Learn2Code_prefs";

    public static int getXP(String xp) {
        SharedPreferences sharedPref = context.getSharedPreferences(PREFS_NAME, 0);
        return sharedPref.getInt("xp",0);
    }

    public static void saveXP(String xp, int xp_value) {
        SharedPreferences sharedPref = context.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("xp",xp_value);
        editor.apply();
    }
}
