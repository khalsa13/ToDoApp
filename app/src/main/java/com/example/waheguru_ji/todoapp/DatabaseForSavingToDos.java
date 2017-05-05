package com.example.waheguru_ji.todoapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;

/**
 * Created by WAHEGURU-JI on 05-05-2017.
 */

public class DatabaseForSavingToDos extends SQLiteOpenHelper {
    public static int version=2;
    public String query="Create Table "+ TableDataForToDoSaving.DataSaving.TextSaverTableName+"( "
            + TableDataForToDoSaving.DataSaving.TextSaverpassword
            +" Text," + TableDataForToDoSaving.DataSaving.Text+" Text);";
    public DatabaseForSavingToDos(Context context) {
        super(context,TableDataForToDoSaving.DataSaving.TextSaverDatabaseName, null, version);
        Log.d("Saving Operation: ","Database Created Succesfully");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(query);
        Log.d("Saving Operation: ","Table Created Succesfully");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void putInform(DatabaseForSavingToDos db,String pass,String s)
    {
        SQLiteDatabase sq=db.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(TableDataForToDoSaving.DataSaving.TextSaverpassword,pass);
        cv.put(TableDataForToDoSaving.DataSaving.Text,s);
        sq.insert(TableDataForToDoSaving.DataSaving.TextSaverTableName,null,cv);
        Log.d("Saving Operation: ","1 record Created Succesfully");

    }
    public Cursor getInform(DatabaseForSavingToDos db)
    {
        SQLiteDatabase sq=db.getWritableDatabase();
        String []column={TableDataForToDoSaving.DataSaving.TextSaverpassword,TableDataForToDoSaving.DataSaving.Text};
        Cursor cr=sq.query(TableDataForToDoSaving.DataSaving.TextSaverTableName,column,null,null,null,null,null);
        return cr;
    }
}
