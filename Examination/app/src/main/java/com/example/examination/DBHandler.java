package com.example.examination;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    //variable for database name
    private static final String DB_NAME = "myDatabase.db";

    //the database version
    private static final int DB_VERSION = 1;

    // table name in our database
    private static final String TABLE_NAME ="Visitors";
    private static final String USER_TABLE_NAME ="Users";



    private static final String FNAME_COL = "FirstName";
    private static final String LNAME_COL = "LastName";
    private static final String DATEofVISIT = "DateOfVisit";
    private static final String CNUM = "ContactNumber";
    private static final String TEMPERATURE = "Temperature";

    private static final String USER_FNAME_COL = "FirstName";
    private static final String USER_LNAME_COL = "LastName";
    private static final String NATIONAL_ID = "NationalID";
    private static final String USER_CNUM = "ContactNumber";
    private static final String PASSWORD = "Password";
    private static final String ROLE = "Role";




    // database handler constructor
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // overriding the inCreate method
    // this will create a table in our database and execute that specified sql statement (in this case create table)
    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + " (" + FNAME_COL + " TEXT, "+ LNAME_COL + " TEXT, "+ DATEofVISIT + " TEXT, "+ CNUM  + " TEXT,  "+ TEMPERATURE + " TEXT ) ";
        String query1 = "CREATE TABLE " + USER_TABLE_NAME + " (" + USER_FNAME_COL + " TEXT, "+ USER_LNAME_COL + " TEXT, "+ NATIONAL_ID + " TEXT, "+ USER_CNUM  + " TEXT,  "+ PASSWORD + " TEXT, "+ ROLE + " TEXT )" ;

        db.execSQL(query);
        db.execSQL(query1);

    }

    // this method adds date and time to our sqlite table
    // we use ContentValues as a map with the key being our table column name and our value being the date or time
    // we also create an instance of an abstract function SQLiteDatabase which we will use to insert data into our database
    public void addVisitor(String fname, String lname, String dov, String cNum, String temp)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cvalues = new ContentValues();
        cvalues.put(FNAME_COL, fname);
        cvalues.put(LNAME_COL, lname);
        cvalues.put(DATEofVISIT, dov);
        cvalues.put(CNUM,cNum);
        cvalues.put(TEMPERATURE,temp);

        db.insert(TABLE_NAME,null, cvalues);
        db.close();

    }

    public void addUser(String fname, String lname, String nID, String cNum, String pwd, String role)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cvalues = new ContentValues();
        cvalues.put(USER_FNAME_COL, fname);
        cvalues.put(USER_LNAME_COL, lname);
        cvalues.put(NATIONAL_ID, nID);
        cvalues.put(USER_CNUM,cNum);
        cvalues.put(PASSWORD,pwd);
        cvalues.put(ROLE,role);

        db.insert(USER_TABLE_NAME,null, cvalues);
        db.close();

    }
    public ArrayList<Visitor> getAllVisitorData()
    {
        ArrayList<Visitor> visitorArrayList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(" SELECT * FROM " + TABLE_NAME,null);

        while(cursor.moveToNext())
        {
            String firstName = cursor.getString(0);
            String lastName = cursor.getString(1);
            String nationalID = cursor.getString(2);
            String contactNumber = cursor.getString(3);
            String password = cursor.getString(4);

            Visitor newVisitor = new Visitor(firstName, lastName, nationalID, contactNumber, password);
            visitorArrayList.add(newVisitor);
        }
        return visitorArrayList;
    }

    public ArrayList<Visitor> search(String keyword) {
        ArrayList<Visitor> visitorArrayList = null;
        try {
            SQLiteDatabase sqLiteDatabase = getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " where " + FNAME_COL + " like ?", new String[] { "%" + keyword + "%" });
            if (cursor.moveToFirst()) {
                visitorArrayList = new ArrayList<Visitor>();
                do {
                    Visitor v = new Visitor();
                    v.setFirstName(cursor.getString(0));
                    v.setLastName(cursor.getString(1));
                    v.setDateOfVisit(cursor.getString(2));
                    v.setContactNumber(cursor.getString(3));
                    v.setTemperature(cursor.getString(4));
                    visitorArrayList.add(v);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            visitorArrayList = null;
        }
        return visitorArrayList;
    }

    public boolean checkUserExist(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {NATIONAL_ID};

        String selection = "NationalID=? and Password = ?";
        String[] selectionArgs = {username, password};

        Cursor cursor = db.query(USER_TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();

        cursor.close();
        close();

        if(count > 0){
            return true;
        } else {
            return false;
        }
    }

    // this would be used if we need to re-write the table so we drop the current version and add the new one
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}


