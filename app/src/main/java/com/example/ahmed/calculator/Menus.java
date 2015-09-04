package com.example.ahmed.calculator;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;


public class Menus extends ActionBarActivity implements View.OnClickListener {

    Button contextBtn, dialogBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);

        Intent i = getIntent();
        String m = i.getStringExtra("k1");
        Toast.makeText(this, m, Toast.LENGTH_SHORT).show();

        contextBtn = (Button) findViewById(R.id.Menus_Context_Button);
        registerForContextMenu(contextBtn);

        dialogBtn = (Button) findViewById(R.id.Menu_Dialog_Button);
        dialogBtn.setOnClickListener(this);
    }

    //
    @Override
    public void onClick(View v) {

        if (v == dialogBtn) {
            createDialog();
        } else if (v == contextBtn) {

        }
    } 

    //methods for option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menus, menu);
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
        } else if (id == R.id.Menus_Cancel_Menu) {
            Toast.makeText(this, "Canceled", Toast.LENGTH_LONG).show();
        } else if (id == R.id.Menus_Delete_Menu) {
            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.Menus_Save_Menu) {
            Toast.makeText(this, "File Saved", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    //methods for context menu

    //create context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.context_menu, menu);

        //another way to add items
        menu.add("aa");

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    //method to Add action to items
    @Override
    public boolean onContextItemSelected(MenuItem item) {


        String x = item.getTitle().toString();
        if (x.equalsIgnoreCase("cancel")) {
            Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show();
        } else if (x.equalsIgnoreCase("delete")) {
            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
        } else if (x.equalsIgnoreCase("delete")) {
            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
        }

        return super.onContextItemSelected(item);
    }


    //Method to Build Dialog Message
    public void createDialog() {

        //Build alertDialog
        AlertDialog ad = new AlertDialog.Builder(this).create();

        //Setup message,title and icon for alert dialog
        ad.setTitle("LogOut");
        ad.setMessage("Are you sure ?");
        ad.setIcon(R.drawable.abc_btn_check_material);

        //Add buttons to dialogAlert "Max 3 Button2"
        ad.setButton("Leave", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Menus.this, "Good Bye", Toast.LENGTH_SHORT).show();
            }
        });
        ad.setButton2("Stay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Menus.this, "Stay In page", Toast.LENGTH_SHORT).show();
            }
        });
        ad.setButton3("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Menus.this, "Exit", Toast.LENGTH_SHORT).show();
            }
        });

        //show AlertDialog
        ad.show();
    }
}
