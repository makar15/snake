package com.example.makarov.snakegame;

import android.app.DialogFragment;
import android.app.FragmentManager;

/**
 * Класс умеющий запускать диалоговые окна
 */
public class CreateDialog {

    private final String TAG_DIALOG = "dlg";
    private FragmentManager fm;

    /**
     * В конструктор фрагмент менеджер, который и нужен для запуска окна
     */
    public CreateDialog(FragmentManager fragmentManager){
        fm = fragmentManager;
    }

    /**
     * Метод запускает нужное окно
     */
    public void createDialog(DialogFragment dialog){
        dialog.show(fm, TAG_DIALOG);
    }
}
