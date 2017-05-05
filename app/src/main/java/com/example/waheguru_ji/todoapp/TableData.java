package com.example.waheguru_ji.todoapp;

import android.provider.BaseColumns;

/**
 * Created by WAHEGURU-JI on 05-05-2017.
 */

public class TableData {
    public TableData()
    {

    }
    public static abstract class TableInfo implements BaseColumns{

        public static final String TableName="Students";
        public static final String DatabaseName="Database";
        public static final String UserName="username";
        public static final String UserPassword="password";

    }
}
