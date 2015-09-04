package com.example.ahmed.calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;


public class List_View extends ActionBarActivity implements AdapterView.OnItemClickListener {

    ArrayList<String> listAL, listAl1;
    android.widget.ListView l, l1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__view);

        //Init.. ArrayList
        listAL = new ArrayList<String>();

        //Add items to arrayList
        listAL.add("Ahmed");
        listAL.add("mohA");
        listAL.add("hema");
        listAL.add("ali");
        listAL.add("Ahmed");
        listAL.add("mohA");
        listAL.add("hema");
        listAL.add("ali");
        listAL.add("Ahmed");
        listAL.add("mohA");
        listAL.add("Ahmed");
        listAL.add("mohA");

        //Init.. ArrayList
        listAl1 = new ArrayList<String>();

        listAl1.add("1");
        listAl1.add("2");
        listAl1.add("3");
        listAl1.add("4");
        listAl1.add("5");
        listAl1.add("6");


        l = (android.widget.ListView) findViewById(R.id.SecondPage_MyList_ListView);

        l1 = (android.widget.ListView) findViewById(R.id.listView);
        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Forth - the ArrayList of data

        //first list
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listAL);

        // Assign adapter to
        l.setAdapter(adapter);

        l.setOnItemClickListener(this);


        //Second List
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listAl1);

        //assign adapter to listview
        l1.setAdapter(adapter1);

        l1.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        //parent parameter is responsible for change object .."list1,list2,list3 ..and in snpinner too

        if (parent == l) {
            for (int i = 0; i < listAL.size(); ) {
                String retVal = listAL.get(position);
                Toast.makeText(this, retVal, Toast.LENGTH_SHORT).show();
                break;
            }
        } else if (parent == l1)
            for (int i = 0; i < listAl1.size(); ) {
                String retVal = listAl1.get(position);
                Toast.makeText(this, retVal, Toast.LENGTH_SHORT).show();
                break;
            }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list__view, menu);
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

