package com.example.makarov.snakegame.singleton;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Класс ковертирующий txt файл в строку
 */
public class TxtToString {

    private final Context mContext;

    public TxtToString(Context context){
        mContext = context;
    }

    /**
     * Метод конвертирования
     */
    public String convertTxtString(String folder) throws IOException {
        /*
         * АссетсМенеджером получаем доступ к файлам папки Assets
         * в строку переносим все данные в файле уровня
         */
        AssetManager assetManager = mContext.getAssets();
        InputStream inputStream = null;
        inputStream = assetManager.open(folder);
        String text = loadTextFile(inputStream);

        return text;
    }

    /**
     * В методе, файл переводим в массив байт и получаем из массива байт, строку символов
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
