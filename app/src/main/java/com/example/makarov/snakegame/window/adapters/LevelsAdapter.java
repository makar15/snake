package com.example.makarov.snakegame.window.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.makarov.snakegame.R;
import com.example.makarov.snakegame.db.BaseLevels;
import io.realm.RealmResults;

/**
 * Класс адаптера списка рекордов
 */
public class LevelsAdapter extends BaseAdapter{

    private LayoutInflater mLInflater;
    private RealmResults<BaseLevels> listLevels;

    /**
     * В конструктор контекст, список с уровнями из базы данных Realm
     */
    public LevelsAdapter(Context cont, RealmResults<BaseLevels> list){
        listLevels = list;
        mLInflater = (LayoutInflater) cont.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listLevels.size();
    }

    @Override
    public Object getItem(int position) {
        return listLevels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * В методе формируем каждый уровень для отображения в ListView
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // используем созданные, но не используемые view
        View view = convertView;
        if (view == null) {
            //получаем LayoutInflater для работы с layout-ресурсами
            view = mLInflater.inflate(R.layout.item_level, parent, false);
        }
        BaseLevels tempLevels =  getLevels(position);
        ((TextView) view.findViewById(R.id.tvNameLevel)).
                setText("Name : " + tempLevels.getName());
        return view;
    }

    /**
     * Вернуть объект уровня по позиции
     */
    public BaseLevels getLevels(int position) {
        return ((BaseLevels) getItem(position));
    }
}
