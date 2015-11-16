package com.example.makarov.snakegame;

import android.app.DialogFragment;
import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.example.makarov.snakegame.convert.StringToCreateLevelCreator;
import com.example.makarov.snakegame.initialized.levels.LevelCreator;
import com.example.makarov.snakegame.initialized.threads.SurfaceThread;
import com.example.makarov.snakegame.initialized.threads.ThreadMotionObjectField;
import com.example.makarov.snakegame.observer.Observer;
import com.example.makarov.snakegame.window.dialog.DialogSaveRecord;

/**
 * Класс Игры змейки
 */
public class GameSnakeSurfaceView extends SurfaceView implements SurfaceHolder.Callback, Observer {

    private SurfaceThread drawThread;
    private ThreadMotionObjectField threadMotionObject;
    private CreateDialog mDialog;
    private DialogFragment dlSaveRecord;
    private Record record;
    private String lineModelLevel;
    private LevelCreator gameLevelCreator;

    /**
     * В конструктор контекст, объект для создания диалоговых окон, DataBaseScore
     */
    public GameSnakeSurfaceView(Context context, CreateDialog dialog, int idLevel) {
        super(context);
        getHolder().addCallback(this);

        /*
        инициализируем:
        объект, который будет хранить рекорд игры
        объект, умеющий запускать диалоговые окна
        диалоговое окно, которое отобразиться при завершении игры
         */
        record = new Record();
        mDialog = dialog;

        lineModelLevel = MyApp.getApp().getDataBase().getLevel(idLevel).getBody();
        dlSaveRecord = new DialogSaveRecord(record, mDialog);
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

        gameLevelCreator = new StringToCreateLevelCreator
                (this, MyApp.getApp().getIconLoader(), lineModelLevel);

        threadMotionObject = new ThreadMotionObjectField(gameLevelCreator, this);
        drawThread = new SurfaceThread(getHolder(), gameLevelCreator);
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
     * Метод сработает в случае, когда в объекте, на который подписан этот класс изменится состояние
     * В методеМеняем состояние потока отрисовки
     * Запускаем диалоговое окно
     */
    @Override
    public void update() {
        drawThread.setRunning(false);
        mDialog.createDialog(dlSaveRecord);
    }

    /**
     * Вернуть объект, который хранит рекорд игры
     */
    public Record getRecord() {
        return record;
    }

}

