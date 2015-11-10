package com.example.makarov.snakegame;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class GameOver implements Subject{

    private List<Observer> observers;
    private boolean stateLifeSnake = true;

    /**
     *
     */
    public GameOver(){
        observers = new ArrayList<>();
    }

    /**
     *
     */
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     *
     */
    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if(i >= 0) {
            observers.remove(observer);
        }
    }

    /**
     *
     */
    @Override
    public void notifyObservers() {
        for(int i = 0; i < observers.size(); i++){
            Observer observer = observers.get(i);
            observer.update();
        }
    }
}
