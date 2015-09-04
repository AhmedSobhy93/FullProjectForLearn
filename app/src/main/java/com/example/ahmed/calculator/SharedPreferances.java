package com.example.ahmed.calculator;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;


public class SharedPreferances extends ActionBarActivity implements View.OnClickListener{

    EditText inputEdt;
    Button addBtn,showBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferances);

        inputEdt=(EditText)findViewById(R.id.editText);
        addBtn=(Button)findViewById(R.id.SharedPref_Add_Button);
        showBtn=(Button)findViewById(R.id.SharedPref_Show_Button);

        addBtn.setOnClickListener(this);
        showBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){

        //add value to shared Preference
        if(v==addBtn){
         //  SharedPreferences sp= PreferenceManager.getDefaultSharedPreferences(this);
        //   sp.edit().putString("Key",inputEdt.getText().toString()).commit();

            android.content.SharedPreferences sp1=  PreferenceManager.getDefaultSharedPreferences(this);
            sp1.edit().putFloat("Key1",22).commit();

        }
        //show value to shared Preference
        else if(v==showBtn){
            SharedPreferences sp=PreferenceManager.getDefaultSharedPreferences(this);
            String message=sp.getString("Key","");
           // Toast.makeText(this,message,Toast.LENGTH_SHORT).show();

            Float msg=sp.getFloat("Key1",23f);
            String msgStr=String.valueOf(msg);
            Toast.makeText(this,msgStr,Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_shared_preferances, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
