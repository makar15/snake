package com.example.makarov.snakegame.window;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.example.makarov.snakegame.initialized.GameSnakeSurfaceView;

/**
 * Активити старта игры
 */
public class StartGameActivity extends Activity {

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

        /*
        Запускаем класс игры
        в котором инициализируется выбранный уровень, а далее уже объекты, View и др. игры
         */
        setContentView(new GameSnakeSurfaceView(this));
    }
}
