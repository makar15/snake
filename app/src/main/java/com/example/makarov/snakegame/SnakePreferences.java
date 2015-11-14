package com.example.makarov.snakegame;

import android.content.Context;
import android.content.SharedPreferences;

/**
 *
 */
public class SnakePreferences {

    private final String LAST_LEVEL= "firstRuApp";
    private final SharedPreferences prefs;

    public SnakePreferences(Context context){
        prefs = context.getSharedPreferences("com.example.makarov.myAppName", 0);
    }

    public int getLastLevel(){
        return prefs.getInt(LAST_LEVEL, 0);
    }
}
