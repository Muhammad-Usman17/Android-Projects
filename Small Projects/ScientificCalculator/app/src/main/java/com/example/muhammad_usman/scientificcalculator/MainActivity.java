package com.example.muhammad_usman.scientificcalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import java.lang.*;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView textView;    //textview
    Boolean IsUsed=Boolean.FALSE; //bool variable to check point(.) is press once
    String input = "";
    String op1 = null; //first number
    String op2 = null; //second number
    double result = 0; //output
    String operation;  //operation +,-, sin,cos etc

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.textView);
        textView.setText("0");

    }

    public void clear(View v) //this function is used to reset value of calculator
    {
        input = ""; //input form user
        op1 = null; //first number
        op2 = null; //second number
        result = 0; //output
        textView.setText("0"); //screen display
    }
    public void NumButton(View v)//this function is to obtain the number from user
    {
        textView.setText("");
        Button butn=(Button)findViewById(v.getId());
        input =input+ butn.getText().toString();
        textView.setText(input);
    }
    public void point(View v)//this function is to obtain the point from user
    {

        if (IsUsed == Boolean.FALSE)
        {
            textView.setText("");
            input += ".";
            textView.setText(input);
            IsUsed=Boolean.TRUE;
        }
    }
    public void oper(View  v)//get the operation from user and save it
    {
        op1=input;
        Button butn=(Button)findViewById(v.getId());
        operation=butn.getText().toString();
        input="";
        IsUsed=Boolean.FALSE;
    }

    public void equal(View v)//perform the function on equal button pressed
    {

        op2 = input;

        if(op2.isEmpty()) //only if second variable is null because only one number is required for these operation
        {double a = Double.parseDouble(op1);
            if (operation.equals("SIN")) {
                if(op1!="") {
                    result = Math.sin(a);
                    textView.setText(Double.toString(result));
                }

            }
            else if (operation.equals("COS")) {

                    result = Math.cos(a);
                    textView.setText(Double.toString(result));

            }
            else if (operation.equals("TAN")) {

                    result = Math.tan(a);
                    textView.setText(Double.toString(result));

            }
            else if (operation.equals("LOG")) {

                    result = Math.log(a);
                    textView.setText(Double.toString(result));

            }
            else if (operation.equals("X^2")) {
                result =Math.pow(a,2);
                textView.setText(Double.toString(result));
            }
            else if (operation.equals("E^X")) {
                result = Math.pow(Math.E,a);
                textView.setText(Double.toString(result));
            }
            else if (operation.equals("UD")) {
                result = Math.sqrt(a);
                textView.setText(Double.toString(result));
            }
            else if (operation.equals("X!")) {


                for(int i=0; i<a;i++)
                {
                    a=  a*(a-1);
                }
                result = a;
                textView.setText(Double.toString(result));
            }
            else if (operation.equals("PIE")) {
                result = Math.PI*a;
                textView.setText(Double.toString(result));
            }


        }
        else if((op1!="")&&(op2!="")) //both variable are required for these operation
        {
            double a = Double.parseDouble(op1);
            double b = Double.parseDouble(op2);
            input = "";

            if (operation.equals("+")) {
                result = a + b;
                textView.setText(Double.toString(result));
            } else if (operation.equals("-")) {
                result = a - b;
                textView.setText(Double.toString(result));
            }            else if (operation.equals("*")) {
                result = a * b;
                textView.setText(Double.toString(result));
            }
            else if (operation.equals("/")) {
                result = a / b;
                textView.setText(Double.toString(result));
            }


        }


    }}
