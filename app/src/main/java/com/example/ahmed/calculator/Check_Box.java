package com.example.ahmed.calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;


public class Check_Box extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check__box);
    }


    public void onCheckboxClicked(View v){
        // Is the view now checked?
        boolean checked=((CheckBox)v).isChecked();

        // Check which checkbox was clicked
        switch(v.getId()){
            case R.id.CheckBox_Android_CheckBox:
                if(checked){
                    Toast.makeText(this,"Android",Toast.LENGTH_SHORT).show();
                }else if(!checked){
                Toast.makeText(this,"NOt_Android",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.CheckBox_Windows_Checkbox:
                if(checked){
                    Toast.makeText(this,"Windows",Toast.LENGTH_SHORT).show();
                }
                else if(!checked){
                Toast.makeText(this,"NOt_Windows",Toast.LENGTH_SHORT).show();
            }
                break;
            case R.id.CheckBox_BlackBery_Checkbox:
                if(checked){
                    Toast.makeText(this,"BlackBery",Toast.LENGTH_SHORT).show();
                }else if(!checked){
                Toast.makeText(this,"NOt_BlackBery",Toast.LENGTH_SHORT).show();
            }
                break;
            case R.id.CheckBox_IOS_Checkbox:
                if(checked){
                    Toast.makeText(this,"IOS",Toast.LENGTH_SHORT).show();
                }else if(!checked){
                Toast.makeText(this,"NOt_IOS",Toast.LENGTH_SHORT).show();
            }
                break;
        }
    }

}
