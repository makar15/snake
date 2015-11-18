package com.example.makarov.snakegame.window;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
import android.view.WindowManager;
import com.example.makarov.snakegame.MyApp;
import com.example.makarov.snakegame.R;
import com.example.makarov.snakegame.db.Level;
import com.example.makarov.snakegame.level.SnakeLevelCreator;
import java.io.IOException;

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

    @Override
    protected void onResume() {
        super.onResume();

        if (MyApp.getApp().getSnakePreferences().getFirstStartApp()) {
            // При первом запуске (или если юзер удалял все данные приложения)
            try {
                //Инициализируем все модели уровней с записью их в Realm DataBase
                SnakeLevelCreator levels = new SnakeLevelCreator();
            } catch (IOException e) {
                e.printStackTrace();
            }
             //и после действия записывам false в preferences
            MyApp.getApp().getSnakePreferences().changedStartApp(false);
            //из DataBase получаем id модели уровня первого уровня и записываем id в preferences
            int idLevel = MyApp.getApp().getDataBase().getLevel(Level.NAME_FIRST_LEVEL).getId();
            MyApp.getApp().getSnakePreferences().changedLastLevel(idLevel);
        }
    }
}
