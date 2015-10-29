package com.example.makarov.snakegame.view;

import android.graphics.Canvas;
import android.view.SurfaceHolder;
import com.example.makarov.snakegame.InitializationGameSnake;
import java.util.Collection;
/**
 * Класс потока отрисовки всех ViewObject игры
 */
public class SurfaceThread extends Thread {

    private final SurfaceHolder myThreadSurfaceHolder;
    private InitializationGameSnake mGameSnake;
    private boolean myThreadRun = false;
    private Collection<View> mList;
    /**
     * В конструктор объект уровня игры(в котором инициализированны все объекты игры)
     * в список записываем все объекты которые будут перерисовываться по ходу игры
     */
    public SurfaceThread(SurfaceHolder holder, InitializationGameSnake gameSnake) {
        myThreadSurfaceHolder = holder;
        mGameSnake = gameSnake;
        mList = mGameSnake.getListView();
    }
    /**
     * Метод изменения состояния работы потока отрисовки
     */
    public void setRunning(boolean b) {
        this.myThreadRun = b;
    }
    /**
     * Метод вызван при запущенном потоке отрисовки ViewObject игры
     * Изначально на весь экрна прорисовываем картинку поля игры
     * По холдеру получаем канвас (то на чем производим отрисовку)
     * Для каждого ViewObject который в списке , запускаем метод прорисовки
     */
    @Override
    public void run() {
        Canvas canvas;
        //canvas = myThreadSurfaceHolder.lockCanvas(null);
        //mGameSnake.getFieldView().draw(canvas);
        //myThreadSurfaceHolder.unlockCanvasAndPost(canvas);
        while (myThreadRun) {
            canvas = null ;
            try {
                canvas = myThreadSurfaceHolder.lockCanvas(null);
                synchronized (myThreadSurfaceHolder) {
                    if (canvas == null)
                        continue;
                    mGameSnake.getFieldView().draw(canvas);
                    for(View view : mList){
                        view.draw(canvas);
                        try {
                            sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } finally {
                if (canvas != null) {
                    myThreadSurfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
}
