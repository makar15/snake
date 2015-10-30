package com.example.makarov.snakegame;

import android.graphics.Canvas;
import java.util.concurrent.atomic.AtomicBoolean;
/**
 * Класс не используется
 * Возможно и не нужен будет
 * Потом удалю
 */
public class GamePlay extends Canvas implements Game, Runnable {

    private Thread gameThread;
    private AtomicBoolean running;
    private Input mInput;
    /**
     * Инициализируем переменные:
     * running - управляет паузы и старта игры
     * mInput - объект хранящий нажатия пользователя
     */
    public GamePlay() {
        running = new AtomicBoolean(false);
        initInput();
        initFocusListener();
    }
    /**
     *Инициализируем объект хранящий нажатия пользователя
     */
    private void initInput() {
        mInput = new Input();
    }
    /**
     *управление паузой игры
     */
    private void initFocusListener() {

    }
    /**
     *запуск игры
     */
    @Override
    public void start() {
        if (running.compareAndSet(false, true)) {
            gameThread = new Thread(this);
            gameThread.start();
        }
    }
    /**
     *ставим игру на паузу
     */
    @Override
    public void pause() {
        if (running.compareAndSet(true, false)) {
            try {
                gameThread.join();
            } catch (InterruptedException exception) {
                throw new RuntimeException(exception);
            }
        }
    }
    /**
     *вернуть объект следящий за нажатиями пользователя
     */
    @Override
    public Input getInput() {
        return mInput;
    }
    /**
     *Метод запускающий действия (логику игры)
     */
    public void update(){

    }
    /**
     *поток в котором происходит:
     * 1) проверяем не находиться ли игра на паузе
     * 2) получаем объект который будет уметь отрисовывать
     * 3) вызываем методы update() и draw() экрана
     */
    @Override
    public void run() {

    }
}
