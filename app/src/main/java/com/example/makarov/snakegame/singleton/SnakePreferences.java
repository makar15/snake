package com.example.makarov.snakegame.singleton;

import android.content.Context;
import android.content.SharedPreferences;

/**
 *
 */
public class SnakePreferences {

    private final String LAST_LEVEL= "ruAppLastLevel";
    private final String FIRST_START_APPLICATION= "firstRunMyApp";
    private final String PREFERENCES_SAVE_FILE = "com.example.makarov.myAppName";
    private final SharedPreferences prefs;

    public SnakePreferences(Context context){
        prefs = context.getSharedPreferences(PREFERENCES_SAVE_FILE, 0);
    }

    public int getLastLevel(){
        return prefs.getInt(LAST_LEVEL, 0);
    }

    public boolean getFirstStartApp(){
        return prefs.getBoolean(FIRST_START_APPLICATION, true);
    }

    public void changedStartApp(boolean state){
        prefs.edit().putBoolean(FIRST_START_APPLICATION, state).apply();
    }

    public void changedLastLevel(int idLevel){
        prefs.edit().putInt(LAST_LEVEL, idLevel).apply();
    }
}
