package com.example.muhammad_usman.database;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
            public void Add(View v) {
                Intent i=new Intent(this,Main2Activity.class);
                startActivity(i);
            }
            public void Delete(View v) {
                Intent i=new Intent(this,Main4Activity.class);
                startActivity(i);

            }
            public void Update(View v) {
                Intent i=new Intent(this,Main3Activity.class);
                startActivity(i);

            }
            public void Show(View v) {
                {
                    SqlClass helper = new SqlClass(this);
                    Cursor cur = helper.getData();
                    if (cur.getCount() == 0) {
                        message("Error:", "No record found");
                        return;
                    }
                    StringBuffer buf = new StringBuffer();
                    while (cur.moveToNext()) {
                        buf.append("ID: " + cur.getString(0) + "\n");
                        buf.append("Name: " + cur.getString(1) + "\n");
                        buf.append("Phone Number: " + cur.getString(2) + "\n");

                    }
                    message("Record: ", buf.toString());
                    Snackbar.make(v, "Show", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
    public void message(String title,String mesg)
    {
        AlertDialog.Builder  bu = new AlertDialog.Builder(this);
        bu.setCancelable(true);
        bu.setTitle(title);
        bu.setMessage(mesg);
        bu.show();
    }


            }






