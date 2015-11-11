package com.example.makarov.snakegame.window;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.example.makarov.snakegame.R;
import com.example.makarov.snakegame.db.Record;
import com.example.makarov.snakegame.window.adapters.RecordAdapter;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Класс фрагмента со всеми рекордами из базы данных
 */
public class ListRecordFragment extends Fragment {

    private ListView lvRecord;
    private Realm realmDBScore;
    private RealmResults<Record> result;

    /**
     * В конструктор DataBaseScore
     */
    public ListRecordFragment(Realm realm){
        realmDBScore = realm;
    }

    /**
     * При создании фрагмента, создается список из рекордов с помощью адаптера
     * RecordAdapter и формирует список нужным образом
     */
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_record_fragment, null);

        lvRecord = (ListView) v.findViewById(R.id.lvRecord);

        result = realmDBScore.where(Record.class).findAll();

        RecordAdapter recordAdapter = new RecordAdapter(getActivity(), result);
        lvRecord.setAdapter(recordAdapter);

        return v;
    }
}
