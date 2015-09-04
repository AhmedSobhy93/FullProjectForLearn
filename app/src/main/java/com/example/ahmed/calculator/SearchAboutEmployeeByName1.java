package com.example.ahmed.calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Button;

import java.util.ArrayList;

public class SearchAboutEmployeeByName1 extends ActionBarActivity implements View.OnClickListener{

    DatabaseHandler myHandler;
    ListView empListV;
    Button searchBtn;
    EditText nameEdt;

    ArrayList<Employee> empDataList;
    ArrayList<String> empNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_about_employee_by_name1);

        nameEdt=(EditText)findViewById(R.id.SearchEmpName_Search_TextField);
        String name=nameEdt.getText().toString();

        myHandler=new DatabaseHandler(this);
        empDataList=myHandler.getEmployeeByName1(name);

        empListV=(ListView)findViewById(R.id.SearchEmpName_Search_ListView);
        searchBtn=(Button)findViewById(R.id.SearchEmpName_Search_Button);

        searchBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v==searchBtn){

            for(int i=0;i<empDataList.size();i++){
               String name1=empDataList.get(i).getName();
                empNames.add(name1);
            }

            ArrayAdapter<String> adapter=new ArrayAdapter<String>(SearchAboutEmployeeByName1.this,android.R.layout.simple_list_item_1,empNames);

            empListV.setAdapter(adapter);
        }
    }
}
