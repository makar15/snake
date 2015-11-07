package com.example.makarov.snakegame.window;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
import android.view.WindowManager;
import com.example.makarov.snakegame.R;

/**
 * Главное окно приложения
 */
public class MainActivity extends FragmentActivity {

    private FragmentTransaction ft;
    private FragmentManager fm;

    /**
     * приложение постоянно имеет портретную ориентацию
     * приложение будет полноэкранным и без заголовка
     * Запускаем класс сцены игры
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            return;
        }

        Fragment fragMenuGame = new GameMenuFragment();

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft = ft.add(R.id.LayoutMenu, fragMenuGame).addToBackStack(null);
        ft.commit();

    }
}
