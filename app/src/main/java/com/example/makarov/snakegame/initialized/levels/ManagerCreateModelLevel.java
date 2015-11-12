package com.example.makarov.snakegame.initialized.levels;

import android.content.Context;
import com.example.makarov.snakegame.convert.TxtToString;
import com.example.makarov.snakegame.singleton.DataBase;
import java.io.IOException;

/**
 * Класс создания модель уровня и сохранения моделей в БД Realm
 */
public class ManagerCreateModelLevel {

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
    public ManagerCreateModelLevel(Context context) throws IOException {

        TxtToString convert = new TxtToString(context);

        for(int i = 1; i <= folderLevels.length; i++){
            DataBase.getInstance().
                    saveLevels(new ModelLevels(nameLevels[i - 1],
                            convert.convertTxtString(folderLevels[i - 1])));
        }
    }

}
