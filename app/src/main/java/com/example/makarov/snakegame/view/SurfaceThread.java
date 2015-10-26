package com.example.makarov.snakegame.view;

import android.graphics.Canvas;
import android.view.SurfaceHolder;
import java.util.Collection;
/**
 * Класс потока отрисовки всех ViewObject игры
 */
public class SurfaceThread extends Thread {

    private final SurfaceHolder myThreadSurfaceHolder;
    private boolean myThreadRun = false;
    private Collection<View> mList;
    public Canvas canvas;
    /**
     * В конструктор список с объектами которые будем отрисовывать
     */
    public SurfaceThread(SurfaceHolder holder, Collection<View> list) {
        myThreadSurfaceHolder = holder;
        mList = list;
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
     * По холдеру получаем канвас (то на чем производим отрисовку)
     * Для каждого ViewObject который в списке , запускаем метод прорисовки
     */
    @Override
    public void run() {
        while (myThreadRun) {
            canvas = null;
            try {
                canvas = myThreadSurfaceHolder.lockCanvas(null);
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
