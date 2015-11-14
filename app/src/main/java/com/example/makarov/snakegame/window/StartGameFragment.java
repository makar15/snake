package com.example.makarov.snakegame.window;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.makarov.snakegame.CreateDialog;
import com.example.makarov.snakegame.GameSnakeSurfaceView;

/**
 *
 */
public class StartGameFragment extends Fragment {

    private String lineModelLevel;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        /*

         */
        Bundle bundle = getActivity().getIntent().getExtras();
        if(bundle != null){
            lineModelLevel = bundle.getString("press position level");
        }

         /*
         Создаем объект, умеющий запускать диалоговые окна
        Запускаем класс игры
         */
        CreateDialog dialog = new CreateDialog(getActivity().getFragmentManager());
        View v = new GameSnakeSurfaceView(getActivity(), dialog, lineModelLevel);

        return v;
    }
}
