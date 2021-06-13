package com.example.rankopo18000441;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    //variable for database name
    private static final String DB_NAME = "mydatabase.db";

    //the database version
    private static final int DB_VERSION = 1;

    // table name in our database
    private static final String TABLE_NAME ="register";


    private static final String FNAME_COL = "FirstName";
    private static final String LNAME_COL = "LastName";
    private static final String EADD = "EmailAddress";
    private static final String CNUM = "ContactNumber";
    private static final String PROG = "Programme";




    // database handler constructor
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // overriding the inCreate method
    // this will create a table in our database and execute that specified sql statement (in this case create table)
    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + " (" + FNAME_COL + " TEXT, "+ LNAME_COL + " TEXT, "+ EADD + " TEXT, "+ CNUM  + " TEXT,  "+ PROG + " TEXT ) ";

        db.execSQL(query);

    }

    // this method adds date and time to our sqlite table
    // we use ContentValues as a map with the key being our table column name and our value being the date or time
    // we also create an instance of an abstract function SQLiteDatabase which we will use to insert data into our database
    public void addStudent(String fname,String lname,String eAdd,String cNum,String prog)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cvalues = new ContentValues();
        cvalues.put(FNAME_COL, fname);
        cvalues.put(LNAME_COL, lname);
        cvalues.put(EADD, eAdd);
        cvalues.put(CNUM,cNum);
        cvalues.put(PROG,prog);

        db.insert(TABLE_NAME,null, cvalues);
        db.close();

    }
    public ArrayList<Student> getAllData()
    {
        ArrayList<Student> studentList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(" SELECT * FROM " + TABLE_NAME,null);

        while(cursor.moveToNext())
        {
            String firstName = cursor.getString(0);
            String lastName = cursor.getString(1);
            String course = cursor.getString(2);
            String email = cursor.getString(3);
            String contactNumber = cursor.getString(4);

            Student newStudent = new Student(firstName, lastName, course, email, contactNumber);
            studentList.add(newStudent);
        }
        return studentList;
    }

    // this would be used if we need to re-write the table so we drop the current version and add the new one
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

