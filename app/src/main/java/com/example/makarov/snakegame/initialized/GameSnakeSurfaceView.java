package com.example.makarov.snakegame.initialized;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.example.makarov.snakegame.initialized.levels.CreateLevel;
import com.example.makarov.snakegame.initialized.threads.SurfaceThread;
import com.example.makarov.snakegame.initialized.threads.ThreadMotionObjectField;
import java.io.IOException;

/**
 * Класс Игры змейки
 */
public class GameSnakeSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    private SurfaceThread drawThread;
    private ThreadMotionObjectField threadMotionObject;
    private CreateLevel mGameSnake ;
    private IconLoader myIconLoader;

    /**
     * В конструктор контекст
     */
    public GameSnakeSurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    /**
     * Метод вызывается, если был изменен формат или размер SurfaceView
     */
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {

    }

    /**
     * Метод вызывается, когда SurfaceView создан и готов к отображению информации
     * Инициализируем класс уровня игры
     * Инициализация и запуск потоков: передвижения объектов и прорисовки ViewObject игры
     */
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        myIconLoader = new IconLoader(this.getContext());
        try {
            mGameSnake = new CreateLevel(this, myIconLoader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        threadMotionObject = new ThreadMotionObjectField(mGameSnake);
        drawThread = new SurfaceThread(getHolder(), mGameSnake);
        threadMotionObject.setRunning(true);
        drawThread.setRunning(true);
        threadMotionObject.start();
        drawThread.start();
    }

    /**
     * Метод вызывается перед тем, как SurfaceView будет уничтожен
     */
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        drawThread.setRunning(false);
        threadMotionObject.setRunning(false);
        while (retry) {
            try {
                drawThread.join();
                threadMotionObject.join();
                retry = false;
            } catch (InterruptedException e) {
            }
        }
    }
}

