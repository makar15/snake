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
 * Создаем: поле 2 на 3
 * контроллер поля
 * тестовыйОбъект
 * тестовый контролле крутящий объект по карте.
 *
 * Запускаем по циклу 50 раз передвижение объекта
 */
public class MyTestSecond extends AndroidTestCase{

    public void test(){

        Field myF = new MyField(2, 3);
        ControllerField myContrFiled = new ControllerField(myF);
        FieldObject myFieldObj = new TestObjectField();
        ObjectController myObjContr = new ControlTheFieldObject(myF, myFieldObj, myContrFiled);

        for(int i =0 ; i < 50 ; i++) {
            myObjContr.nextMove();
        }

        assertTrue ("No result", myFieldObj.getX() == 1 && myFieldObj.getY() == 1);
    }

}
