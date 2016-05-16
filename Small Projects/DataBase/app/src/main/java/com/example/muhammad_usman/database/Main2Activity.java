package com.example.muhammad_usman.database;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void addnew(View v)
    {
        SqlClass db = new SqlClass(this);
        EditText name = (EditText) findViewById(R.id.editText);
        EditText email = (EditText) findViewById(R.id.editText2);
        EditText info = (EditText) findViewById(R.id.editText6);
        Log.d("Insert: ", "Inserting ..");
        db.addContact(new SetGet(name.getText().toString(), email.getText().toString()));


        Snackbar.make(v, "Successfully inserted", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
