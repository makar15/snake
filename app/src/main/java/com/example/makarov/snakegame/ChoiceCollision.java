package com.example.makarov.snakegame;

import com.example.makarov.snakegame.fieldObjects.Bomb;
import com.example.makarov.snakegame.fieldObjects.FieldObject;
import com.example.makarov.snakegame.fieldObjects.Fruite;
import com.example.makarov.snakegame.fieldObjects.Vegetable;
import com.example.makarov.snakegame.fieldObjects.Wall;
import com.example.makarov.snakegame.handlerСollision.CollisionSnakeWithBomb;
import com.example.makarov.snakegame.handlerСollision.CollisionSnakesWithVegetables;
import com.example.makarov.snakegame.handlerСollision.CollisionWithSnakeFruit;
import com.example.makarov.snakegame.handlerСollision.CollisionWithTheWallMovingObjectField;
import com.example.makarov.snakegame.handlerСollision.HandlerCollision;
import com.example.makarov.snakegame.playingField.Field;
/**
 * Класс контроллера столкновений
 */
public class ChoiceCollision {

    private HandlerCollision collisionSnakesVegetables;
    private HandlerCollision collisionSnakesBomb;
    private HandlerCollision collisionSnakesFruit;
    private HandlerCollision collisionMovingObjectFieldAndWall;
    private final Field mField;
    /**
     * В конструктор поле на котором играем и инизиализация объектов различных столкновений
     */
    public ChoiceCollision(Field field){
        mField = field;
        collisionSnakesVegetables = new CollisionSnakesWithVegetables(mField);
        collisionSnakesBomb = new CollisionSnakeWithBomb(mField);
        collisionSnakesFruit = new CollisionWithSnakeFruit(mField);
        collisionMovingObjectFieldAndWall = new CollisionWithTheWallMovingObjectField(mField);
    }
    /**
     * метода определяет (по коду на карте) между какими объектами столкновение
     * и запускает нужный хэндлер для решения столкновения
     */
    public void solutionCollision(FieldObject object, int x, int y){
            if( mField.getCodeFieldByPosition(x ,y) == Bomb.CODE_BOMB_ON_THE_MAP){
                collisionSnakesBomb.processingCollision(object, x, y);
            }
            else if(mField.getCodeFieldByPosition(x ,y) == Vegetable.CODE_VEGETABLE_ON_THE_MAP){
                collisionSnakesVegetables.processingCollision(object, x, y);
            }
            else if(mField.getCodeFieldByPosition(x ,y) == Fruite.CODE_FRUITE_ON_THE_MAP){
                collisionSnakesFruit.processingCollision(object, x, y);
            }
            else if(mField.getCodeFieldByPosition(x ,y) == Wall.CODE_WALL_ON_THE_MAP){
                collisionMovingObjectFieldAndWall.processingCollision(object, x, y);
            }
    }
    /**
     *  Вернуть поле на котором смотрим столкновение каких именно  объектов
     */
    public Field getField() {
        return this.mField;
    }

}
