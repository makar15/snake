package com.example.makarov.snakegame.window;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.makarov.snakegame.CreateDialog;
import com.example.makarov.snakegame.GameSnakeSurfaceView;
import com.example.makarov.snakegame.MyApp;
import com.example.makarov.snakegame.db.Level;

/**
 *
 */
public class StartGameFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*

         */
        int idLevel = MyApp.getApp().getDataBase().getLevel(Level.NAME_FIRST_LEVEL).getId();

        Bundle bundle = getArguments();
        if(bundle != null) {
            idLevel = bundle.getInt(Level.ID_LEVEL);
        }

         /*
         Создаем объект, умеющий запускать диалоговые окна
        Запускаем класс игры
         */
        CreateDialog dialog = new CreateDialog(getActivity().getFragmentManager());
        View v = new GameSnakeSurfaceView(getActivity(), dialog, idLevel);

        return v;
    }
}
