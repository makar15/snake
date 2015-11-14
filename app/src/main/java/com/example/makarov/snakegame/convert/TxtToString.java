package com.example.makarov.snakegame.convert;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Класс ковертирующий txt файл в строку
 */
public class TxtToString {

    private Context mContext;
    private static TxtToString mInstance;

    private TxtToString(Context context){
        mContext = context;
    }

    /**
     * Класс инициализации объекта (объект синглетон)
     */
    public static void initInstance(Context context) {
        if (mInstance == null) {
            mInstance = new TxtToString(context);
        }
    }

    /**
     * получить объект
     */
    public static TxtToString getInstance() {
        return mInstance;
    }

    /**
     * Метод конвертирования
     */
    public String convertTxtString(String folder) throws IOException {
        /*
         * АссетсМенеджером получаем доступ к файлам папка Assets
         * в строку переносим все данные в файле уровня
         * и с разделением пробелов и переносов строки записывает в массив
         */
        AssetManager assetManager = mContext.getAssets();
        InputStream inputStream = null;
        inputStream = assetManager.open(folder);
        String text = loadTextFile(inputStream);

        return text;
    }

    /**
     * В методе, файл переводим в массив байт и получаем из массива байт строку символов
     */
    public String loadTextFile(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[2048];
        int len = 0;
        while ((len = inputStream.read(bytes)) > 0)
            byteStream.write(bytes, 0, len);
        return new String(byteStream.toByteArray(), "UTF8");
    }

}
