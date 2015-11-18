package com.example.makarov.snakegame.window.dialog;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import com.example.makarov.snakegame.CreateDialog;
import com.example.makarov.snakegame.MyApp;
import com.example.makarov.snakegame.Record;
import com.example.makarov.snakegame.R;
import com.example.makarov.snakegame.db.Level;
import com.example.makarov.snakegame.window.StartGameActivity;

/**
 * Класс Диалога
 * Запускается при проигрыше в игре
 */
public class DialogSaveRecord extends DialogFragment implements OnClickListener {

    private final DialogFragment dialogIssueRepeatGame;
    private final CreateDialog mCreateDialog;
    private EditText nameUser;
    private Record myCreateRecord;

    /**
     * В конструктор: объект рекорда в игре, объект для создания диалоговых окон.
     * Инициализируем объект диалогового окна, с вопросом: повторить игру?
     */
    public DialogSaveRecord(Record createRecord, CreateDialog createDialog){
        mCreateDialog = createDialog;
        myCreateRecord = createRecord;
        dialogIssueRepeatGame = new DialogIssueRepeatGame();
    }

    /**
     * при запуске окна
     */
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().setTitle("Save results ?");
        View v = inflater.inflate(R.layout.dialog_save_record, null);

        nameUser = (EditText) v.findViewById(R.id.textViewName);

        v.findViewById(R.id.btnSave).setOnClickListener(this);
        v.findViewById(R.id.btnExit).setOnClickListener(this);
        v.findViewById(R.id.btnRepeat).setOnClickListener(this);

        this.setCancelable(false);
        return v;
    }

    /**
     * При клике на кнопку
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /*
            При нажатии на сохранение :
            1)просим ввести Имя пользователя
            2)сохраняем в БД
            5)вызываем диалоговое окно, с вопросом: повторить игру?
             */
            case R.id.btnSave: {
                if (!TextUtils.isEmpty(nameUser.getText().toString())) {
                    myCreateRecord.setName(nameUser.getText().toString());
                    MyApp.getApp().getDataBase().saveRecord(myCreateRecord);

                    mCreateDialog.createDialog(dialogIssueRepeatGame);
                    dismiss();
                }
            }break;

            case R.id.btnExit: {
                getActivity().finish();
            }break;

            case R.id.btnRepeat: {
                /*
                очисти поле
                задавай новый уровень
                потоки запусти
                 */
                getActivity().finish();

                int levelId = MyApp.getApp().getSnakePreferences().getLastLevel();

                Intent intent = new Intent();
                intent.putExtra(Level.ID_LEVEL, levelId);
                intent.setClass(getActivity(), StartGameActivity.class);
                startActivity(intent);
            }break;

            default:
                break;
        }
        //dismiss();
    }

    /**
     * срабатывает, когда диалог закрывается
     */
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
    }

    /**
     * срабатывает, когда диалог отменяют кнопкой Назад
     */
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
    }

}
