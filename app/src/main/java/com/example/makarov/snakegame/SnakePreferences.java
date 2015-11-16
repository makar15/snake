package com.example.makarov.snakegame;

import android.content.Context;
import android.content.SharedPreferences;

/**
 *
 */
public class SnakePreferences {

    private final String LAST_LEVEL= "firstRuApp";
    private final String FIRST_START_APPLICATION= "firstRunMyApp";
    private final String PREFERENCES_SAVE_FILE = "com.example.makarov.myAppName";
    private final SharedPreferences prefs;
    private static SnakePreferences mInstance;

    private SnakePreferences(Context context){
        prefs = context.getSharedPreferences(PREFERENCES_SAVE_FILE, 0);
    }

    /**
     * Класс инициализации объекта (объект синглетон)
     */
    public static void initInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SnakePreferences(context);
        }
    }

    /**
     * получить объект
     */
    public static SnakePreferences getInstance() {
        return mInstance;
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
