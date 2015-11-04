package com.example.makarov.snakegame.direction.enumeration;

/**
 * Перечисление направлений
 */
public enum Direction {

    /*
     * Набор возможных направлений
     */
    UP,
    RIGHT,
    DOWN,
    LEFT,
    UNMOVING;

    /**
     * Методы решающие изменение координат при различных направлениях
     */
    public int deltaX() {
        switch (this) {
            case LEFT:
                return -1;
            case RIGHT:
                return 1;
            case UNMOVING:
                return 0;
            default:
                return 0;
        }
    }

    public int deltaY() {
        switch (this) {
            case UP:
                return -1;
            case DOWN:
                return 1;
            case UNMOVING:
                return 0;
            default:
                return 0;
        }
    }
}
