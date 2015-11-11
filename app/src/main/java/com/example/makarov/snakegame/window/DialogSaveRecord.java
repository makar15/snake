package com.example.makarov.snakegame.window;

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
import com.example.makarov.snakegame.CreateRecord;
import com.example.makarov.snakegame.R;
import com.example.makarov.snakegame.db.Record;
import io.realm.Realm;

/**
 * Класс Диалога
 * Запускается при проигрыше в игре
 */
public class DialogSaveRecord extends DialogFragment implements OnClickListener {

    private EditText nameUser;
    private CreateDialog mCreateDialog;
    private CreateRecord myCreateRecord;
    private Realm mRealm;
    private DialogFragment dialogIssueRepeatGame;

    /**
     * В конструктор: объект рекорда в игре, БД хранящая все созданные рекорды,
     *   объект для создания диалоговых окон.
     * Инициализируем объект диалогового окна, с вопросом: повторить игру?
     */
    public DialogSaveRecord(CreateRecord createRecord, Realm realm, CreateDialog createDialog){
        mCreateDialog = createDialog;
        mRealm = realm;
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

        /*
        В текст записывается имя пользователя, для сохранения рекорда
         */
        nameUser = (EditText) v.findViewById(R.id.textViewName);

        v.findViewById(R.id.btnSave).setOnClickListener(this);
        v.findViewById(R.id.btnExit).setOnClickListener(this);
        v.findViewById(R.id.btnRepeat).setOnClickListener(this);

        /*
        окно нельзя закрыть по кнопке BACK телефона
         */
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
            1)проверяем введено ли Имя пользователя
            2)Включаем БД для записи рекорда
            3)создаем рекорд с введенным именем и набранными очками
            4)коммитим созданный рекорд
            5)вызываем диалоговое окно, с вопросом: повторить игру?
             */
            case R.id.btnSave: {
                /*
                == "Enter your name"
                вот эта проверка не пашет, вылетает приложуха
                 */
                if (TextUtils.isEmpty(nameUser.getText().toString()) ||
                        nameUser.getText().toString() == "Enter your name") {
                    nameUser.setText("Enter your name!");
                } else{
                    mRealm.beginTransaction();
                    Record record = mRealm.createObject(Record.class);
                    record.setName(nameUser.getText().toString());
                    record.setScore(myCreateRecord.getScore());
                    mRealm.commitTransaction();

                    mCreateDialog.createDialog(dialogIssueRepeatGame);
                    dismiss();
                }
            }break;
            /*
            При нажатии на выход :
            1) закрываем текущее активити (откроется главное активити игры с фрагментом меню игры
             */
            case R.id.btnExit: {
                getActivity().finish();
            }break;
            /*
            При нажатии на повторить :
            1)Повторно запускаем активити старта игры
            Вот тут не уверен, стоит ли так делать
             */
            case R.id.btnRepeat: {
                /*
                очисти поле
                задавай новый уровень
                потоки запусти
                 */
                getActivity().finish();
                Intent intent = new Intent();
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
