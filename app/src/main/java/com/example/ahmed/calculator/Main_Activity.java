package com.example.ahmed.calculator;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main_Activity extends Activity implements View.OnClickListener,OnTaskCompleted{

    MyTask ms;

    Button Calculator, MenuBtn, genderBtn, sharePrefBtn, listViewBtn, radioBtn, checkBtn, ratingBarBtn,
            progressBarBtn, autoComTxtButton, notifyBtn, camerBtn, mapsBtn, addEmpBtn, showEmpBtn, playAudioBtn, maps1Btn, searchName1Btn, searchName2Btn;

    GPSTracker myTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Enter Calculator activity
        Calculator = (Button) findViewById(R.id.secondPage_Calculator_button);
        Calculator.setOnClickListener(this);

        //menus
        MenuBtn = (Button) findViewById(R.id.ListView_Menus_Button);
        MenuBtn.setOnClickListener(this);

        //Gender Spinner
        genderBtn = (Button) findViewById(R.id.ListView_Gender_Button);
        genderBtn.setOnClickListener(this);

        //Shared pref..
        sharePrefBtn = (Button) findViewById(R.id.Main_SharedPref_Button);
        sharePrefBtn.setOnClickListener(this);

        listViewBtn = (Button) findViewById(R.id.Main_ListView_Button);
        listViewBtn.setOnClickListener(this);

        radioBtn = (Button) findViewById(R.id.Main_RadioBtn_Button);
        radioBtn.setOnClickListener(this);

        checkBtn = (Button) findViewById(R.id.Main_CheckBox_Button);
        checkBtn.setOnClickListener(this);

        ratingBarBtn = (Button) findViewById(R.id.Main_RatingBar_Button);
        ratingBarBtn.setOnClickListener(this);

        progressBarBtn = (Button) findViewById(R.id.Main_ProgressBar_Button);
        progressBarBtn.setOnClickListener(this);

        autoComTxtButton = (Button) findViewById(R.id.Main_AutoCompText_Button);
        autoComTxtButton.setOnClickListener(this);

        notifyBtn = (Button) findViewById(R.id.Main_Notification_Button);
        notifyBtn.setOnClickListener(this);

        camerBtn = (Button) findViewById(R.id.Main_Camera_Button);
        camerBtn.setOnClickListener(this);

        mapsBtn = (Button) findViewById(R.id.Main_Maps_Button);
        mapsBtn.setOnClickListener(this);

        addEmpBtn = (Button) findViewById(R.id.MainActivity_AddEmployee_Button);
        addEmpBtn.setOnClickListener(this);

        showEmpBtn = (Button) findViewById(R.id.MainActivity_ShowEmp_Button);
        showEmpBtn.setOnClickListener(this);

        playAudioBtn = (Button) findViewById(R.id.Main_Audio_Button);
        playAudioBtn.setOnClickListener(this);

        maps1Btn = (Button) findViewById(R.id.Main_Maps1_Button);
        maps1Btn.setOnClickListener(this);

        searchName1Btn = (Button) findViewById(R.id.Main_SearchName1_Button);
        searchName1Btn.setOnClickListener(this);

        searchName2Btn = (Button) findViewById(R.id.Main_SearchName2_Button);
        searchName2Btn.setOnClickListener(this);

        myTracker = new GPSTracker(this);
    }


    @Override
    public void onClick(View v) {
        if (v == Calculator) {

            ProgressDialog ps = new ProgressDialog(this);
            OnTaskCompleted os = null;
            ms = new MyTask(ps,this);

            ms.execute("" , "" , "" , "" , "");

//            Intent i = new Intent(Main_Activity.this, com.example.ahmed.calculator.Calculator.class);
//            i.putExtra("k1", "Calculator");
//            startActivity(i);
        } else if (v == MenuBtn) {
            Intent i1 = new Intent(Main_Activity.this, Menus.class);
            i1.putExtra("k1", "Menu");
            startActivity(i1);
        } else if (v == genderBtn) {
            Intent i = new Intent(Main_Activity.this, Spinner.class);
            startActivity(i);
        } else if (v == sharePrefBtn) {
            Intent i = new Intent(Main_Activity.this, SharedPreferances.class);
            startActivity(i);
        } else if (v == listViewBtn) {
            Intent i = new Intent(Main_Activity.this, List_View.class);
            startActivity(i);
        } else if (v == radioBtn) {
            Intent i = new Intent(Main_Activity.this, Radio_Button.class);
            startActivity(i);
        } else if (v == checkBtn) {
            Intent i = new Intent(Main_Activity.this, Check_Box.class);
            startActivity(i);
        } else if (v == ratingBarBtn) {
            Intent i = new Intent(Main_Activity.this, Rating_Bar.class);
            startActivity(i);
        } else if (v == progressBarBtn) {
            Intent i = new Intent(Main_Activity.this, Progress_Bar.class);
            startActivity(i);
        } else if (v == autoComTxtButton) {
            Intent i = new Intent(Main_Activity.this, AutoComplete_Text.class);
            startActivity(i);
        } else if (v == notifyBtn) {
            Intent i = new Intent(Main_Activity.this, Notification.class);
            startActivity(i);
        } else if (v == camerBtn) {
            Intent i = new Intent(Main_Activity.this, CameraPage.class);
            startActivity(i);
        } else if (v == mapsBtn) {
            Intent i = new Intent(Main_Activity.this, MapsActivity.class);

            //double lat = myTracker.getLatitude();
            double lat = 33;
            String latStr = String.valueOf(lat);
            i.putExtra("lat", latStr);

            //double lng = myTracker.getLongitude();
            double lng = 30;
            String lngStr = String.valueOf(lng);
            i.putExtra("lng", lngStr);

            startActivity(i);
        } else if (v == addEmpBtn) {
            Intent i = new Intent(Main_Activity.this, AddEmployee.class);
            startActivity(i);
        } else if (v == showEmpBtn) {
            Intent i = new Intent(Main_Activity.this, ShowEmployee.class);
            startActivity(i);
        } else if (v == playAudioBtn) {
            Intent i = new Intent(Main_Activity.this, Audio.class);
            startActivity(i);
        } else if (v == maps1Btn) {
            Intent i = new Intent(Main_Activity.this, MapsActivity1.class);
            startActivity(i);

        } else if (v == searchName1Btn) {
            Intent i = new Intent(Main_Activity.this, SearchAboutEmployeeByName1.class);
            startActivity(i);
        } else if (v == searchName2Btn) {
            Intent i = new Intent(Main_Activity.this, SearchAboutEmployeeByName2.class);
            startActivity(i);
        }

    }

    @Override
    public void onTaskCompleted() {

        try {
            String result = ms.get();
            Toast.makeText(this, result, Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {

        }
    }
}
