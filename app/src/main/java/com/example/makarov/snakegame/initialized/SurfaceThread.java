package com.example.makarov.snakegame.initialized;

import android.graphics.Canvas;
import android.view.SurfaceHolder;
import com.example.makarov.snakegame.view.View;
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
     * Метод вызван при запущенном потоке отрисовки ViewObject-ов игры
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
                        if(objectInTheGame(view)) {
                            view.draw(canvas);
                        } else {
                            /**
                             * Вроде как просто так удалить нельзя!???
                             * Не нужно ли смещение в списка назад на одну позицию?
                             */
                            mList.remove(view);
                        }
                        try {
                            sleep(70);
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
    /**
     * Проверка, в игре ли еще объект
     */
    public boolean objectInTheGame(View view){
        if(mGameSnake.getFieldView().getField().getFieldObject
                (view.getObject().getX(), view.getObject().getY()) != null) {
            return true;
        } else {
            return false;
        }
    }
}
