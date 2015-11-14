package com.example.makarov.snakegame.window;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.example.makarov.snakegame.R;
import com.example.makarov.snakegame.singleton.DataBase;
import com.example.makarov.snakegame.window.adapters.RecordAdapter;

/**
 * Класс фрагмента со всеми рекордами из базы данных
 */
public class ListRecordFragment extends Fragment {

    private ListView lvRecord;

    /**
     * При создании фрагмента, создается список из рекордов с помощью адаптера
     * RecordAdapter и формирует список нужным образом
     */
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_record_fragment, null);

        lvRecord = (ListView) v.findViewById(R.id.lvRecord);

        RecordAdapter recordAdapter = new RecordAdapter(getActivity(),
                DataBase.getInstance().getRecords());
        lvRecord.setAdapter(recordAdapter);

        return v;
    }
}
