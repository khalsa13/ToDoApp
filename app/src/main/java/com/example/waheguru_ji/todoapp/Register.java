package com.example.waheguru_ji.todoapp;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
EditText E1,E2;
    Context ctx=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
         E1= (EditText) findViewById(R.id.username);
         E2= (EditText) findViewById(R.id.password);

    }
    public void signUp(View view)
    {
        DatabaseOperations db=new DatabaseOperations(ctx);
        String name=E1.getText().toString();
        String pass=E2.getText().toString();
        db.putInfo(db,name,pass);
        Toast.makeText(getBaseContext(),"New User Added SuccessFully",Toast.LENGTH_LONG).show();
        finish();
    }

}
