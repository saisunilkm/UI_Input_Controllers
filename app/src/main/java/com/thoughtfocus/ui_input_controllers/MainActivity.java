package com.thoughtfocus.ui_input_controllers;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    ToggleButton tb;
    CheckBox cb1,cb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb = (ToggleButton)findViewById(R.id.toggleButton);
        cb1 = (CheckBox)findViewById(R.id.checkBox);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);

        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(MainActivity.this,"Selected English",Toast.LENGTH_SHORT).show();
            }
        });

        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(MainActivity.this,"Selected Telugu",Toast.LENGTH_SHORT).show();
            }
        });



        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tb.isChecked()){
                    Toast.makeText(MainActivity.this,"Turned ON",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this,"Turned OFF",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void Alert(View view) {
        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setTitle("Exit");
        myAlert.setMessage("Are you Sure");
        myAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        myAlert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        myAlert.setCancelable(false);
        myAlert.show();
    }

    public void progressDialog(View view) {
        ProgressDialog pd = new ProgressDialog(this);
        pd.setTitle("Loading");
        pd.setMessage("Please Wait");
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.setButton(ProgressDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        pd.show();
    }
}