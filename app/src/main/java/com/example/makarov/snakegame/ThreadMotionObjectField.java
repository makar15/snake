package com.example.makarov.snakegame;

import com.example.makarov.snakegame.controllers.ObjectController;
import java.util.Collection;
/**
 * Класс потока передвижения объектов игры, контроллерами
 */
public class ThreadMotionObjectField extends Thread{

    private InitializationGameSnake mGameSnake;
    private boolean myThreadRun = false;
    private Collection<ObjectController> mList;
    /**
     * В конструктор объект уровня игры(в котором инициализированны все объекты игра)
     * в список записываем все объекты которые будут передвигаться по ходу игры
     */
    public ThreadMotionObjectField(InitializationGameSnake gameSnake) {
        mGameSnake = gameSnake;
        mList = mGameSnake.getListController();
    }
    /**
     * Метод изменения состояния работы потока передвиения объектов контроллерами
     */
    public void setRunning(boolean b) {
        this.myThreadRun = b;
    }
    /**
     * Метод при запущенном потоке передвижения объектов
     * Пролистывая список, запускаем метод передвижение объектов контроллерами
     */
    @Override
    public void run() {
        while (myThreadRun) {
            for(ObjectController objectController : mList){
                objectController.nextMove();
                try {
                    sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
