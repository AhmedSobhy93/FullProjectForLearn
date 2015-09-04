package com.example.ahmed.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class ShowEmployee extends Activity {

    ListView showEmpsNamesLV,showEmpsJobsLV;
    DatabaseHandler myHandler;
    ArrayList<Employee> empDataList;

    ArrayList<String> empNames,empJobs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_employee);

        showEmpsNamesLV=(ListView)findViewById(R.id.ShowEmployee_Names_ViewList);
        showEmpsJobsLV=(ListView)findViewById(R.id.ShowEmp_Jobs_ListView);

        myHandler=new DatabaseHandler(this);
        empDataList=myHandler.getEmployeeInfo();




        empNames=new ArrayList<String>();
        empJobs=new ArrayList<String>();

        for(int i=0;i<empDataList.size();i++){
            String name=empDataList.get(i).getName();
            empNames.add(name);

            String jobs=empDataList.get(i).getJob();
            empJobs.add(jobs);
        }



        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,empNames);
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,empJobs);


        //assign adapter to listview
        showEmpsNamesLV.setAdapter(adapter);
        showEmpsJobsLV.setAdapter(adapter1);
    }

}
