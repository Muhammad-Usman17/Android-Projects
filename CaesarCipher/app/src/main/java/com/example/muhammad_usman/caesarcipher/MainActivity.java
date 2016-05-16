package com.example.muhammad_usman.caesarcipher;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    HashMap hashmap= new HashMap();
    String Name, Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



    }
    void add()
    {
        hashmap.put("Usman", "us1234");
        hashmap.put("Nouman", "nomi123");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void Verify(View v) {
        add();
        EditText username = (EditText) findViewById(R.id.editText);
        Name = (String)username.getText().toString();
        EditText password = (EditText) findViewById(R.id.editText2);
        Password =(String) password.getText().toString();

        if (Password.equals(hashmap.get(Name)))
        {
            Intent i=new Intent(MainActivity.this,Endec.class);

            i.putExtra("name",Name);
            username.setText("");
            password.setText("");

            startActivity(i);

        }
        else
        {
            Toast toast=Toast.makeText(getApplicationContext(),"Wrong Username or Password",Toast.LENGTH_SHORT);
            toast.show();



        }
    }
    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}
