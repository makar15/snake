package com.example.makarov.snakegame.initialized;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
/**
 * Класс Игры змейки
 */
public class GameSnakeSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    private SurfaceThread drawThread;
    private ThreadMotionObjectField threadMotionObject;
    private InitializationGameSnake mGameSnake ;
    /**
     * В конструктор контекст
     * Инициализируем класс со всеми объектами участвующими в потоках:
     * передвижения и прорисовки на поле
     */
    public GameSnakeSurfaceView(Context context) {
        super(context);

        mGameSnake = new InitializationGameSnake(getHolder(), context, this);
        getHolder().addCallback(this);
    }
    /**
     *
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        scaleGestureDetector.onTouchEvent(event);
        return true;
    }
     */
    /**
     * Метод вызывается, если был изменен формат или размер SurfaceView
     */
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {

    }
    /**
     * Метод вызывается, когда SurfaceView создан и готов к отображению информации
     * Инициализация и запуск потоков: передвижения объектов и прорисовки ViewObject игры
     */
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
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
