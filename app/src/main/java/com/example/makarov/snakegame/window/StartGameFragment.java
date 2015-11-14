package com.example.makarov.snakegame.window;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.makarov.snakegame.CreateDialog;
import com.example.makarov.snakegame.GameSnakeSurfaceView;
import com.example.makarov.snakegame.window.dialog.DialogIssueRepeatGame;

/**
 *
 */
public class StartGameFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        int levelId = 0;
        Bundle bundle = getArguments();
        if(bundle != null) {
            levelId = bundle.getInt(DialogIssueRepeatGame.NAME_ID);
        }

         /*
         Создаем объект, умеющий запускать диалоговые окна
        Запускаем класс игры
         */
        CreateDialog dialog = new CreateDialog(getActivity().getFragmentManager());
        View v = new GameSnakeSurfaceView(getActivity(), dialog, levelId);

        return v;
    }
}
