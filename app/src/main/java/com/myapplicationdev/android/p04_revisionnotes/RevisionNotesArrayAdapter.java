package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static com.myapplicationdev.android.p04_revisionnotes.R.string.stars;

public class RevisionNotesArrayAdapter extends ArrayAdapter<Note> {
	Context context;
	ArrayList<Note> notes;
	int resource;
	ImageView iv1, iv2, iv3, iv4, iv5;
	TextView tvNotes;



	public RevisionNotesArrayAdapter(Context context, int resource, ArrayList<Note> notes) {
		super(context, resource, notes);
		this.context = context;
		this.notes = notes;
		this.resource = resource;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View rowView = inflater.inflate(resource, parent, false);

		//Match the UI components with Java variables
		tvNotes = (TextView) rowView.findViewById(R.id.textViewNote);

		iv1 = (ImageView) rowView.findViewById(R.id.imageView1star);
		iv2 = (ImageView) rowView.findViewById(R.id.imageView2star);
		iv3 = (ImageView) rowView.findViewById(R.id.imageView3star);
		iv4 = (ImageView) rowView.findViewById(R.id.imageView4star);
		iv5 = (ImageView) rowView.findViewById(R.id.imageView5star);

		Note note = notes.get(position);

		int star = note.getStars();
		tvNotes.setText(note.getNoteContent());

		if (star == 5) {
			iv5.setImageResource(android.R.drawable.btn_star_big_on);
			iv4.setImageResource(android.R.drawable.btn_star_big_on);
			iv3.setImageResource(android.R.drawable.btn_star_big_on);
			iv2.setImageResource(android.R.drawable.btn_star_big_on);
			iv1.setImageResource(android.R.drawable.btn_star_big_on);
		} else if (star ==4) {
			iv4.setImageResource(android.R.drawable.btn_star_big_on);
			iv3.setImageResource(android.R.drawable.btn_star_big_on);
			iv2.setImageResource(android.R.drawable.btn_star_big_on);
			iv1.setImageResource(android.R.drawable.btn_star_big_on);
		} else if (star == 3) {
			iv3.setImageResource(android.R.drawable.btn_star_big_on);
			iv2.setImageResource(android.R.drawable.btn_star_big_on);
			iv1.setImageResource(android.R.drawable.btn_star_big_on);

		} else if (star == 2) {
			iv2.setImageResource(android.R.drawable.btn_star_big_on);
			iv1.setImageResource(android.R.drawable.btn_star_big_on);

		} else {
			iv1.setImageResource(android.R.drawable.btn_star_big_on);
		}


		return rowView;
	}



}
