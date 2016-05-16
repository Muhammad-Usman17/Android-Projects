package com.example.muhammad_usman.database;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        NumberPicker np = (NumberPicker)findViewById(R.id.numberPicker);
        np.setMinValue(0);
        np.setMaxValue(100);
        np.setWrapSelectorWheel(true);

        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
        {

            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal)
            {

                New = newVal;

            }
        });
    }
    int New=0;
    public void deleteinfo(View v)
    {
        SqlClass db = new SqlClass(this);



        Log.d("Insert: ", "deleting ..");
        db.deleteContact(new SetGet(New,null, null));

        Snackbar.make(v, "Successfully deleted", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

    }

}
