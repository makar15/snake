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
 * Главное активити приложения
 */
public class MainActivity extends FragmentActivity {

    /*
    Для открытия и сохранения последовательности открытых фрагментов
     */
    private FragmentTransaction ftActivity;
    private FragmentManager fmActivity;

    /**
     * Запускаем класс сцены игры
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        приложение постоянно имеет портретную ориентацию
        приложение будет полноэкранным и без заголовка
         */
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            return;
        }

        /*
        Инициализируем фрагмент с менюшкой игры
         */
        Fragment fragMenuGame = new GameMenuFragment();

        /*
        Запускаем фрагмент меню игры и записываем в стек опереций с фрагментами
         */
        fmActivity = getSupportFragmentManager();
        ftActivity = fmActivity.beginTransaction();
        ftActivity = ftActivity.add(R.id.LayoutMenu, fragMenuGame);
        ftActivity.commit();

    }
}
