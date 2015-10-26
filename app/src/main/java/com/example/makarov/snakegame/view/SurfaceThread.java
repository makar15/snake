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
    public Canvas canvas;
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
     * Вернуть Канвас
     */
    public Canvas getCanvas(){
        return canvas;
    }
    /**
     * Метод изменения состояния работы потока отрисовки
     */
    public void setRunning(boolean b) {
        this.myThreadRun = b;
    }
    /**
     * Метод при запущенном потоке отрисовки объектов игры
     * Изначально на весь экрна прорисовываем картинку поля игры
     * По холдеру получаем канвас (то на чем производим отрисовку)
     * Для каждого ViewObject который в списке , запускаем метод прорисовки
     */
    @Override
    public void run() {
        canvas = myThreadSurfaceHolder.lockCanvas(null);
        mGameSnake.getFieldView().draw(canvas);
        while (myThreadRun) {
            try {
                synchronized (myThreadSurfaceHolder) {

                    for(View view : mList){
                        view.draw(canvas);
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
