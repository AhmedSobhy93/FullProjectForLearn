package com.example.ahmed.calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Button;
import android.widget.TextView;


public class SearchAboutEmployeeByName2 extends ActionBarActivity implements View.OnClickListener{


    Button searchBtn;
    EditText nameEdt;
    TextView resultTxtV;
    DatabaseHandler myHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_about_employee_by_name2);

        myHandler=new DatabaseHandler(this);

        nameEdt=(EditText)findViewById(R.id.SearchEmpName_Search_TextField);
        searchBtn=(Button)findViewById(R.id.SearchEmpName_Search_Button);
        resultTxtV=(TextView)findViewById(R.id.SearchEmpName_Result_TextView);

        searchBtn.setOnClickListener(this);



    }


    @Override
    public void onClick(View view){

        String name=nameEdt.getText().toString();

        Employee emp1=myHandler.getEmployeeByName2(name);

        String job=emp1.getJob();
        resultTxtV.setText(job);

    }
}
