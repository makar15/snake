package com.example.makarov.snakegame.initialized.threads;

import com.example.makarov.snakegame.initialized.levels.Level;

/**
 * Абстрактный класс потоков игры
 */
public abstract class GameThreads extends Thread {

    protected boolean myThreadRun = false;
    protected Level mGameSnake;

    /**
     * В конструктор уровень игры
     */
    public GameThreads(Level gameSnake){
        mGameSnake = gameSnake;
    }

    /**
     * Метод изменения состояния работы потока отрисовки
     */
    public void setRunning(boolean b) {
        myThreadRun = b;
    }

    /**
     * Метод работ приложения при запущеном потоке
     */
    @Override
    public abstract void run();

}
