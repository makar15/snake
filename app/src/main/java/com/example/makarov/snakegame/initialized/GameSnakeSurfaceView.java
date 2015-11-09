package com.example.makarov.snakegame.initialized;

import android.app.FragmentManager;
import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.example.makarov.snakegame.db.Record;
import com.example.makarov.snakegame.initialized.levels.CreateLevel;
import com.example.makarov.snakegame.initialized.threads.SurfaceThread;
import com.example.makarov.snakegame.initialized.threads.ThreadMotionObjectField;
import java.io.IOException;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Класс Игры змейки
 */
public class GameSnakeSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    private SurfaceThread drawThread;
    private ThreadMotionObjectField threadMotionObject;
    private CreateLevel mLevelSnake;
    private IconLoader myIconLoader;
    /**
     * ПОТЫТКА НЕ ПЫТКА!
     */
    private FragmentManager mFragmentManager;

    /**
     * В конструктор контекст
     */
    public GameSnakeSurfaceView(Context context, FragmentManager fragmentManager) {
        super(context);
        getHolder().addCallback(this);
        /**
         * ПОТЫТКА НЕ ПЫТКА!
         */
        mFragmentManager = fragmentManager;
        /**
         * БД вроде записывает
         * судя по дебагу все верно!
         * но что то не нравиться компилятору(
         */

        Realm realm = Realm.getInstance(context);
        realm.beginTransaction();

        Record record = realm.createObject(Record.class);
        record.setName("Алеша");
        record.setScore(105);
        Record record1 = realm.createObject(Record.class);
        record1.setName("Вася");
        record1.setScore(134);
        Record record2 = realm.createObject(Record.class);
        record2.setName("Юра");
        record2.setScore(85);

        realm.commitTransaction();
        RealmResults<Record> result2 = realm.where(Record.class).findAll();
    }

    /**
     * Метод вызывается, если был изменен формат или размер SurfaceView
     */
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {

    }

    /**
     * Метод вызывается, когда SurfaceView создан и готов к отображению информации
     * Инициализируем класс уровня игры
     * Инициализация и запуск потоков: передвижения объектов и прорисовки ViewObject игры
     */
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        myIconLoader = new IconLoader(this.getContext());
        try {
            mLevelSnake = new CreateLevel(this, myIconLoader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        threadMotionObject = new ThreadMotionObjectField(mLevelSnake, this);
        drawThread = new SurfaceThread(getHolder(), mLevelSnake);
        threadMotionObject.setRunning(true);
        drawThread.setRunning(true);
        threadMotionObject.start();
        drawThread.start();
    }

    /**
     * Метод вызывается перед тем, как SurfaceView будет уничтожен
     */
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        drawThread.setRunning(false);
        threadMotionObject.setRunning(false);
        while (retry) {
            try {
                drawThread.join();
                threadMotionObject.join();
                retry = false;
            } catch (InterruptedException e) {
            }
        }
    }

    /**
     * ПОТЫТКА НЕ ПЫТКА!
     */
    public FragmentManager getFragmentManager() {
        return mFragmentManager;
    }

}

