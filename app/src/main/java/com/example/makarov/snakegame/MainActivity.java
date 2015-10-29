package com.example.makarov.snakegame;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.example.makarov.snakegame.view.GameSnakeSurfaceView;
/**
 * Главное окно приложения
 */
public class MainActivity extends Activity {
    /**
     * приложение постоянно имело портретную ориентацию
     * приложение было полноэкранным и без заголовка
     * Запускаем класс сцены игры
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(new GameSnakeSurfaceView(this));
    }

}
