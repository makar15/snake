package com.example.makarov.snakegame.window.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.makarov.snakegame.R;
import com.example.makarov.snakegame.db.BaseRecord;
import io.realm.RealmResults;

/**
 * Класс адаптера списка рекордов
 */
public class RecordAdapter extends BaseAdapter{

    private LayoutInflater mLInflater;
    private RealmResults<BaseRecord> mResult;

    /**
     * В конструктор контекст, список с рекордами из базы данных Realm
     */
    public RecordAdapter(Context cont, RealmResults<BaseRecord> result){
        mResult = result;
        mLInflater = (LayoutInflater) cont.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mResult.size();
    }

    @Override
    public Object getItem(int position) {
        return mResult.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * В методе формируем каждый рекорд для отображения в ListView
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // используем созданные, но не используемые view
        View view = convertView;
        if (view == null) {
            //получаем LayoutInflater для работы с layout-ресурсами
            view = mLInflater.inflate(R.layout.item_record, parent, false);
        }
        /*
        каждый объект рекорда записываем в список,
        а именно в элементы TextView из которых и состоит каждый элемент рекорда в списке,
        получав имя пользователя и колличество набранных очков в игре
         */
        BaseRecord tempRecord = getRecord(position);
        ((TextView) view.findViewById(R.id.tvNameUser)).
                setText("Name : " + tempRecord.getName());
        ((TextView) view.findViewById(R.id.tvScoreUser)).
                setText("Score : " + tempRecord.getScore());
        return view;
    }

    /**
     * Вернуть объект рекорда по позиции
     */
    public BaseRecord getRecord(int position) {
        return ((BaseRecord) getItem(position));
    }
}
