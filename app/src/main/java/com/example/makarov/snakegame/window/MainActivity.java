package com.example.makarov.snakegame.window;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
import android.view.WindowManager;
import com.example.makarov.snakegame.R;
import com.example.makarov.snakegame.initialized.levels.SnakeLevelCreator;
import java.io.IOException;

/**
 * Главное активити приложения
 */
public class MainActivity extends FragmentActivity {

    /*
    Для открытия и сохранения последовательности открытых фрагментов
    Preferences - для сохранения статуса приложения типом булл
     */
    private FragmentTransaction ftActivity;
    private FragmentManager fmActivity;
    private SharedPreferences prefs = null;
    private SnakeLevelCreator levels;

    /*
    getLastShared
    SnakePreferences
     */
    /**
     * Запускаем класс сцены игры
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prefs = getSharedPreferences("com.example.makarov.myAppName", MODE_PRIVATE);

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

    @Override
    protected void onResume() {
        super.onResume();

        if (prefs.getBoolean("firstRunMyApp", true)) {
            // При первом запуске (или если юзер удалял все данные приложения)
            try {
                levels = new SnakeLevelCreator();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //и после действия записывам false в переменную firstRunMyApp
            //Итого при следующих запусках этот код не вызывается.
            prefs.edit().putBoolean("firstRunMyApp", false).apply();
            prefs.edit().putInt("firstRuApp", 0).apply();
        }
    }
}
