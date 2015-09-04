package com.example.ahmed.calculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Ahmed on 5/16/2015.
 */

public class DatabaseHandler extends SQLiteOpenHelper
{



    public DatabaseHandler(Context context)
    {
        //context to know where it will work in "SQLiteOpenHelper class"
        //MyDatabase name of database
        //null for cursor factory
        //1 is database version
        super(context, "MyDatabase", null, 1);
    }

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //create tables in MyDatabase has 3 columns "ID,Names,Job"
    //Called when the database is created for the first time.
    // This is where the creation of tables and the initial population of the tables should happen.
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        final String CREATE_CONTACTS_TABLE = "CREATE TABLE Contacts(ID INTEGER PRIMARY KEY autoincrement , Name TEXT not null , Job TEXT not null )";
        db.execSQL(CREATE_CONTACTS_TABLE);

        final String CREATE_CONTACTS_TABLE1 = "CREATE TABLE Contacts1(ID INTEGER PRIMARY KEY autoincrement , Name TEXT NOT NULL ,Job TEXT not null)";
        db.execSQL(CREATE_CONTACTS_TABLE1);
    }

    //Called when the database needs to be upgraded.
    //The implementation should use this method to drop tables, add tables, or do anything else it needs to upgrade to the new schema version.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

        //drop table if existed
        db.execSQL("DROP TABLE IF EXISTS Contacts");

        //Create table again
        //onCreate(db);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    //"SQLiteDatabase" is the base class for working with a SQLite database in Android and provides methods to
    // open, query, update and close the database.
    ////////////////////////////////////
    //The object "ContentValues" allows to define key/values.
    // The key represents the table column identifier and the value represents the content for the table record in this column.
    // ContentValues can be used for inserts and updates of database entries.
    ////////////////////////////////////
    //execSQL() method, which allows to execute an SQL statement directly.
    ////////////////////////////////////
    //Queries can be created via the rawQuery() and query() methods or via the SQLiteQueryBuilder class .
    //rawQuery() directly accepts an SQL select statement as input.
    //query() provides a structured interface for specifying the SQL query.
    //SQLiteQueryBuilder is a convenience class that helps to build SQL queries.
    //////////////////////////////////
    //A query returns a "Cursor" object. A Cursor represents the result of a query and basically points to one row of the query result.
    // This way Android can buffer the query results efficiently; as it does not have to load all data into memory.
    //To get the number of elements of the resulting query use the getCount() method.
    //To move between individual data rows, you can use the moveToFirst() and moveToNext() methods.
    // The isAfterLast() method allows to check if the end of the query result has been reached.
    //Cursor provides typed get*() methods, e.g. getLong(columnIndex), getString(columnIndex) to access the column data for the current position of the result.
    // The "columnIndex" is the number of the column you are accessing.
    //Cursor also provides the getColumnIndexOrThrow(String) method which allows to get the column index for a column name of the table.
    //A Cursor needs to be closed with the close() method call.


    //////////////////////////////////////////////////////////////////////////////////////////////
    //method to add Employee to database
    public void addEmployee(Employee firstEmplyee){
        //Write in database
        SQLiteDatabase myDB=this.getWritableDatabase();

        //This class is used to store a set of values
        ContentValues values=new ContentValues();
        //put values in columns
        values.put("Name",firstEmplyee.getName());
        values.put("Job",firstEmplyee.getJob());

        //Inserting Rows
        myDB.insert("Contacts",null,values);
        myDB.close();
    }

    //method to return employee by ID
    public Employee getEmployeeByID(int employeeID)
    {
        //read from database
        SQLiteDatabase db=this.getReadableDatabase();

        //
        Cursor cursor=db.query("Contacts",new String[]{"Name","Job"},"ID = ?",new String[] {String.valueOf(employeeID)},null,null,null,null);

        if(cursor != null) {
            cursor.moveToFirst();
        }
            Employee firstEmployee = new Employee(cursor.getString(0),cursor.getString(1));


        return firstEmployee;
    }

    //method2 to return employee by Name
    public Employee getEmployeeByName2(String name)
    {
        //read from database
        SQLiteDatabase db=this.getReadableDatabase();

        //
        Cursor cursor=db.query("Contacts",new String[]{"Name","Job"},"Name = ?",new String[] {name},null,null,null,null);

        if(cursor != null) {
            cursor.moveToFirst();
        }
        Employee firstEmployee = new Employee(cursor.getString(0),cursor.getString(1));


        return firstEmployee;
    }

    //method1 to return employee by Name
    public ArrayList<Employee> getEmployeeByName1(String name){

        ArrayList<Employee> empList=new ArrayList<Employee>();

        String selectQuery="SELECT * FROM Contacts WHERE Name="+name;

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);

        //if moveToFirst return True implement do-While
        if(cursor.moveToFirst()){
            do{
                //0 for ID, 1 for Name and 2 for job
                Employee firstEmployee=new Employee(cursor.getString(1),cursor.getString(2));

                //add firstEmployee to array List
                empList.add(firstEmployee);
            }while(cursor.moveToNext());
        }

        return empList;
    }


    //method to return arrayList of employees
    public ArrayList<Employee> getEmployeeInfo(){
        ArrayList<Employee> empList=new ArrayList<Employee>();

        String selectQuery="SELECT * FROM Contacts";

        String selectQuery1="SELECT * FROM Contacts1";


        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.rawQuery(selectQuery,null);

        //if moveToFirst return True implement do-While
        if(cursor.moveToFirst()){
            do{
                //0 for ID, 1 for Name and 2 for job
                Employee firstEmployee=new Employee(cursor.getString(1),cursor.getString(2));

                //add firstEmployee to array List
                empList.add(firstEmployee);
            }while(cursor.moveToNext());
        }
        return empList;
    }

    //method to return Number of employees using Cursor
    public int getEmployeeCount(){
        String countQuery="SELECT * FROM Contacts";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(countQuery,null);
        cursor.close();

        return cursor.getCount();
    }

    //method to delete employee using ID
    public void deleteEmployee(int employeeID){
        SQLiteDatabase db=this.getWritableDatabase();
        //delete row where ID = employeeID
        db.delete("Contacts","ID = ? ",new String[]{String.valueOf(employeeID)});
        db.close();
    }

    //method to update employee where ID = ?
    public void ubdateEmployee(Employee firstEmployee,int employeeID)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(firstEmployee.getName(),firstEmployee.getJob());

        //Updateing row
        db.update("Contacts",values,"ID = ?",new String[]{String.valueOf(employeeID)});

        db.close();
    }



}//end of DatabaseHandler
