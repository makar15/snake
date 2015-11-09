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

    private TextView tv;
    private Animation anim = null;

    /**
     * При запуске фрагмента:
     * говорим на каком layout находимся
     * С анимацией запускаем тексовое поле фрагмента
     * До того, пока анимация не завершится, кнопки делаем прозрачными
     */
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.menu_game_fragment, null);

        final Button startButton = (Button)v.findViewById(R.id.button1);
        startButton.setOnClickListener(this);

        final Button scoreButton = (Button)v.findViewById(R.id.button2);
        scoreButton.setOnClickListener(this);

        final Button levelsButton = (Button)v.findViewById(R.id.button3);
        levelsButton.setOnClickListener(this);

        final Button exitButton = (Button)v.findViewById(R.id.button4);
        exitButton.setOnClickListener(this);

        /*
        Все кнопки прозрачные изначально
         */
        startButton.setVisibility(View.INVISIBLE);
        scoreButton.setVisibility(View.INVISIBLE);
        levelsButton.setVisibility(View.INVISIBLE);
        exitButton.setVisibility(View.INVISIBLE);

        tv = (TextView)v.findViewById(R.id.textView1);
        registerForContextMenu(tv);

        anim = AnimationUtils.loadAnimation(getActivity(), R.anim.myalpha);

        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            /*
            Со всех кнопок снимаем прозрачность, при завершении анимации
             */
            @Override
            public void onAnimationEnd(Animation animation) {
                startButton.setVisibility(View.VISIBLE);
                scoreButton.setVisibility(View.VISIBLE);
                levelsButton.setVisibility(View.VISIBLE);
                exitButton.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        tv.startAnimation(anim);

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
