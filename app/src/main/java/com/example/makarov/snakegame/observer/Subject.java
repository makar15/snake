package com.example.makarov.snakegame.observer;


/**
 * Интерфейс для объектов, за которымы можно будет следить другим подписанным классам
 */
public interface Subject {

    /**
     * Подписаться на обновление событий
     */
    void registerObserver(Observer observer);

    /**
     * Отписаться от обновлений событий
     */
    void removeObserver(Observer observer);

    /**
     * Оповестить всех подписанных объектов
     */
    void notifyObservers();
}
