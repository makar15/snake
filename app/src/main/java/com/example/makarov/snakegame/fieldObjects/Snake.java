package com.example.makarov.snakegame.fieldObjects;

import com.example.makarov.snakegame.enumeration.Direction;
import java.util.LinkedList;

public class Snake implements FieldObject{
    /**
     * Класс змейки
     * все переменные змейки с нужными сет и гет методами
     */
    public static final int CODE_SNAKE_ON_THE_MAP = -1;
    private LinkedList<ComponentSnake> mSnake ;
    private int mScore=0;
    private Direction mDirection ;
    private int isGrowing = 0;
    private int mSpeed = 700;
    /**
     * В конструкторе создаем змеку состоящую из компонентов
     * Сет и Гет методы координат и код змейки на карте
     */
    public Snake(int x, int y, Direction direction){
        mSnake = new LinkedList<>();
        this.mDirection = direction;
        addComponentSnake(x, y);
        addComponentSnake(x - mDirection.deltaX(), y - mDirection.deltaY());
    }

    @Override
    public void setX(int x) {
        mSnake.getLast().setX(x);
    }

    @Override
    public void setY(int y) {
        mSnake.getLast().setY(y);
    }

    @Override
    public int getX() {
        return mSnake.getLast().getX();
    }

    @Override
    public int getY() {
        return mSnake.getLast().getY();
    }

    @Override
    public int getCodeOnTheMap() {
        return this.CODE_SNAKE_ON_THE_MAP;
    }
    /**
     * Сет и Гет метод переменной направления змйеки : Юг, Запад ...
     */
    public void setDirection(Direction newDirection) {
        this.mDirection = newDirection;
    }

    public Direction getDirection() {
        return this.mDirection;
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
    public void addIsGrowing(int addIsGrowing) {
        int newIsGrowing = this.isGrowing + addIsGrowing;
        setIsGrowing(newIsGrowing);
    }

    public void reduceIsGrowing(int reduceIsGrowing) {
        int newIsGrowing = this.isGrowing - reduceIsGrowing;
        setIsGrowing(newIsGrowing);
    }

    public void setIsGrowing(int newIsGrowing) {
        this.isGrowing = newIsGrowing;
    }

    public void clearIsGrowing(){
        setIsGrowing(0);
    }

    public int getIsGrowing() {
        return isGrowing;
    }
    /**
     * добавление, удаление компоненты змейки
     * вернуть колличество компонент в змейке(длину змнйки)
     * вернуть список компонент змейки
     */
    public void addComponentSnake(int x, int y){
        mSnake.add(new ComponentSnake(x, y));
        setX(x);
        setY(y);
    }

    public void removeFirstComponentSnake(){
        mSnake.removeFirst();
    }

    public int getSnakeLength() {
        return  mSnake.size();
    }

    public LinkedList<ComponentSnake> getListSnake() {
        return this.mSnake;
    }

    public ComponentSnake getLastComponentSnake(){
        return mSnake.getLast();
    }

    public ComponentSnake getFirstComponentSnake(){
        return mSnake.getFirst();
    }

}
