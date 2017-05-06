package com.example.waheguru_ji.todoapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class WriteHere extends AppCompatActivity {
EditText e;
    String x;
    Context ctxt=this;

    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_here);
        Bundle bundle=getIntent().getExtras();
        x=bundle.getString("stuff");
    e= (EditText) findViewById(R.id.writing);
    DatabaseForSavingToDos dd=new DatabaseForSavingToDos(ctxt);
        dd.putInform(dd,"0101010","pop");
        Cursor cr=dd.getInform(dd);
        boolean filestatus=false;
        cr.moveToFirst();
        do {
            if(x.equals(cr.getString(0))&&cr.getString(1)!=null)
            {
                filestatus=true;
                e.setText(cr.getString(1));
            }

        }while (cr.moveToNext());
        if(filestatus)
        {
            Toast.makeText(getBaseContext(),"Previous Data Loaded..",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getBaseContext(),"Welcome To The Activity Area",Toast.LENGTH_LONG).show();

        }
    }
    public void save(View view)
    {
        Toast.makeText(getBaseContext(),"To-Do Updated SuccesFully",Toast.LENGTH_SHORT).show();
        String str=e.getText().toString();
        String pass=x.toString();
        DatabaseForSavingToDos dob=new DatabaseForSavingToDos(ctxt);
        dob.putInform(dob,pass,str);
        Intent j=new Intent(this,MainActivity.class);
        startActivity(j);
        finish();

    }



}
