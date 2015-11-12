package com.example.makarov.snakegame;

import android.app.Application;
import com.example.makarov.snakegame.singleton.DataBase;

/**
 * Класс приложения
 */
public class MyApp extends Application{

    /**
     * При запуске приложения инитим БД синглетон
     */
    @Override
    public void onCreate() {
        super.onCreate();

        DataBase.initInstance(this);

    }
}
