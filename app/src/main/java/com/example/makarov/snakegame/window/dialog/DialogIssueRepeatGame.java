package com.example.makarov.snakegame.window.dialog;

import android.app.DialogFragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.makarov.snakegame.R;
import com.example.makarov.snakegame.singleton.DataBase;
import com.example.makarov.snakegame.window.StartGameActivity;

/**
 * Класс диалогового окна, сробатывающий после сохранения игры
 */
public class DialogIssueRepeatGame extends DialogFragment implements View.OnClickListener {

    private String lineModelLevel;
    private SharedPreferences prefs;
    private int tempModelLevel;

    /**
     * при запуске окна
     */
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().setTitle("repeat game ?");
        View v = inflater.inflate(R.layout.dialog_issue_repeat_game, null);

        v.findViewById(R.id.btnRepeat).setOnClickListener(this);
        v.findViewById(R.id.btnExit).setOnClickListener(this);

        /*
        окно нельзя закрыть по кнопке BACK телефона
         */
        this.setCancelable(false);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRepeat: {
                /*
                очисти поле
                задавай новый уровень
                потоки запусти
                 */
                getActivity().finish();

                prefs = getActivity().getSharedPreferences("com.example.makarov.myAppName", 0);
                tempModelLevel = prefs.getInt("firstRuApp", 0);

                lineModelLevel = DataBase.getInstance().getAllLevels().
                        get(tempModelLevel).getModelLevel();

                Bundle bundle = new Bundle();
                bundle.putString("press position level", lineModelLevel);

                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent.setClass(getActivity(), StartGameActivity.class);
                startActivity(intent);
            }break;

            case R.id.btnExit: {
                getActivity().finish();
            }break;

            default:
                break;
        }
        dismiss();
    }
}
