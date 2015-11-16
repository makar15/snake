package com.example.makarov.snakegame.window;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.makarov.snakegame.R;
import com.example.makarov.snakegame.SnakePreferences;
import com.example.makarov.snakegame.db.Level;
import com.example.makarov.snakegame.singleton.DataBase;
import com.example.makarov.snakegame.window.adapters.LevelsAdapter;

/**
 *
 */
public class ListLevelsFragment extends Fragment {

    private ListView lvLevels;

    /**
     * При создании фрагмента, создается список из рекордов с помощью адаптера
     * LevelsAdapter и формирует список нужным образом
     */
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_levels_fragment, null);

        lvLevels = (ListView) v.findViewById(R.id.lvLevels);

        final LevelsAdapter levelsAdapter = new LevelsAdapter(getActivity(),
                DataBase.getInstance().getLevels());
        lvLevels.setAdapter(levelsAdapter);

        /**
         *
         */
        lvLevels.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                SnakePreferences.getInstance().changedLastLevel((int) id);

                Intent intent = new Intent();
                intent.putExtra(Level.NAME_ID, (int) id);
                intent.setClass(getActivity(), StartGameActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }
}
