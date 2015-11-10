package com.example.makarov.snakegame.window;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.example.makarov.snakegame.R;

/**
 *
 */
public class DialogSaveRecord extends DialogFragment implements OnClickListener {

    private final int DIALOG = 1;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().setTitle("Save results!");
        View v = inflater.inflate(R.layout.dialog_save_record, null);

        v.findViewById(R.id.btnSave).setOnClickListener(this);
        v.findViewById(R.id.btnExit).setOnClickListener(this);
        v.findViewById(R.id.btnRepeat).setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        dismiss();
    }

    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
    }

    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
    }

}
