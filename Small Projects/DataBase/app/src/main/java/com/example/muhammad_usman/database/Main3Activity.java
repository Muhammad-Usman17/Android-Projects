package com.example.muhammad_usman.database;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
public void updateinfo(View v)
{
    SqlClass db = new SqlClass(this);
    EditText name = (EditText) findViewById(R.id.editText4);
    EditText email = (EditText) findViewById(R.id.editText5);
    EditText info = (EditText) findViewById(R.id.editText3);
    Log.d("Insert: ", "updating ..");
    db.updateContact(new SetGet(Integer.parseInt(info.getText().toString()),name.getText().toString(), email.getText().toString()));


    Snackbar.make(v, "Successfully updated", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show();
}
}
