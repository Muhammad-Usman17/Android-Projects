package com.example.muhammad_usman.redirectmessage;

import android.content.Intent;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
public void Start(View v)
{
    EditText number=(EditText)findViewById(R.id.editText) ;
    String num=number.getText().toString();
    if(num.equals("") )
    {
        Toast.makeText(this, "Your Number is empty!!", Toast.LENGTH_SHORT).show();

    }
    else
    {
        Intent i = new Intent(this, MyService.class);
        i.putExtra("Phone", num);
        startService(i);
    }
}
public void Stop(View v)
{
    Intent i=new Intent(this,MyService.class);
    stopService(i);
}
}
