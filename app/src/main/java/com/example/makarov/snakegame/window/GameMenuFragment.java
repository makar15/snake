package com.example.makarov.snakegame.window;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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

        final Button startButton = (Button)v.findViewById(R.id.buttonStart);
        startButton.setOnClickListener(this);

        final Button startDuelButton = (Button)v.findViewById(R.id.buttonDuel);
        startButton.setOnClickListener(this);

        final Button scoreButton = (Button)v.findViewById(R.id.buttonScore);
        scoreButton.setOnClickListener(this);

        final Button levelsButton = (Button)v.findViewById(R.id.buttonLevels);
        levelsButton.setOnClickListener(this);

        final Button exitButton = (Button)v.findViewById(R.id.buttonExit);
        exitButton.setOnClickListener(this);

        /*
        Все кнопки прозрачные изначально
         */
        startButton.setVisibility(View.INVISIBLE);
        startDuelButton.setVisibility(View.INVISIBLE);
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
                startDuelButton.setVisibility(View.VISIBLE);
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
     * В случае Duel,
     * В случае уровней, будет запускаться фрагмент с созданными уровнями
     * В случае с рекордами, запускаем фрагмент с хранящимися в базе данных рекордами игры
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.buttonStart: {
                Intent intent = new Intent();
                intent.setClass(getActivity(), StartGameActivity.class);
                startActivity(intent);
            }break;

            case R.id.buttonDuel: {

            }break;

            case R.id.buttonScore: {
                openFragment(new ListRecordFragment());

            }break;

            case R.id.buttonLevels: {
                openFragment(new ListLevelsFragment());

            }break;

            case R.id.buttonExit: {
                getActivity().finish();
            }break;

            default:
                break;
        }
    }

    public void openFragment(Fragment fragment){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.LayoutMenu, fragment).addToBackStack(null).commit();
    }
}
