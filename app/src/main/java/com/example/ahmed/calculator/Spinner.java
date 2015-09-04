package com.example.ahmed.calculator;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import java.util.ArrayList;

public class Spinner extends Activity implements OnItemSelectedListener{

     android.widget.Spinner genderSpnr;
     ArrayList<String> listAL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        //Init.. ArrayList
        listAL=new ArrayList<String>();

        //Add items to arrayList
        listAL.add("");
        listAL.add("Male");
        listAL.add("Female");


        genderSpnr = (android.widget.Spinner)findViewById(R.id.Spinner_gender_Spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,listAL );
        genderSpnr.setAdapter(adapter);

        genderSpnr.setOnItemSelectedListener(this);

    }




    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String retVal=listAL.get(position);
        Toast.makeText(this,retVal,Toast.LENGTH_LONG).show();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
