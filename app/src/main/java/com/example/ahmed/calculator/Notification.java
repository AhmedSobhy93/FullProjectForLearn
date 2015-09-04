package com.example.ahmed.calculator;

import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Notification extends ActionBarActivity implements View.OnClickListener
{

    Button notifyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        notifyBtn = (Button) findViewById(R.id.Notification_Notify_Button);
        notifyBtn.setOnClickListener(this);
    }

    public void creatNotification()
    {
//        NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(this)
//                .setSmallIcon(R.mipmap.ic_launcher)
//                .setContentTitle("Title")
//                .setContentText("New Message");
//
//        nBuilder.setVibrate(new long[]{1000, 5000, 1000, 5000});
//
//        NotificationManager nNotificationManager = (NotificationManager) getSystemService(this.NOTIFICATION_SERVICE);
//
//        nNotificationManager.notify(1, nBuilder.build());


        /////////////////////////
        NotificationCompat.Builder nBuilder1=new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Title of Notification")
                .setColor(234)
                .setContentInfo("Welcome to Egy")
                .setContentText("New Message")
                .setVibrate(new long[]{1000,2000,3000,4000});

        NotificationManager notificationManager= (NotificationManager) getSystemService(this.NOTIFICATION_SERVICE);

        notificationManager.notify(1,nBuilder1.build());


    }

    @Override
    public void onClick(View v)
    {

        if (v == notifyBtn) {
            creatNotification();
        }
    }
}
