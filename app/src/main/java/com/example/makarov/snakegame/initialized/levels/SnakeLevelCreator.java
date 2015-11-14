package com.example.makarov.snakegame.initialized.levels;

import com.example.makarov.snakegame.singleton.TxtToString;
import com.example.makarov.snakegame.singleton.DataBase;
import java.io.IOException;

/**
 * Класс создания модель уровня и сохранения моделей в БД Realm
 */
public class SnakeLevelCreator {

    /**
     * Массив всех существующих уровней в формате txt в папке assets
     */
    private String[] folderLevels ={
            "levels/level1.txt", "levels/level2.txt", "levels/level3.txt", "levels/level4.txt",
            "levels/level5.txt"
    };

    /**
     * Массив названий существующих уровней игры
     */
    private String[] nameLevels = {
            "surprise", "many walls", "box", "in a locked",
            "ridge"
    };

    /**
     * В конструкторе создаем и сразу же сохраняем модели уровней в Realm
     * здесь же и конвертируем txt файл в string
     */
    public SnakeLevelCreator() throws IOException {

        for(int i = 1; i <= folderLevels.length; i++){
            DataBase.getInstance().
                    saveLevel(nameLevels[i - 1],
                            TxtToString.getInstance().convertTxtString(folderLevels[i - 1]));
        }
    }

}
