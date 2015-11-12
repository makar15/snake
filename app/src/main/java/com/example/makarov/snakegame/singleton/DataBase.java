package com.example.makarov.snakegame.singleton;

import android.content.Context;
import com.example.makarov.snakegame.Record;
import com.example.makarov.snakegame.db.BaseLevels;
import com.example.makarov.snakegame.db.BaseRecords;
import com.example.makarov.snakegame.initialized.levels.ModelLevels;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Класс работы с базой данных Realm
 */
public class DataBase {

    private Context mContext;
    private static DataBase mInstance;

    private DataBase(Context context){
        mContext = context;
    }

    /**
     * Класс инициализации объекта (объект синглетон)
     */
    public static void initInstance(Context context) {
        if (mInstance == null) {
            mInstance = new DataBase(context);
        }
    }

    /**
     * получить объект
     */
    public static DataBase getInstance() {
        return mInstance;
    }

    /**
     * Схоранить рекорд в БД
     */
    public void saveRecord(Record createRecord){
        Realm mRealm = Realm.getInstance(mContext);
        mRealm.beginTransaction();
        BaseRecords record = mRealm.createObject(BaseRecords.class);
        record.setName(createRecord.getName());
        record.setScore(createRecord.getScore());
        mRealm.commitTransaction();
    }

    /**
     * Получить список всех рекордов из БД
     */
    public RealmResults<BaseRecords> getAllRecords(){
        return Realm.getInstance(mContext).where(BaseRecords.class).findAll();
    }

    /**
     * Сохранить уровень игры в БД
     */
    public void saveLevels(ModelLevels modelLevels){
        Realm mRealm = Realm.getInstance(mContext);
        mRealm.beginTransaction();
        BaseLevels levels = mRealm.createObject(BaseLevels.class);
        levels.setName(modelLevels.getNameLevels());
        levels.setModelLevel(modelLevels.getLineLevels());
        mRealm.commitTransaction();
    }

    /**
     * Получить список всех уровней из БД
     */
    public RealmResults<BaseLevels> getAllLevels(){
        return Realm.getInstance(mContext).where(BaseLevels.class).findAll();
    }
}
