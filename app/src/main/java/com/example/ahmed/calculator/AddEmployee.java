package com.example.ahmed.calculator;

import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import java.util.ArrayList;

public class AddEmployee extends ActionBarActivity implements View.OnClickListener {

    EditText nameEdt, jobEdt;
    Button addBtn;
    DatabaseHandler myHandler,myHandler1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        nameEdt = (EditText) findViewById(R.id.AddEmployee_Name_EditText);
        jobEdt = (EditText) findViewById(R.id.AddEmployee_Job_EditText);

        addBtn = (Button) findViewById(R.id.AddEmployee_Add_Button);
        addBtn.setOnClickListener(this);

        myHandler = new DatabaseHandler(this);

        myHandler1 =new DatabaseHandler(this,"Database2",null,1);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_employee, menu);
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


    @Override
    public void onClick(View v) {

        if (v == addBtn) {

            String name = nameEdt.getText().toString();
            String job = jobEdt.getText().toString();

            Employee myEmp = new Employee(name, job);
            myHandler.addEmployee(myEmp);

            Employee myEmp1=new Employee("Ahmed","ENg");
            myHandler1.addEmployee(myEmp1);

        }
    }
}

