package com.example.makarov.snakegame.window;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.makarov.snakegame.R;
import com.example.makarov.snakegame.singleton.DataBase;
import com.example.makarov.snakegame.window.adapters.LevelsAdapter;

/**
 *
 */
public class ListLevelsFragment extends Fragment {

    private ListView lvLevels;
    private int itemPressIdLevel;
    private String lineModelLevel;
    private SharedPreferences prefs;

    /**
     * При создании фрагмента, создается список из рекордов с помощью адаптера
     * LevelsAdapter и формирует список нужным образом
     */
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_levels_fragment, null);

        lvLevels = (ListView) v.findViewById(R.id.lvLevels);

        final LevelsAdapter levelsAdapter = new LevelsAdapter(getActivity(),
                DataBase.getInstance().getAllLevels());
        lvLevels.setAdapter(levelsAdapter);

        prefs = getActivity().getSharedPreferences("com.example.makarov.myAppName", 0);

        /**
         *
         */
        lvLevels.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                itemPressIdLevel = (int) levelsAdapter.getItemId(position);
                lineModelLevel = DataBase.getInstance().getAllLevels().
                        get(itemPressIdLevel).getModelLevel();

                prefs.edit().putInt("firstRuApp", itemPressIdLevel).apply();

                Bundle bundle = new Bundle();
                bundle.putString("press position level", lineModelLevel);

                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent.setClass(getActivity(), StartGameActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }
}
