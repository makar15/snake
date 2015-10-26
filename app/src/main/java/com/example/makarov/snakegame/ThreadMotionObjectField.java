package com.example.makarov.snakegame;

import com.example.makarov.snakegame.controllers.ObjectController;
import java.util.Collection;
/**
 * Класс потока передвижения объектов игры контроллерами
 */
public class ThreadMotionObjectField extends Thread{

    private boolean myThreadRun = false;
    private Collection<ObjectController> mList;
    /**
     * В конструктор список с контроллерами игры
     */
    public ThreadMotionObjectField(Collection<ObjectController> list) {
        mList = list;
    }
    /**
     * Метод изменения состояния работы потока передвиения объектов контроллерами
     */
    public void setRunning(boolean b) {
        this.myThreadRun = b;
    }
    /**
     * Метод при запущенном потоке передвижения объектов
     * Пролистывая список запускаем метод передвижение объектов контроллерами
     */
    @Override
    public void run() {
        while (myThreadRun) {
            for(ObjectController objectController : mList){
                objectController.nextMove();
            }
        }
    }
}
