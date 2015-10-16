package com.example.makarov.snakegame;

/**
 *интерфейс игры
 */
public interface Game {
    /**
     *запустить игру
     */
    void start();
    /**
     *поставить на паузу, останавливать все внутриигровые действия
     */
    void pause();
    /**
     *вернуть размер экрана
     */
    int getScreenSize();
    /**
     *получить объект хранящий пользовательские нажатия на экран
     */
    Input getInput();
}
