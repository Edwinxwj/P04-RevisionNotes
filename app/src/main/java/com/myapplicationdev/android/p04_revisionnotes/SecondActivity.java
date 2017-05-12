package com.myapplicationdev.android.p04_revisionnotes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

	ListView lv;
	ArrayAdapter aa;
	ArrayList<Note> noteAL;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		lv = (ListView) findViewById(R.id.lv);

		DBHelper db = new DBHelper(SecondActivity.this);


		//Get data from the the database which I had input
		noteAL = db.getAllNotes();

		aa = new RevisionNotesArrayAdapter(this, R.layout.row, noteAL);
		lv.setAdapter(aa);










	}


}
