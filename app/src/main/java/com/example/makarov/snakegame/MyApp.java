package com.example.makarov.snakegame;

import android.app.Application;
import com.example.makarov.snakegame.singleton.SnakePreferences;
import com.example.makarov.snakegame.singleton.TxtToString;
import com.example.makarov.snakegame.singleton.DataBase;
import com.example.makarov.snakegame.singleton.IconLoader;

/**
 * Класс приложения
 */
public class MyApp extends Application{

    private static MyApp app;
    private DataBase dataBase;
    private IconLoader iconLoader;
    private TxtToString txtToString;
    private SnakePreferences snakePreferences;

    /**
     * При запуске приложения инитим синглетоны
     */
    @Override
    public void onCreate() {
        super.onCreate();

        app = this;
        dataBase = new DataBase(this);
        iconLoader = new IconLoader(this);
        txtToString = new TxtToString(this);
        snakePreferences = new SnakePreferences(this);
    }

    public static MyApp getApp() {
        return app;
    }

    public IconLoader getIconLoader() {
        return iconLoader;
    }

    public TxtToString getTxtToString() {
        return txtToString;
    }

    public SnakePreferences getSnakePreferences() {
        return snakePreferences;
    }

    public DataBase getDataBase() {
        return dataBase;
    }
}
