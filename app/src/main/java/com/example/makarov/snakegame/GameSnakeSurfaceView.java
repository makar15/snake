package com.example.makarov.snakegame;

import android.app.DialogFragment;
import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.example.makarov.snakegame.initialized.levels.CreateLevel;
import com.example.makarov.snakegame.initialized.threads.SurfaceThread;
import com.example.makarov.snakegame.initialized.threads.ThreadMotionObjectField;
import com.example.makarov.snakegame.window.DialogSaveRecord;
import java.io.IOException;

/**
 * Класс Игры змейки
 */
public class GameSnakeSurfaceView extends SurfaceView implements SurfaceHolder.Callback, Observer{

    private SurfaceThread drawThread;
    private ThreadMotionObjectField threadMotionObject;
    private CreateLevel mLevelSnake;
    private IconLoader myIconLoader;
    private CreateDialog mDialog;
    private DialogFragment dlSaveRecord;

    /**
     * В конструктор контекст
     */
    public GameSnakeSurfaceView(Context context, CreateDialog dialog) {
        super(context);
        getHolder().addCallback(this);

        mDialog = dialog;
        dlSaveRecord = new DialogSaveRecord();

        /**
         * БД вроде записывает
         * судя по дебагу все верно!
         * но что то не нравиться компилятору(
         */
/*
        Realm realm = Realm.getInstance(context);
        realm.beginTransaction();

        Record record = realm.createObject(Record.class);
        record.setName("Аллешик");
        record.setScore(185);
        Record record1 = realm.createObject(Record.class);
        record1.setName("Ваассян");
        record1.setScore(174);
        Record record2 = realm.createObject(Record.class);
        record2.setName("Геоошан");
        record2.setScore(52);

        realm.commitTransaction();
        RealmResults<Record> result2 = realm.where(Record.class).findAll();*/
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
     *
     */
    @Override
    public void update() {
        drawThread.setRunning(false);
        mDialog.createDialog(dlSaveRecord);
    }
}

