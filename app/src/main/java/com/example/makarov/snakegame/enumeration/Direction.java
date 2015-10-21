package com.example.makarov.snakegame.enumeration;

/**
 * Перечисление направлений
 */
public enum Direction {
    /**
     * Набор возможных направлений
     */
    UP,
    RIGHT,
    DOWN,
    LEFT;
    /**
     * Методы решающие изменение координат при различных направлениях
     */
    public int deltaX() {
        switch (this) {
            case LEFT:
                return -1;
            case RIGHT:
                return 1;
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
            default:
                return 0;
        }
    }
}
