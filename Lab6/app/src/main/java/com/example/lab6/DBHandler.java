package com.example.lab6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Date;

public class DBHandler extends SQLiteOpenHelper {

    //variable for database name
    private static final String DB_NAME = "Database.db";

    //the database version
    private static final int DB_VERSION = 1;

    // table name in our database
    private static final String TABLE_NAME ="datetime";

    //variable for date column
    private static final String DATE_COL = "Date";

    // variable for time column
    private static final String TIME_COL = "Time";

    // database handler constructor
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // overriding the inCreate method
    // this will create a table in our database and execute that specified sql statement (in this case create table)
    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + " (" + DATE_COL + " TEXT, " + TIME_COL + " TEXT ) ";

        db.execSQL(query);

    }

    // this method adds date and time to our sqlite table
    // we use ContentValues as a map with the key being our table column name and our value being the date or time
    // we also create an instance of an abstract function SQLiteDatabase which we will use to insert data into our database
    public void addDateTime(String cdate, String ctime)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cvalues = new ContentValues();
        cvalues.put(DATE_COL, cdate);
        cvalues.put(TIME_COL, ctime);

        db.insert(TABLE_NAME,null, cvalues);
        db.close();

    }

    // this would be used if we need to re-write the table so we drop the current version and add the new one
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public ArrayList<DateTime> getAllData()
    {
        ArrayList<DateTime> dateList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(" SELECT * FROM " + TABLE_NAME,null);

        while(cursor.moveToNext())
        {
            String date = cursor.getString(0);
            String time = cursor.getString(1);

            DateTime newTime = new DateTime(date,time);
            dateList.add(newTime);
        }
        return dateList;
    }




}
