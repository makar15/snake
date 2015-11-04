package com.example.makarov.snakegame.initialized.threads;

import android.graphics.Canvas;
import android.view.SurfaceHolder;
import com.example.makarov.snakegame.initialized.levels.LevelGameSnake;
import com.example.makarov.snakegame.view.View;
import java.util.Collection;
import java.util.Iterator;

/**
 * Класс потока отрисовки всех viewObject игры
 */
public class SurfaceThread extends GameThreads {

    private final int COUNT_FRAME_IN_SECOND = 16;
    private final int FREQUENCY = 1000 / COUNT_FRAME_IN_SECOND;
    private final SurfaceHolder myThreadSurfaceHolder;
    private Collection<View> mList;

    /**
     * В конструктор объект уровня игры(в котором инициализированны все объекты игры)
     * В список записываем все viewObject, которые будут перерисовываться по ходу игры
     */
    public SurfaceThread(SurfaceHolder holder, LevelGameSnake gameSnake) {
        super(gameSnake);
        myThreadSurfaceHolder = holder;
        mList = mGameSnake.getViews();
    }

    /**
     * Метод вызван при запущенном потоке отрисовки ViewObject-ов игры
     */
    @Override
    public void run() {
        while (myThreadRun) {
            iteration();
            try {
                sleep(FREQUENCY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * В методе пролистывая список view, перерисовываем viewObject
     * Изначально на весь экран прорисовываем картинку поля игры
     * По холдеру получаем канвас (то на чем производим отрисовку)
     * Для каждого ViewObject который в списке , запускаем метод прорисовки
     */
    private void iteration() {
        Canvas canvas = null;
        try {
            canvas = myThreadSurfaceHolder.lockCanvas(null);
            synchronized (myThreadSurfaceHolder) {
                if (canvas == null)
                    return;
                mGameSnake.getFieldView().draw(canvas);
                Iterator<View> iter = mList.iterator();
                while (iter.hasNext()) {
                    /*
                    Когда у объекта состояние на false,
                    тогда удаляем вьюху этого объекта
                     */
                    View tempView = iter.next();
                    if (objectInTheGame(tempView)) {
                        tempView.draw(canvas);
                    } else {
                        iter.remove();
                    }
                }
            }
        } finally {
            if (canvas != null) {
                myThreadSurfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }

    /**
     * Проверка, в игре ли еще объект
     * ПЕРЕДЕЛАТЬ!!
     * только при коллизии
     * что бы каждую итерацию не пролистывать весь список объектов поля
     * или создать переменную булл каждому объекту и по ней определять удалять ли viewObject
     */
    private boolean objectInTheGame(View view) {
        if (mGameSnake.getFieldView().getField().getFieldObject(view.getObject().getX(), view.getObject().getY()) != null) {
            return true;
        } else {
            return false;
        }
    }
}
