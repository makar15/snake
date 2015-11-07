package com.example.makarov.snakegame.window;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.makarov.snakegame.R;

/**
 *
 */
public class GameMenuFragment extends Fragment implements View.OnClickListener{

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.menu_game_fragment, null);

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
            //выход
            case R.id.button4: {
                getActivity().finish();
            }break;

            default:
                break;
        }
    }
}
