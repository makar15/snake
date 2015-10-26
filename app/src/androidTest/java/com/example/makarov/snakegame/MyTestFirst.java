package com.example.makarov.snakegame;

import android.test.AndroidTestCase;
import com.example.makarov.snakegame.controllers.ControlTheFieldObject;
import com.example.makarov.snakegame.controllers.ObjectController;
import com.example.makarov.snakegame.fieldObjects.TestObject;
import com.example.makarov.snakegame.playingField.Field;
import com.example.makarov.snakegame.playingField.MyField;

/**
 * Класс тестирования передвижения объекта по полю по кругу
 * В логи выводим сообщения о движении.
 */
public class MyTestFirst extends AndroidTestCase{

    public void testMedium(){

        Field myF = new MyField(10, 20);
        TestObject myFieldObj = new TestObject();
        ObjectController myObjController = new ControlTheFieldObject(myF, myFieldObj);
        //myF.addObject(myFieldObj, 7, 19);

        for(int i =0 ; i < 5 ; i++) {
            myObjController.nextMove();
        }

        assertTrue ("No result", myFieldObj.getX() == 8);
        assertTrue ("No result", myFieldObj.getY() == 19);
    }


    public void testSmall() {

        Field myF = new MyField(2, 3);
        TestObject myFieldObj = new TestObject();
        ObjectController myObjController = new ControlTheFieldObject(myF, myFieldObj);
        //myF.addObject(myFieldObj, 1, 2);

        for (int i = 0; i < 50; i++) {
            myObjController.nextMove();
        }

        assertTrue("No result", myFieldObj.getX() == 1);
        assertTrue("No result", myFieldObj.getY() == 1);

    }


    public void testLarge(){

        Field myF = new MyField(5000, 3000);
        TestObject myFieldObj = new TestObject();
        ObjectController myObjController = new ControlTheFieldObject(myF, myFieldObj);
        //myF.addObject(myFieldObj, 0, 0);

        for(int i =0 ; i < 50000 ; i++) {
            myObjController.nextMove();
        }

        assertTrue ("No result", myFieldObj.getX() == 2000);
        assertTrue ("No result", myFieldObj.getY() == 0);
    }
}
