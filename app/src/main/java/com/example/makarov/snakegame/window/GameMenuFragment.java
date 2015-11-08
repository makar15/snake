package com.example.makarov.snakegame.window;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.example.makarov.snakegame.R;

/**
 * Фрагмент меню игры,
 * находится на главном активити приложения
 */
public class GameMenuFragment extends Fragment implements View.OnClickListener{

    TextView tv;
    Animation anim = null;

    /**
     * При запуске фрагмента:
     * говорим на каком layout находимся
     * С анимацией запускаем тексовое поле фрагмента
     * Создаем кнопки менюшки игры
     */
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.menu_game_fragment, null);

        tv = (TextView)v.findViewById(R.id.textView1);
        registerForContextMenu(tv);
        anim = AnimationUtils.loadAnimation(getActivity(), R.anim.myalpha);
        tv.startAnimation(anim);

        Button startButton = (Button)v.findViewById(R.id.button1);
        startButton.setOnClickListener(this);

        Button scoreButton = (Button)v.findViewById(R.id.button2);
        scoreButton.setOnClickListener(this);

        Button levelsButton = (Button)v.findViewById(R.id.button3);
        levelsButton.setOnClickListener(this);

        Button exitButton = (Button)v.findViewById(R.id.button4);
        exitButton.setOnClickListener(this);

        return v;
    }

    /**
     * При нажатии на кнопки, запускаем различные фрагменты
     * В случае старта, запускаем второе активити с самой игрой!
     * В случае уровней, будет запускаться фрагмент ListView с созданными уровнями
     * В случае с рекордами, запускаем фрагмент с ListView с рекордами игры
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.button1: {
                Intent intent = new Intent();
                intent.setClass(getActivity(), StartGameActivity.class);
                startActivity(intent);
            }break;

            case R.id.button2: {

            }break;

            case R.id.button3: {

            }break;

            case R.id.button4: {
                getActivity().finish();
            }break;

            default:
                break;
        }
    }
}
