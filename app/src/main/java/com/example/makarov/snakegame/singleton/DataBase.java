package com.example.makarov.snakegame.singleton;

import android.content.Context;
import com.example.makarov.snakegame.Record;
import com.example.makarov.snakegame.db.Level;
import com.example.makarov.snakegame.db.BaseRecord;
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
    public BaseRecord saveRecord(Record createRecord){
        Realm mRealm = Realm.getInstance(mContext);
        mRealm.beginTransaction();
        BaseRecord record = mRealm.createObject(BaseRecord.class);
        record.setName(createRecord.getName());
        record.setScore(createRecord.getScore());
        mRealm.commitTransaction();

        return record;
    }

    /**
     * Получить список всех рекордов из БД
     */
    public RealmResults<BaseRecord> getRecords(){
        return Realm.getInstance(mContext).where(BaseRecord.class).findAll();
    }

    /**
     * Сохранить уровень игры в БД
     */
    public Level saveLevel(String name, String modelLevel){
        Realm realm = Realm.getInstance(mContext);
        realm.beginTransaction();
        Level level = new Level(name, modelLevel);
        realm.copyToRealmOrUpdate(level);
        realm.commitTransaction();

        return level;
    }

    /**
     * Получить список всех уровней из БД
     */
    public RealmResults<Level> getLevels(){
        return Realm.getInstance(mContext).where(Level.class).findAll();
    }

    /**
     *
     */
    public Level getLevel(int levelId) {
        return Realm.getInstance(mContext).where(Level.class).equalTo("id", levelId).findFirst();
    }

    /**
     *
     */
    public Level getLevel(String nameLevel) {
        return Realm.getInstance(mContext).where(Level.class).equalTo("name", nameLevel).findFirst();
    }

}
