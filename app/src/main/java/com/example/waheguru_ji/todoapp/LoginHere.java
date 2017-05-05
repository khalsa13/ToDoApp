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

public class LoginHere extends AppCompatActivity {
    EditText e1,e2;
    String name,pass;
    Context ctx=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_here);
        e1= (EditText) findViewById(R.id.user);
        e2= (EditText) findViewById(R.id.pass);

    }
    public void deleteuser(View view)
    {
        e1.setText("");
        e2.setText("");
    }

    public void signIn(View view)
    {
        name=e1.getText().toString();
        pass=e2.getText().toString();
        DatabaseOperations db=new DatabaseOperations(ctx);
        Cursor Cr=db.getInfo(db);
        boolean status=false;
        Cr.moveToFirst();
        do {
            if(name.equals(Cr.getString(0))&&pass.equals(Cr.getString(1)))
            {
                status=true;

            }

        }while(Cr.moveToNext());
        if(status)
        {
            Toast.makeText(getBaseContext(),"Login Success",Toast.LENGTH_LONG).show();
            Intent x=new Intent(this,WriteHere.class);
            Bundle b=new Bundle();
            b.putString("stuff",pass);
            x.putExtras(b);
            startActivity(x);
        }
        else
        {
            Toast.makeText(getBaseContext(),"Input Credentials Didn't Matched",Toast.LENGTH_SHORT).show();
            finish();
        }
    }

}
