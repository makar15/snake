package com.example.makarov.snakegame.initialized.levels;

import android.content.res.AssetManager;

import com.example.makarov.snakegame.controllers.ObjectController;
import com.example.makarov.snakegame.controllers.TouchResponseSnakeController;
import com.example.makarov.snakegame.field.MyField;
import com.example.makarov.snakegame.initialized.FieldProvider;
import com.example.makarov.snakegame.initialized.IconLoader;
import com.example.makarov.snakegame.objects.Bomb;
import com.example.makarov.snakegame.objects.Fruite;
import com.example.makarov.snakegame.objects.Snake;
import com.example.makarov.snakegame.objects.Vegetable;
import com.example.makarov.snakegame.objects.Wall;
import com.example.makarov.snakegame.view.BombView;
import com.example.makarov.snakegame.view.FieldView;
import com.example.makarov.snakegame.view.FruiteView;
import com.example.makarov.snakegame.view.SnakeView;
import com.example.makarov.snakegame.view.VegetableView;
import com.example.makarov.snakegame.view.View;
import com.example.makarov.snakegame.view.WallView;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Класс создания своей карты для игры
 * В папке assets/levels создать txt файл !
 */
public class CreateLevel implements Level{

    private android.view.View mGameSnake;
    private Collection<ObjectController> mListController = new LinkedList<>();
    private Collection<com.example.makarov.snakegame.view.View> mListView = new LinkedList<>();
    private FieldView myFieldView;
    private IconLoader mIconLoader;
    private FieldProvider mFieldProvider;
    private MyField myField;

    /**
     * В конструктор View на котором отрисовываем игру, объукт со всеми Bitmap-ами для игры
     */
    public CreateLevel(android.view.View gameSnake, IconLoader iconLoader) throws IOException {

        /*
         * Инициализируем:
         * view экран, на котором все отрисовываем
         * объект со всеми содержащими bitmap-ами
         */
        mGameSnake = gameSnake;
        mIconLoader = iconLoader;

        /*
         * АссетсМенеджером получаем доступ к файлам папка Assets
         * в строку переносим все данные в файле уровня
         * и с разделением пробелов и переносов строки записывает в массив
         */
        AssetManager assetManager = mGameSnake.getContext().getAssets();
        InputStream inputStream = null;
        inputStream = assetManager.open("levels/level1.txt");
        String text = loadTextFile(inputStream);
        //String[] masstext = text.split("\\s+");  Заменит следующие операции,
        // но не позволяет узнать ширину поля заранее(

        /*
         * строку символов файла разбивая на подстроки записываем водномерный массив,
         * далее в двумерный массив разбивая уже по пробелам между символами
         */
        String[] masstext = text.split("\\n");
        String[][] massOne = new String[masstext.length][];

        for(int k = 0; k < masstext.length; k++){
            massOne[k] = masstext[k].split(" ");
        }

        /*
         * узнаем размеры карты игры
         */
        int x = massOne[0].length;
        int y = massOne.length ;

        /*
         * Создаем:
         * поле
         * провайдер поля
         * view поля
         */
        myField = new MyField(x, y);
        mFieldProvider = new FieldProvider(mGameSnake, myField.getWidth() ,myField.getHeight());
        myFieldView = new FieldView(myField, mFieldProvider, mIconLoader);

        initMapGame(massOne);
    }

    /**
     * В методе файл переводим в массив байт и получаем из массива байт строку символов
     */
    public String loadTextFile(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[2048];
        int len = 0;
        while ((len = inputStream.read(bytes)) > 0)
            byteStream.write(bytes, 0, len);
        return new String(byteStream.toByteArray(), "UTF8");
    }

    /**
     * В методе перебираем двумерный массив типа стринг
     * и запускаем метод создания объектов игры в случае когда это следует делать
     */
    public void initMapGame(String[][] mass){
        for (int j = 0; j < mass.length; j ++){
            for(int i = 0; i < mass[0].length; i++) {
                if (mass[j][i] != "0"){
                    createObjectGame(mass[j][i], i, j);
                }
            }
        }
    }

    /**
     * В методе по символу в текстовом файле уровня и расположению символа , создаем объекты игры
     */
    public void createObjectGame(String count, int x, int y) {
        switch (count){
            case "3":
                Snake mySnake = new Snake(3);
                ObjectController myObjContr =
                        new TouchResponseSnakeController(myField, mySnake, mGameSnake, mFieldProvider);
                myField.addObject(mySnake, x, y);
                View mySnakeView =
                        new SnakeView(mySnake, mFieldProvider, mIconLoader);
                mListController.add(myObjContr);
                mListView.add(mySnakeView);
                break;
            case "5":
                Wall myWall = new Wall();
                myField.addObject(myWall, x, y);
                View myWallView =
                        new WallView(myWall, mFieldProvider, mIconLoader);
                mListView.add(myWallView);
                break;
            case "7":
                Fruite myFruite = new Fruite();
                myField.addObject(myFruite, x, y);
                View myFruiteView =
                        new FruiteView(myFruite, mFieldProvider, mIconLoader);
                mListView.add(myFruiteView);
                break;
            case "11":
                Bomb myBomb = new Bomb();
                myField.addObject(myBomb, x, y);
                View myBombView =
                        new BombView(myBomb, mFieldProvider, mIconLoader);
                mListView.add(myBombView);
                break;
            case "13":
                Vegetable myVegetable = new Vegetable();
                myField.addObject(myVegetable, x, y);
                View myVegetableView =
                        new VegetableView(myVegetable, mFieldProvider, mIconLoader);
                mListView.add(myVegetableView);
                break;
            default:

                break;
        }
    }

    @Override
    public FieldView getFieldView() {
        return myFieldView;
    }

    @Override
    public Collection<ObjectController> getControllers(){
        return mListController;
    }

    @Override
    public Collection<View> getViews(){
        return mListView;
    }
}
