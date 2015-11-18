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

    private final Context mContext;

    public DataBase(Context context){
        mContext = context;
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
     * Получить уровень по id модели уровня
     */
    public Level getLevel(int levelId) {
        return Realm.getInstance(mContext).where(Level.class).equalTo("id", levelId).findFirst();
    }

    /**
     * Получить уровень по названию модели уровня
     */
    public Level getLevel(String nameLevel) {
        return Realm.getInstance(mContext).where(Level.class).equalTo("name", nameLevel).findFirst();
    }

}
