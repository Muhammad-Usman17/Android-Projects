package com.example.muhammad_usman.caesarcipher;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Endec extends AppCompatActivity
{


    String input,num;
    Integer numkey=0;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endec);
        Intent i2 = getIntent();
        String name = i2.getStringExtra("name");
        TextView welcome = (TextView) findViewById(R.id.textView5);
        welcome.setText("Welcome  Mr " + name);
    }

    public void Encode(View v)
    {
        EditText premise = (EditText) findViewById(R.id.editText4);
        input = (String) premise.getText().toString();
        EditText shift=(EditText) findViewById(R.id.editText3);
        num= (String) shift.getText().toString();

        if(input.contentEquals("")  &&  num.contentEquals("") )
        {

            Toast toast = Toast.makeText(getApplicationContext(), "Your TEXT and KEY are empty", Toast.LENGTH_SHORT);
            toast.show();
        }
        else if(  num.contentEquals("") )
        {

            Toast toast = Toast.makeText(getApplicationContext(), "Your  KEY is empty", Toast.LENGTH_SHORT);
            toast.show();
        }
        else if(  input.contentEquals("") )
        {

            Toast toast = Toast.makeText(getApplicationContext(), "Your TEXT  is empty", Toast.LENGTH_SHORT);
            toast.show();
        }

        else
        {
            numkey=Integer.parseInt(num);
            if(numkey >=1 &&numkey<=25 )
            {
                TextView Result= (TextView)findViewById(R.id.textView4);

                Result.setText(encipher(input,numkey));
            }
            else
            {
                Toast toast=Toast.makeText(getApplicationContext(),"Enter Shift_key range(1-25)",Toast.LENGTH_LONG);
                toast.show();
            }


        }

    }



    String encipher(String en, int key)
    {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < en.length(); i++) {
            if (en.charAt(i) >= 65 && en.charAt(i) <= 90) {
                char encoded = en.charAt(i) + key > 90 ? (char) ((en.charAt(i) + key) - 26) : (char) (en.charAt(i) + key);
                builder.append(encoded);
            }
            else if (en.charAt(i) >= 97 && en.charAt(i) <= 122) {
                char encoded = en.charAt(i) + key > 122 ? (char) ((en.charAt(i) + key) - 26) : (char) (en.charAt(i) + key);
                builder.append(encoded);
            }
            else {
                char encoded = (char) (en.charAt(i) + 0);
                builder.append(encoded);
            }

        }
        return builder.toString();

    }
    public void Decode(View v)
    {
        TextView Result= (TextView)findViewById(R.id.textView4);
        input = (String) Result.getText().toString();
        EditText shift=(EditText) findViewById(R.id.editText3);
        num= (String) shift.getText().toString();

        if( input.contentEquals("")&&  num.contentEquals("") )
        {

            Toast toast = Toast.makeText(getApplicationContext(), "Your TEXT and KEY is empty", Toast.LENGTH_SHORT);
            toast.show();
        }
        else if(  num.contentEquals("") )
        {

            Toast toast = Toast.makeText(getApplicationContext(), "Your  KEY is empty", Toast.LENGTH_SHORT);
            toast.show();
        }
        else if(  input.contentEquals("") )
        {

            Toast toast = Toast.makeText(getApplicationContext(), "Your TEXT  is empty", Toast.LENGTH_SHORT);
            toast.show();
        }
        else
        {
            numkey=Integer.parseInt(num);
            if (numkey >= 1 && numkey <= 25) {
                EditText premise = (EditText) findViewById(R.id.editText4);
                premise.setText(decipher(input, numkey));
             } else {
                Toast toast = Toast.makeText(getApplicationContext(), "Enter Shift_key range(1-25)", Toast.LENGTH_SHORT);
                toast.show();
            }
        }


    }
    String decipher(String en, int key) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < en.length(); i++) {
            if (en.charAt(i) >= 65 && en.charAt(i) <= 90) {
                char encoded = en.charAt(i) - key <65 ? (char) ((en.charAt(i) - key) + 26) : (char) (en.charAt(i) - key);
                builder.append(encoded);
            } else if (en.charAt(i) >= 97 && en.charAt(i) <= 122) {
                char encoded = en.charAt(i) - key < 97 ? (char) ((en.charAt(i) - key) + 26) : (char) (en.charAt(i) - key);
                builder.append(encoded);
            } else {
                char encoded = (char) (en.charAt(i) - 0);
                builder.append(encoded);
            }

        }
        return builder.toString();
    }
    public void Reset(View v)
    {
        TextView Result= (TextView)findViewById(R.id.textView4);
        Result.setText("");
        EditText shift=(EditText) findViewById(R.id.editText3);
        shift.setText("");
        EditText premise = (EditText) findViewById(R.id.editText4);
        premise.setText("");
        Toast toast=Toast.makeText(getApplicationContext(),"Reset successfully",Toast.LENGTH_SHORT);
        toast.show();

    }
    public void onBackPressed()
    {
        AlertDialog.Builder logout=new AlertDialog.Builder(this);
        logout.setTitle("Logout");
        logout.setMessage("Are you sure to Logout?");

        logout.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish();
            }
        });
        logout.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alert=logout.create();
        alert.show();

    }
}