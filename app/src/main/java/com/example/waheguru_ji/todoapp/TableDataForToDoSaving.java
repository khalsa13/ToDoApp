package com.example.waheguru_ji.todoapp;

import android.provider.BaseColumns;

/**
 * Created by WAHEGURU-JI on 05-05-2017.
 */

public class TableDataForToDoSaving {
    public TableDataForToDoSaving() {
    }
    public static abstract class DataSaving implements BaseColumns
    {
        public static final String TextSaverDatabaseName="TextSaver";
        public static final String TextSaverTableName="TextSaverTable";
        public static final String TextSaverpassword="password";
        public static final String Text="Text";
    }
}
