package com.example.makarov.snakegame.handlerСollision;

import com.example.makarov.snakegame.fieldObjects.Bomb;
import com.example.makarov.snakegame.fieldObjects.FieldObject;
import com.example.makarov.snakegame.fieldObjects.Fruite;
import com.example.makarov.snakegame.fieldObjects.Snake;
import com.example.makarov.snakegame.fieldObjects.Vegetable;
import com.example.makarov.snakegame.fieldObjects.Wall;
import com.example.makarov.snakegame.handlerСollision.CollisionSnakesWithVegetables;
import com.example.makarov.snakegame.handlerСollision.CollisionSnakeWithBomb;
import com.example.makarov.snakegame.handlerСollision.CollisionWithSnakeFruit;
import com.example.makarov.snakegame.handlerСollision.CollisionWithTheWallSnakes;
import com.example.makarov.snakegame.handlerСollision.HandlerCollision;
import com.example.makarov.snakegame.playingField.Field;

public class ControllerCollision {
    /**
     * Класс контроллера столкновений
     * В конструктор поле на котором играем и объектов классов различных столкновений
     * метода solutionCollision определяет (по коду на карте) между какими объектами столкновение
     * и запускает нужный хэндлер для решения столкновения
     */
    private HandlerCollision collisionSnakesVegetables;
    private HandlerCollision collisionSnakesBomb;
    private HandlerCollision collisionSnakesFruit;
    private HandlerCollision collisionSnakesWall;
    private final Field mField;

    public ControllerCollision(Field field){
        mField = field;
        collisionSnakesVegetables = new CollisionSnakesWithVegetables(mField);
        collisionSnakesBomb = new CollisionSnakeWithBomb(mField);
        collisionSnakesFruit = new CollisionWithSnakeFruit(mField);
        collisionSnakesWall = new CollisionWithTheWallSnakes(mField);
    }

    /**
     * Тут еще метод недоработан
     * пока не придумал как лучше
     * сейчас почитаю про java дженерики и так уже буду думать
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
                collisionSnakesWall.processingCollision(object, x, y);
            }
    }

    public Field getField() {
        return this.mField;
    }

}
