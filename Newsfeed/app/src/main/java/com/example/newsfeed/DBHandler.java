package com.example.newsfeed;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    //variable for database name
    private static final String DB_NAME = "mydatabase.db";

    //the database version
    private static final int DB_VERSION = 1;

    // table name in our database
    private static final String TABLE_NAME ="posts";


    private static final String USER_COL = "User";
    private static final String DATE_COL = "DATE";
    private static final String CONTENT = "CONTENT";

    // database handler constructor
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // overriding the inCreate method
    // this will create a table in our database and execute that specified sql statement (in this case create table)
    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + " (" + USER_COL + " TEXT, "+ DATE_COL + " TEXT, "+ CONTENT + " TEXT ) ";

        db.execSQL(query);

    }

    // this method adds date and time to our sqlite table
    // we use ContentValues as a map with the key being our table column name and our value being the date or time
    // we also create an instance of an abstract function SQLiteDatabase which we will use to insert data into our database
    public void addStudent(String user,String date,String content)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cvalues = new ContentValues();
        cvalues.put(USER_COL, user);
        cvalues.put(DATE_COL, date);
        cvalues.put(CONTENT, content);

        db.insert(TABLE_NAME,null, cvalues);
        db.close();

    }
    public ArrayList<Post> getAllData()
    {
        ArrayList<Post> posts = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(" SELECT * FROM " + TABLE_NAME,null);

        while(cursor.moveToNext())
        {
            String user = cursor.getString(0);
            String date = cursor.getString(1);
            String content = cursor.getString(2);

            Post newPost = new Post(user, date, content);
            posts.add(newPost);
        }
        return posts;
    }

    // this would be used if we need to re-write the table so we drop the current version and add the new one
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}


