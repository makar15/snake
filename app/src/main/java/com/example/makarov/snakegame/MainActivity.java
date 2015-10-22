package com.example.makarov.snakegame;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));
    }

    class DrawView extends SurfaceView implements SurfaceHolder.Callback {

        private MySurfaceThread drawThread;
        private Paint paint;
        private Bitmap mTestObjectField, mField;

        public DrawView(Context context) {
            super(context);
            paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            getHolder().addCallback(this);

            mField = BitmapFactory.decodeResource(context.getResources(),
                    R.drawable.field);
            mTestObjectField = BitmapFactory.decodeResource(context.getResources(),
                    R.drawable.objectfield);
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width,
                                   int height) {

        }

        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            drawThread = new MySurfaceThread(getHolder());
            drawThread.setRunning(true);
            drawThread.start();
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            boolean retry = true;
            drawThread.setRunning(false);
            while (retry) {
                try {
                    drawThread.join();
                    retry = false;
                } catch (InterruptedException e) {
                }
            }
        }


        public class MySurfaceThread extends Thread {

            private SurfaceHolder myThreadSurfaceHolder;
            private boolean myThreadRun = false;

            public MySurfaceThread(SurfaceHolder holder) {
                myThreadSurfaceHolder = holder;
            }

            public void setRunning(boolean b) {
                myThreadRun = b;
            }

            @Override
            public void run() {
                Canvas canvas;
                while (myThreadRun) {
                    canvas = null;
                    try {
                        canvas = myThreadSurfaceHolder.lockCanvas(null);
                        synchronized (myThreadSurfaceHolder) {
                            canvas.drawBitmap(mField, 50, 50, paint);
                            canvas.drawBitmap(mTestObjectField, 450, 950, paint);
                        }
                    } finally {
                        if (canvas != null) {
                            myThreadSurfaceHolder.unlockCanvasAndPost(canvas);
                        }
                    }
                }
            }
        }
    }

}
