package com.myapplicationdev.android.p04_revisionnotes;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import static com.myapplicationdev.android.p04_revisionnotes.R.id.lv;

public class MainActivity extends AppCompatActivity {
    EditText etNote;
    RadioGroup rgstarts;
    RadioButton rbselected;
    Button btnInsert , btnShowList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNote = (EditText) findViewById(R.id.editTextNote);
        rgstarts = (RadioGroup) findViewById(R.id.radioGroupStars);
        btnInsert =(Button) findViewById(R.id.buttonInsertNote);
        btnShowList = (Button) findViewById(R.id.buttonShowList);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String notes = etNote.getText().toString();
                int stars = rgstarts.getCheckedRadioButtonId();
                rbselected = (RadioButton)findViewById(stars);
                //Get selected radio button text
                int getstars = Integer.parseInt(rbselected.getText().toString());


                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                db.insertNote(notes, getstars);
                Toast.makeText(MainActivity.this, "Inserted "
                                , Toast.LENGTH_SHORT).show();
                db.close();

            }
        });
     btnShowList.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent i = new Intent(MainActivity.this, SecondActivity.class);
             startActivity(i);

             DBHelper db = new DBHelper(MainActivity.this);



         }
     });
    }
}
