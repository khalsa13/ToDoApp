package com.example.waheguru_ji.todoapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by WAHEGURU-JI on 05-05-2017.
 */

public class DatabaseOperations extends SQLiteOpenHelper {
    public static final int DatabaseVersion=1;
    public String Create_Query="Create Table "+ TableData.TableInfo.TableName+"( "+ TableData.TableInfo.UserName+" Text,"
            + TableData.TableInfo.UserPassword+" Text );";
    public DatabaseOperations(Context context) {
        super(context, TableData.TableInfo.DatabaseName, null, DatabaseVersion);
        Log.d("Database Operation: ","Database Created SuccesFully");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(Create_Query);
        Log.d("Database Operation: ","Table Created SuccesFully");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void putInfo(DatabaseOperations db,String name,String pass)
    {
        SQLiteDatabase sq=db.getWritableDatabase();
        ContentValues CV=new ContentValues();
        CV.put(TableData.TableInfo.UserName,name);
        CV.put(TableData.TableInfo.UserPassword,pass);
        sq.insert(TableData.TableInfo.TableName,null,CV);
        Log.d("Databse Operation: ","New Record Inserted ");
    }
    public Cursor getInfo(DatabaseOperations db)
    {
        SQLiteDatabase sq=db.getWritableDatabase();
        String []columns={TableData.TableInfo.UserName, TableData.TableInfo.UserPassword};
        Cursor CR=sq.query(TableData.TableInfo.TableName,columns,null,null,null,null,null);
        return CR;
    }
}
