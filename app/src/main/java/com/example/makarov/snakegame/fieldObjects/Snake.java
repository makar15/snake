package com.example.makarov.snakegame.fieldObjects;

import com.example.makarov.snakegame.direction.DirectionOfMotion;
import com.example.makarov.snakegame.direction.DirectionOfMotionObjectField;
import com.example.makarov.snakegame.enumeration.Direction;
import java.util.LinkedList;
/**
 * Класс змейки
 * все переменные змейки с нужными сет и гет методами
 */
public class Snake implements FieldObject {

    public static final int CODE_SNAKE_ON_THE_MAP = -1;
    private DirectionOfMotion mDirectionOfMotion = new DirectionOfMotionObjectField();
    private LinkedList<ComponentSnake> mSnake ;
    private int mScore=0;
    private int mGrowing = 0;
    private int mSpeed = 700;
    /**
     * В конструкторе создаем змейку состоящую из компонент
     * Сет и Гет методы координат и код змейки на карте
     */
    public Snake(int x, int y, Direction direction){
        /**
         *  инициализация в внутри контроллера поля наверное
         *  ИЗМЕНИТЬ!
         */
        mSnake = new LinkedList<>();
        this.mDirectionOfMotion.setDirection(direction);
        upSnakeLength(x, y);
        upSnakeLength(x - mDirectionOfMotion.getDirection().deltaX(),
                y - mDirectionOfMotion.getDirection().deltaY());
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
     *  Получить объект управления змейкой
     */
    public DirectionOfMotion getDirectionOfMotion() {
        return mDirectionOfMotion;
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
     * МЕТОДЫ ПОКА НЕ ДОРАБОТАНЫ
     * ЭТОТ МОМЕНТ НУЖНО ЕЩЕ ПРОДУМАТЬ
     */
    public void upSnakeLength(int x, int y){
        mSnake.add(new ComponentSnake());
        setX(x);
        setY(y);
    }

    public void removeFirstComponentSnake(){
        mSnake.removeFirst();
    }

    public LinkedList<ComponentSnake> getListSnake() {
        return this.mSnake;
    }

    public ComponentSnake getHeadSnake(){
        return mSnake.getLast();
    }

}
