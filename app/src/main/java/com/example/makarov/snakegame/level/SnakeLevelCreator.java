package com.example.makarov.snakegame.level;

import com.example.makarov.snakegame.MyApp;
import java.io.IOException;

/**
 * Класс создания модели уровней и сохранения моделей в БД Realm
 */
public class SnakeLevelCreator {

    /**
     * Массив всех существующих уровней в формате txt в папке assets
     */
    private String[] folderLevels ={
            "levels/levelTest.txt", "levels/level1.txt", "levels/level2.txt", "levels/level3.txt",
            "levels/level4.txt", "levels/level5.txt"
    };

    /**
     * Массив названий существующих уровней игры
     */
    private String[] nameLevels = {
            "first", "surprise", "many walls", "box",
            "in a locked", "ridge"
    };

    /**
     * В конструкторе передаем данные модели уровней в Realm
     * здесь же и конвертируем txt файл в string
     */
    public SnakeLevelCreator() throws IOException {

        for(int i = 1; i <= folderLevels.length; i++){
            MyApp.getApp().getDataBase().
                    saveLevel(nameLevels[i - 1],
                            MyApp.getApp().getTxtToString().convertTxtString(folderLevels[i - 1]));
        }
    }

}
