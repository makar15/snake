package com.example.makarov.snakegame.objects;

import com.example.makarov.snakegame.direction.Moving;
import com.example.makarov.snakegame.direction.MovingObjectField;
import com.example.makarov.snakegame.direction.enumeration.Direction;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс змейки
 */
public class Snake implements FieldObject {

    public static final int CODE_SNAKE_ON_THE_MAP = 3;
    private Moving mMoving = new MovingObjectField();
    private LinkedList<ComponentSnake> mSnake ;
    private int mX = -1;
    private int mY = -1;
    private int mScore = 0;
    private int mGrowing = 0;
    private int mSpeed = 0;

    /**
     * В конструкторе ставим изначальное направление змейке,
     * Инициализируем список содержащий компонентыЗмейки
     */
    public Snake(int lengthSnake){
        mMoving.setDirection(Direction.UNMOVING);
        mSnake = new LinkedList<>();
        initSnakeLength(lengthSnake);
    }

    /*
     * Должен быть метод GO
     * который будет передвигать змейку на один шаг по направлению
     * и тогда сет иск и сетигрик не нужны(приватные сделать можно)
     */
    /**
     * Начиная с головы змейки, сетим компоненты змейки
     */
    public void initObject(int x, int y){
        int lagInit = 1;
        getHead().setXY(x, y);
        mX = x;
        mY = y;
        for(int i = mSnake.size() - 2; i >= 0 ;i --){
            mSnake.get(i).setXY(x - (lagInit * (this.getMoving().getDirection().deltaX())),
                    y - (lagInit * (this.getMoving().getDirection().deltaX())));
            lagInit += 1;
        }
    }

    /**
     * Сетим змейку
     * при первой инициализации змейки вызываем initObject
     */
    @Override
    public void setXY(int x, int y){
        if(mX != -1 && mY != -1){
            addComponent(x, y);
            if (mGrowing <= 0) {
                removeFirstComponent();
            } else {
                reduceGrowing(1);
            }
        }
        else {
            initObject(x, y);
        }
    }

    @Override
    public int getX() {
        return mSnake.get(0).getX();
    }

    @Override
    public int getY() {
        return mSnake.get(0).getY();
    }

    @Override
    public int getCode() {
        return CODE_SNAKE_ON_THE_MAP;
    }

    @Override
    public Moving getMoving() {
        return mMoving;
    }

    /**
     * добавление, уменьшение и сет методы скорости змейки
     */
    public void addSpeed(int addSpeed){
        int newSpeed = this.mSpeed + addSpeed;
        setSpeed(newSpeed);
    }

    public void reduceSpeed(int reduceSpeed){
        int newSpeed = this.mSpeed - reduceSpeed;
        setSpeed(newSpeed);
    }

    public void setSpeed(int newSpeed){
        this.mSpeed = newSpeed;
    }

    public int getSpeed() {
        return this.mSpeed;
    }

    /**
     * добавление, уменьшение, обнуление и сет методы очков набранных змейкой в игре
     * Еще сделать сохранение скор
     */
    public void addScore(int addScore) {
        int newScore = this.mScore + addScore;
        setScore(newScore);
    }

    public void reduceScore(int reduceScore){
        int newScore = this.mScore - reduceScore;
        setScore(newScore);
    }

    public void clearScore(){
        setScore(0);
    }

    public void setScore(int newScore){
        this.mScore = newScore;
    }

    public int getScore() {
        return this.mScore;
    }

    /**
     * добавление, уменьшение, обнуление и сет методы переменной прироста змейки
     */
    public void addGrowing(int addGrowing) {
        int newGrowing = this.mGrowing + addGrowing;
        setGrowing(newGrowing);
    }

    public void reduceGrowing(int reduceGrowing) {
        int newGrowing = this.mGrowing - reduceGrowing;
        setGrowing(newGrowing);
    }

    public void setGrowing(int newGrowing) {
        this.mGrowing = newGrowing;
    }

    public void clearGrowing(){
        setGrowing(0);
    }

    public int getGrowing() {
        return mGrowing;
    }

    /**
     * Инициализируем изначальную длину змейки
     */
    private void initSnakeLength(int count){
        for(int i = 0; i < count; i++) {
            mSnake.add(new ComponentSnake());
        }
    }

    /**
     * Добавить к змейке компаненту
     * Используется для передвижения змейки, добавляя компонент в начало(перед головой)
     */
    public void addComponent(int x, int y){
        ComponentSnake tempComp = new ComponentSnake();
        mSnake.add(tempComp);
        tempComp.setXY(x, y);
        mX = x;
        mY = y;
    }

    /**
     * Удалить компаненту змейки
     * Используется для передвижения змейки, удаляя последний элемент(с хвоста)
     */
    public void removeFirstComponent(){
        mSnake.get(0).setXY(0, 0);
        mSnake.removeFirst();
    }

    /**
     * Вернуть весь список компанентов змейки
     */
    public List<ComponentSnake> getComponents() {
        return this.mSnake;
    }

    /**
     * вернуть голову змейки
     */
    public ComponentSnake getHead(){
        return mSnake.getLast();
    }

}
