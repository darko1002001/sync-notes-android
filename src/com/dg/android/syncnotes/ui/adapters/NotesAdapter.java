package com.dg.android.syncnotes.ui.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.dg.android.syncnotes.R;
import com.dg.android.syncnotes.domain.Note;

public class NotesAdapter extends ArrayAdapter<Note>{

	private LayoutInflater inflater;
	public NotesAdapter(Context context,
			List<Note> objects) {
		super(context, R.layout.notes_adapter, objects);
		inflater = LayoutInflater.from(context);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = inflater.inflate(R.layout.notes_adapter, null);
		
		TextView title = (TextView) v.findViewById(R.id.textViewTitle);
		TextView description = (TextView) v.findViewById(R.id.textViewDescription);
		
		Note item = getItem(position);
		
		title.setText(item.getTitle());
		description.setText(item.getDescription());
		
		return v;
	}

}
