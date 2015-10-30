package com.example.makarov.snakegame.initialized;

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
     * В конструктор объект уровня игры(в котором инициализированны все объекты игры)
     * в список записываем все объекты которые будут передвигаться по ходу игры
     */
    public ThreadMotionObjectField(InitializationGameSnake gameSnake) {
        mGameSnake = gameSnake;
        mList = mGameSnake.getListController();
    }
    /**
     * Метод изменения состояния работы потока передвижения объектов
     */
    public void setRunning(boolean b) {
        this.myThreadRun = b;
    }
    /**
     * Метод при запущенном потоке передвижения объектов
     * Пролистывая список, запускаем метод передвижение объектов
     */
    @Override
    public void run() {
        while (myThreadRun) {
            for(ObjectController objectController : mList){
                if(objectInTheGame(objectController)) {
                    objectController.nextMove();
                } else {
                    /**
                     * Вроде как просто так удалить нельзя!???
                     * Не нужно ли смещение в списка назад на одну позицию?
                     */
                    mList.remove(objectController);
                }
                try {
                    sleep(120);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * Проверка, в игре ли еще объект
     */
    public boolean objectInTheGame(ObjectController objectController){
        if(objectController.getField().getFieldObject(objectController.getObject().getX(),
                objectController.getObject().getY()) != null ){
            return true;
        } else {
            return false;
        }
    }
}
