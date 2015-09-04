package com.example.ahmed.calculator;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telecom.TelecomManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }



    @Override
    public void onReceive(Context context, Intent intent)
    {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        if(intent.getExtras() != null){
            String state=intent.getStringExtra(TelephonyManager.EXTRA_STATE);

            if(state.equals(TelephonyManager.EXTRA_STATE_RINGING))
            {
                String phoneNumber=intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
                //Toast.makeText(context,phoneNumber,Toast.LENGTH_LONG).show();
                Log.d("Phone Number",phoneNumber);
            }
        }
    }
    }

