package com.example.makarov.snakegame;

import android.app.DialogFragment;
import android.app.FragmentManager;

/**
 *
 */
public class CreateDialog {

    private FragmentManager fm;

    /**
     *
     */
    public CreateDialog(FragmentManager fragmentManager){
        fm = fragmentManager;
    }

    /**
     *
     */
    public void createDialog(DialogFragment dialog){
        dialog.show(fm, "dlg1");
    }
}
