package com.example.makarov.snakegame;

import android.app.Activity;
import android.os.Bundle;
import com.example.makarov.snakegame.view.GameSnakeSurfaceView;
/**
 * Главное окно приложения
 */
public class MainActivity extends Activity {
    /**
     * Запускаем класс сцены игры
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GameSnakeSurfaceView(this));
    }

}
