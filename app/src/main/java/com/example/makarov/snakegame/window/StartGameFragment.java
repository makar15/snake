package com.example.makarov.snakegame.window;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.makarov.snakegame.CreateDialog;
import com.example.makarov.snakegame.GameSnakeSurfaceView;
import io.realm.Realm;

/**
 *
 */
public class StartGameFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         /*
         Вызываем DataBaseScore в которую будем записывать рекорды игры
         Создаем объект, умеющий запускать диалоговые окна
        Запускаем класс игры
        в котором инициализируется выбранный уровень, а далее уже объекты,
         View и др. компоненты уровня и игры
         */
        Realm realmDBScore = Realm.getInstance(getContext());
        CreateDialog dialog = new CreateDialog(getActivity().getFragmentManager());
        View v = new GameSnakeSurfaceView(getActivity(), dialog, realmDBScore);

        return v;
    }
}
