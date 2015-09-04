package com.example.ahmed.calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;


public class Radio_Button extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio__button);
    }

    public void onRadioButtonClicked(View v){
        boolean checked=((RadioButton)v).isChecked();

        switch(v.getId()){
            case R.id.RadioBtn_Male_RadioBtn:
                if(checked){
                    Toast.makeText(this,"Male",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.RadioBtn_Female_RadioBtn:
                if(checked){
                    Toast.makeText(this,"Female",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_radio__button, menu);
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
