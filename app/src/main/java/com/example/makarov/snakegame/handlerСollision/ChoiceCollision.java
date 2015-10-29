package com.example.makarov.snakegame.handlerСollision;

import com.example.makarov.snakegame.fieldObjects.Bomb;
import com.example.makarov.snakegame.fieldObjects.FieldObject;
import com.example.makarov.snakegame.fieldObjects.Fruite;
import com.example.makarov.snakegame.fieldObjects.Snake;
import com.example.makarov.snakegame.fieldObjects.TestObject;
import com.example.makarov.snakegame.fieldObjects.Vegetable;
import com.example.makarov.snakegame.fieldObjects.Wall;
import com.example.makarov.snakegame.playingField.Field;
import java.util.HashMap;
import java.util.Map;
/**
 * Класс контроллера столкновений
 */
public class ChoiceCollision {

    private Map<Integer, HandlerCollision> map = new HashMap<>();
    private final Field mField;
    /**
     * В конструктор поле на котором играем и добавление в мапу:
     * ключам(произведение Кодов двух столкнувшихся объектов) и
     * хэндлера решающего коллизию между этими объектами
     */
    public ChoiceCollision(Field field){
        mField = field;

        map.put(Snake.CODE_SNAKE_ON_THE_MAP * Fruite.CODE_FRUITE_ON_THE_MAP,
                new CollisionSnakeFruit(mField));
        map.put(Snake.CODE_SNAKE_ON_THE_MAP * Bomb.CODE_BOMB_ON_THE_MAP,
                new CollisionSnakeBomb(mField));
        map.put(Snake.CODE_SNAKE_ON_THE_MAP * Vegetable.CODE_VEGETABLE_ON_THE_MAP,
                new CollisionSnakesVegetables(mField));
        map.put(Snake.CODE_SNAKE_ON_THE_MAP * Wall.CODE_WALL_ON_THE_MAP,
                new CollisionSnakesWall(mField));
        map.put(TestObject.CODE_TEST_OBJECT_ON_THE_MAP * Fruite.CODE_FRUITE_ON_THE_MAP,
                new CollisionTestObjectFruit(mField));
    }
    /**
     * метод определяет (по произведению Кодов двух объектов) между какими объектами столкновение
     * и запускает нужный хэндлер (из мапы по ключу) для решения столкновения
     */
    public void solutionCollision(FieldObject objectStress, FieldObject objectCollisions){
        int code = objectStress.getCodeOnTheMap() * objectCollisions.getCodeOnTheMap();

        HandlerCollision handlerCollision = map.get(code);
        if(handlerCollision != null) {
            handlerCollision.processingCollision(objectStress, objectCollisions);
        }
    }
    /**
     *  Вернуть поле на котором смотрим столкновение каких именно  объектов
     */
    public Field getField() {
        return this.mField;
    }

}
