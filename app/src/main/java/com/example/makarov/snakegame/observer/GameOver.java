package com.example.makarov.snakegame.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс который следит за проигрышем в игре
 * Пока что он не связан с коллизиями игры, которые первый уничтожают змейку
 * Пока что узнаю об этом в классе потоке прокручиваня контроллеров игры, в дальнейшем это изменю !!
 */
public class GameOver implements Subject {

    private List<Observer> observers;
    private boolean stateLifeSnake = true;

    /**
     * Инициализируется список для подписчиков на оповещения
     */
    public GameOver(){
        observers = new ArrayList<>();
    }

    /**
     * Подписаться на обновление событий
     */
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Отписаться от обновлений событий
     */
    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if(i >= 0) {
            observers.remove(observer);
        }
    }

    /**
     * Оповестить всех подписанных объектов
     */
    @Override
    public void notifyObservers() {
        for(int i = 0; i < observers.size(); i++){
            Observer observer = observers.get(i);
            observer.update();
        }
    }
}
