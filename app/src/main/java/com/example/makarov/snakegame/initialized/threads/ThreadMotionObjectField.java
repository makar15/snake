package com.example.makarov.snakegame.initialized.threads;

import android.app.DialogFragment;
import com.example.makarov.snakegame.controllers.ObjectController;
import com.example.makarov.snakegame.initialized.GameSnakeSurfaceView;
import com.example.makarov.snakegame.initialized.levels.Level;
import com.example.makarov.snakegame.window.DialogSaveRecord;
import java.util.Collection;
import java.util.Iterator;

/**
 * Класс потока передвижения объектов игры, контроллерами
 */
public class ThreadMotionObjectField extends GameThreads {

    private final int COUNT_FRAME_IN_SECOND = 10;
    private final int FREQUENCY = 1000 / COUNT_FRAME_IN_SECOND;
    private Collection<ObjectController> mList;
    /**
     * ПОТЫТКА НЕ ПЫТКА!
     */
    private GameSnakeSurfaceView mGameSnakeSurfaceView;
    private DialogFragment dlg1;

    /**
     * В конструктор объект уровня игры(в котором инициализированы все объекты игры)
     * В список записываем все контроллеры которые будут передвигать объекты, по ходу игры
     */
    public ThreadMotionObjectField(Level gameSnake, GameSnakeSurfaceView gameSnakeSurfaceView) {
        super(gameSnake);
        mList = mGameSnake.getControllers();
        /**
         * ПОТЫТКА НЕ ПЫТКА!
         */
        mGameSnakeSurfaceView = gameSnakeSurfaceView;
        dlg1 = new DialogSaveRecord();
    }

    /**
     * Метод вызван при запущенном потоке передвижения объектов
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
     * В методе пролистывая список контролеров, передвигаем объекты контроллерами
     */
    private void iteration(){
        Iterator<ObjectController> iter = mList.iterator();
        while (iter.hasNext()) {
            /*
            Когда у объекта состояние на false,
            тогда удаляем вьюху этого объекта
            */
            ObjectController tempObjectController = iter.next();
            if (objectInTheGame(tempObjectController)) {
                tempObjectController.nextMove();
            } else {
                /**
                 * ПОТЫТКА НЕ ПЫТКА!
                 *//*
               if(tempObjectController.getObject() instanceof Snake){
                   mGameSnakeSurfaceView.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           dlg1.show(mGameSnakeSurfaceView.getFragmentManager(), "dlg1");
                       }
                   });
               }*/

                iter.remove();
            }
        }
    }

    /**
     * Проверка, в игре ли еще объект
     */
    private boolean objectInTheGame(ObjectController objectController){
        if(objectController.getField().getFieldObject(objectController.getObject().getX(),
                objectController.getObject().getY()) != null ){
            return true;
        } else {
            return false;
        }
    }

}
