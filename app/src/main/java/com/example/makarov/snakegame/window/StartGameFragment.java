package com.example.makarov.snakegame.window;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.makarov.snakegame.initialized.GameSnakeSurfaceView;

/**
 *
 */
public class StartGameFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         /*
        Запускаем класс игры
        в котором инициализируется выбранный уровень, а далее уже объекты,
         View и др. компоненты уровня и игры
         */
        View v = new GameSnakeSurfaceView(getActivity(), getActivity().getFragmentManager());

        return v;
    }
}
