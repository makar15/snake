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

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         /*
         Создаем объект, умеющий запускать диалоговые окна
        Запускаем класс игры
        в котором инициализируется выбранный уровень, а далее уже объекты,
         View и др. компоненты уровня и игры
         */
        CreateDialog dialog = new CreateDialog(getActivity().getFragmentManager());
        View v = new GameSnakeSurfaceView(getActivity(), dialog);

        return v;
    }
}
