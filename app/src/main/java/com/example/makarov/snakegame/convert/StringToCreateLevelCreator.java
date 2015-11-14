package com.example.makarov.snakegame.convert;

import com.example.makarov.snakegame.controllers.ObjectController;
import com.example.makarov.snakegame.controllers.TouchResponseSnakeController;
import com.example.makarov.snakegame.field.MyField;
import com.example.makarov.snakegame.FieldProvider;
import com.example.makarov.snakegame.singleton.IconLoader;
import com.example.makarov.snakegame.initialized.levels.LevelCreator;
import com.example.makarov.snakegame.objects.Bomb;
import com.example.makarov.snakegame.objects.Fruite;
import com.example.makarov.snakegame.objects.Snake;
import com.example.makarov.snakegame.objects.Vegetable;
import com.example.makarov.snakegame.objects.Wall;
import com.example.makarov.snakegame.view.FieldView;
import com.example.makarov.snakegame.view.View;
import com.example.makarov.snakegame.view.ViewFactory;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Класс ковертирующий строку -> String[][] -> уровень игры, со всеми объектами
 */
public class StringToCreateLevelCreator implements LevelCreator {

    private android.view.View mGameSnake;
    private Collection<ObjectController> mListController = new LinkedList<>();
    private Collection<com.example.makarov.snakegame.view.View> mListView = new LinkedList<>();
    private FieldView myFieldView;
    private IconLoader mIconLoader;
    private FieldProvider mFieldProvider;
    private MyField myField;
    private ViewFactory myViewFactory;

    /**
     * В конструкторе конвертируем
     */
    public StringToCreateLevelCreator(android.view.View gameSnake, IconLoader iconLoader, String lineLevel){

         /*
         * Инициализируем:
         * view экран, на котором все отрисовываем
         * объект со всеми содержащими bitmap-ами
         */
        mGameSnake = gameSnake;
        mIconLoader = iconLoader;

        //String[] massLines = text.split("\\s+");  Заменит следующие операции,
        // но не позволяет узнать ширину поля заранее(

        /*
         * строку символов файла разбивая на подстроки записываем в одномерный массив,
         * далее в двумерный массив разбивая уже по пробелам между символами
         */
        String[] massLines = lineLevel.split("\\n");
        String[][] massCodes = new String[massLines.length][];

        for(int k = 0; k < massLines.length; k++){
            massCodes[k] = massLines[k].split(" ");
        }

        /*
         * узнаем размеры карты игры
         */
        int x = massCodes[0].length;
        int y = massCodes.length ;
        /*
         * Создаем:
         * поле
         * провайдер поля
         * view поля
         * фабрику View(которая и будет создавать View элементы для игры)
         */
        myField = new MyField(x, y);
        mFieldProvider = new FieldProvider(mGameSnake, myField.getWidth() ,myField.getHeight());
        myFieldView = new FieldView(myField, mFieldProvider, mIconLoader);
        myViewFactory = new ViewFactory(mIconLoader, mFieldProvider);

        initMapGame(massCodes);
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
     * А далее объекту класса фабрики View отдаем задачу создания View элементы игры,
     * для каждого созданного объекта
     */
    public void createObjectGame(String count, int x, int y) {
        switch (count){
            case "3":
                Snake mySnake = new Snake(3);
                ObjectController myObjContr =
                        new TouchResponseSnakeController(myField, mySnake, mGameSnake, mFieldProvider);
                myField.addObject(mySnake, x, y);
                mListController.add(myObjContr);
                mListView.add(myViewFactory.createView(mySnake));
                break;
            case "5":
                Wall myWall = new Wall();
                myField.addObject(myWall, x, y);
                mListView.add(myViewFactory.createView(myWall));
                break;
            case "7":
                Fruite myFruite = new Fruite();
                myField.addObject(myFruite, x, y);
                mListView.add(myViewFactory.createView(myFruite));
                break;
            case "11":
                Bomb myBomb = new Bomb();
                myField.addObject(myBomb, x, y);
                mListView.add(myViewFactory.createView(myBomb));
                break;
            case "13":
                Vegetable myVegetable = new Vegetable();
                myField.addObject(myVegetable, x, y);
                mListView.add(myViewFactory.createView(myVegetable));
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
