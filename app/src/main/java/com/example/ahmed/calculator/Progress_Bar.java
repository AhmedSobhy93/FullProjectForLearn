package com.example.ahmed.calculator;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;


public class Progress_Bar extends Activity {

    static int progress;
    ProgressBar progBar, progBar1;
    int progStatus = 0;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress__bar);

        progress = 0;
        progBar = (ProgressBar) findViewById(R.id.ProgressBar_first_ProgressBar);
        progBar1 = (ProgressBar) findViewById(R.id.ProgressBar_second_ProgressBar);

        progBar.setMax(200);
        progBar1.setMax(300);

        //do some thing in background
        new Thread(new Runnable() {
            @Override
            public void run() {

                //do some work here
                while (progStatus < 100) {
                    progStatus = doSomeWork();
                }

                //update the progressbar
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        progBar.setProgress(progStatus);

                        progBar1.setProgress(progStatus);
                    }
                });

                //hides the progressbar
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        progBar.setVisibility(View.GONE);

                    }
                });
            }

            public int doSomeWork() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return ++progress;
            }

        }).start();
    }


}
