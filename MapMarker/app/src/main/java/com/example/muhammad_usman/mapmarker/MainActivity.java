package com.example.muhammad_usman.mapmarker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button p=(Button)findViewById(R.id.button2);
        p.setClickable(false);
    }
    String m_chosen;
    public  void onclick(View v) {

        SimpleFileDialog FileOpenDialog = new SimpleFileDialog(this, "FileOpen",
                new SimpleFileDialog.SimpleFileDialogListener() {
                    @Override
                    public void onChosenDir(String chosenDir) {
                        // The code in this function will be executed when the dialog OK button is pushed
                        m_chosen = chosenDir;
                        Toast.makeText(getApplicationContext(), "File Selected: " + m_chosen, Toast.LENGTH_LONG).show();
                        Button p=(Button)findViewById(R.id.button2);
                        p.setClickable(true);
                    }
                });

        //You can change the default filename using the public variable "Default_File_Name"
        FileOpenDialog.Default_File_Name = "";
        FileOpenDialog.chooseFile_or_Dir();



    }


    public void Perview(View v) {
        Intent i = new Intent(this, MapsActivity.class);

        i.putExtra("Filename", m_chosen);
        startActivity(i);
    }
}
