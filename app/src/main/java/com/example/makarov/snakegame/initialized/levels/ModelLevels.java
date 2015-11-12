package com.example.makarov.snakegame.initialized.levels;

/**
 * Класс модели уровней игры
 */
public class ModelLevels {

    private String mNameLevels;
    private String mLineLevels;

    /**
     * В конструктор имя уровня и строка (txt файл уровня из папки ассетс переработаная в строку)
     */
    public ModelLevels(String nameLevels, String lineLevels) {
        mNameLevels = nameLevels;
        mLineLevels = lineLevels;
    }

    /**
     * Получить имя уровня
     */
    public String getNameLevels() {
        return mNameLevels;
    }

    /**
     * Получить строку уровня, для дальнейшего перерабатывания строки в объеты игры
     */
    public String getLineLevels() {
        return mLineLevels;
    }
}
