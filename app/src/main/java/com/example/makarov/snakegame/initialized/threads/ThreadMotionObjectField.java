package com.example.makarov.snakegame.initialized.threads;

import com.example.makarov.snakegame.observer.GameOver;
import com.example.makarov.snakegame.observer.Observer;
import com.example.makarov.snakegame.observer.Subject;
import com.example.makarov.snakegame.controllers.ObjectController;
import com.example.makarov.snakegame.GameSnakeSurfaceView;
import com.example.makarov.snakegame.initialized.levels.Level;
import com.example.makarov.snakegame.objects.Snake;
import java.util.Collection;
import java.util.Iterator;

/**
 * Класс потока передвижения объектов игры, контроллерами
 */
public class ThreadMotionObjectField extends GameThreads implements Observer{

    private final int COUNT_FRAME_IN_SECOND = 12;
    private final int FREQUENCY = 1000 / COUNT_FRAME_IN_SECOND;
    private Collection<ObjectController> mList;
    private Subject gameOverSnake;
    private GameSnakeSurfaceView mGameSnakeSurfaceView;

    /**
     * В конструктор объект уровня игры(в котором инициализированы все объекты игры)
     * В список записываем все контроллеры которые будут передвигать объекты, по ходу игры
     * Сам объект запускающий потоки и создающий уровень игры
     */
    public ThreadMotionObjectField(Level gameSnake, GameSnakeSurfaceView gameSnakeSurfaceView) {
        super(gameSnake);
        mList = mGameSnake.getControllers();
        mGameSnakeSurfaceView = gameSnakeSurfaceView;

        /*
        Инициализация класса, который будет следить за состоянием игры
        и на события которого можно подписаться
        Подписываем объекты на события конца игры ( проигрыша в игре)
         */
        gameOverSnake = new GameOver();
        gameOverSnake.registerObserver(mGameSnakeSurfaceView);
        gameOverSnake.registerObserver(this);
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
                /*
                При удаленнии контроллера из игры, проверяем кем было его управление.
                В случае если змейкой, то записываем в объект рекорда, набранные очки
                 , далее оповещаем всех подписанных, на событие проигрыша в игре.
                 Далее удаляем контроллер
                 */
               if(tempObjectController.getObject() instanceof Snake){
                   Snake snake = (Snake) tempObjectController.getObject();
                   mGameSnakeSurfaceView.getRecord().setScore(snake.getScore().getScore());
                   gameOverSnake.notifyObservers();
               }
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

    /**
     * В случае проигрыша в игре, при подписке класса вызовиться этот метод
     * В методе измениться состояние на false, потока предевижение объектов контроллерами
     */
    @Override
    public void update() {
        this.setRunning(false);
    }

}
