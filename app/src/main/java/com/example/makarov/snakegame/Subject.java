package com.example.makarov.snakegame;

/**
 *
 */
public interface Subject {

    /**
     *
     */
    void registerObserver(Observer observer);

    /**
     *
     */
    void removeObserver(Observer observer);

    /**
     *
     */
    void notifyObservers();
}
