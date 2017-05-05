package com.example.waheguru_ji.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            b1= (Button) findViewById(R.id.loginbutton);
            b2= (Button) findViewById(R.id.registerbutton);
            b3= (Button) findViewById(R.id.developerbutton);
    }
    public void Register(View view){
        Intent i=new Intent(this,Register.class);
        startActivity(i);

    }
    public void Login(View view)
    {
        Intent i1=new Intent(this,LoginHere.class);
        startActivity(i1);
    }
    public void developer(View view)
    {
        Intent f=new Intent(this,Developer.class);
        startActivity(f);
    }
}
