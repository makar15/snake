package com.example.makarov.snakegame;

import android.test.AndroidTestCase;
import com.example.makarov.snakegame.controllers.ControlTheFieldObject;
import com.example.makarov.snakegame.controllers.ObjectController;
import com.example.makarov.snakegame.fieldObjects.FieldObject;
import com.example.makarov.snakegame.fieldObjects.TestObjectField;
import com.example.makarov.snakegame.playingField.ControllerField;
import com.example.makarov.snakegame.playingField.Field;
import com.example.makarov.snakegame.playingField.MyField;

/**
 * Класс тестирования передвижения объекта по полю по кругу
 * В логи выводим сообщения о движении.
 *
 * Создаем: поле 5000 на 3000
 * контроллер поля
 * тестовыйОбъект
 * тестовый контролле крутящий объект по карте.
 *
 * Запускаем по циклу 50000 раз передвижение объекта
 */
public class MyTestThird extends AndroidTestCase{

    public void test(){

        Field myF = new MyField(5000, 3000);
        ControllerField myContrFiled = new ControllerField(myF);
        FieldObject myFieldObj = new TestObjectField();
        ObjectController myObjContr = new ControlTheFieldObject(myF, myFieldObj, myContrFiled);

        for(int i =0 ; i < 50000 ; i++) {
            myObjContr.nextMove();
        }

        assertTrue ("No result", myFieldObj.getX() == 2000 && myFieldObj.getY() == 0);
    }

}
