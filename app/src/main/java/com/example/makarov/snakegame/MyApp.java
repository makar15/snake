package com.example.makarov.snakegame;

import android.app.Application;
import com.example.makarov.snakegame.convert.TxtToString;
import com.example.makarov.snakegame.singleton.DataBase;
import com.example.makarov.snakegame.singleton.IconLoader;

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
        IconLoader.initInstance(this);
        TxtToString.initInstance(this);
    }
}
