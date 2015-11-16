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
import com.example.makarov.snakegame.db.Level;
import com.example.makarov.snakegame.singleton.DataBase;

/**
 * Активити старта игры
 */
public class StartGameActivity extends FragmentActivity {

    /*
    Для открытия и сохранения последовательности открытых фрагментов
     */
    private FragmentTransaction ft;
    private FragmentManager fm;

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

        setContentView(R.layout.activity_start_game);
        if (savedInstanceState != null) {
            return;
        }

        /*

         */
        int idDefaultLevel = DataBase.getInstance().getLevel(Level.NAME_FIRST_LEVEL).getId();
        int idLevel = getIntent().getIntExtra(Level.NAME_ID, idDefaultLevel);

        Bundle bundle = new Bundle();
        bundle.putInt(Level.NAME_ID, idLevel);

        /*
        Инициализируем фрагмент старта игры
         */
        Fragment startGameFragment = new StartGameFragment();
        startGameFragment.setArguments(bundle);

        /*
        Запускаем фрагмент старта игры и записываем в стек опереций с фрагментами
         */
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft = ft.add(R.id.LayoutGame, startGameFragment);
        ft.commit();
    }
}
