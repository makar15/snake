package com.example.makarov.snakegame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceView;

/**
 *
 */
public class GameSurface extends SurfaceView{

    Bitmap mTestObjectField, mField;
    public GameSurface(Context context) {
        super(context);

        mField = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.field);
        mTestObjectField = BitmapFactory.decodeResource(context.getResources(),
                        R.drawable.objectfield);
    }

    public void drawGameProcces(Canvas canvas){

    }
}
