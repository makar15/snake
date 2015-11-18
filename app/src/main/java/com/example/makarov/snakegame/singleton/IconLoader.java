package com.example.makarov.snakegame.singleton;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.example.makarov.snakegame.R;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс хранящий все Bitmap-ы игры
 */
public class IconLoader {

    /*
     * cache - хранит все картинки по type
     * iconConfig - хранит путь к картинке по type
     */
    private Map<Integer, Bitmap> cache = new HashMap<>();
    private Map<Integer, Integer> iconConfig = new HashMap<>();
    private final Context mContext;

    /*
     * type картинкок игры
     */
    public final static int TYPE_FRUITE = 0;
    public final static int TYPE_TEST_OBJECT = 1;
    public final static int TYPE_FIELD = 2;
    public final static int TYPE_VEGETABLE = 3;
    public final static int TYPE_WALL = 4;
    public final static int TYPE_BOMB = 5;
    public final static int TYPE_SNAKE = 6;

    /**
     * В конструктор Context на котором отрисовываем картинки
     */
    public IconLoader(Context context){
        mContext = context;
        initConfig();
    }

    /**
     * В map добавляем все пути к картинкам
     * В дальнейшем по type будем вытаскивать путь и пользоваться картинкой
     */
    private void initConfig(){
        iconConfig.put(TYPE_FRUITE, R.drawable.fruite);
        iconConfig.put(TYPE_TEST_OBJECT, R.drawable.object);
        iconConfig.put(TYPE_FIELD, R.drawable.field_new);
        iconConfig.put(TYPE_VEGETABLE, R.drawable.vegetable);
        iconConfig.put(TYPE_WALL, R.drawable.wall);
        iconConfig.put(TYPE_BOMB, R.drawable.bomb);
        iconConfig.put(TYPE_SNAKE, R.drawable.snake);

    }

    /**
     * В методе возвращаем картинку изи map(Если уже её брали хотя бы раз) ,или
     * из ресурсов по её type , нужных размеров
     */
    public Bitmap getIcon(int type, int width, int height) {
        Bitmap icon = cache.get(type);

        if (icon != null) {
            return icon;
        } else {
            int iconId = iconConfig.get(type);
            icon = BitmapFactory.decodeResource(mContext.getResources(), iconId);
            icon = Bitmap.createScaledBitmap(icon, width, height, true);

            cache.put(type, icon);
            return icon;
        }
    }
}
