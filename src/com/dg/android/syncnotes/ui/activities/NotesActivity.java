package com.dg.android.syncnotes.ui.activities;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.dg.android.syncnotes.R;
import com.dg.android.syncnotes.communication.requests.GetNotesRequest;
import com.dg.android.syncnotes.domain.Note;
import com.dg.android.syncnotes.ui.adapters.NotesAdapter;
import com.dg.libs.android.logger.ALog;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.domain.ResponseStatus;

public class NotesActivity extends Activity {

	public static final String CATEGORY_ID = "category_id";
	private ListView listViewNotes;
	private NotesAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notes);
		listViewNotes = (ListView) findViewById(R.id.listViewNotes);

		String id = getIntent().getExtras()
				.getString(NotesActivity.CATEGORY_ID);

		new GetNotesRequest(this, id, new HttpCallbackImplementation())
				.executeAsync();

	}

	private final class HttpCallbackImplementation implements
			HttpCallback<List<Note>> {
		@Override
		public void onSuccess(List<Note> responseData) {
			ALog.d(responseData.toString());
			adapter = new NotesAdapter(NotesActivity.this, responseData);
			listViewNotes.setAdapter(adapter);
		}

		@Override
		public void onHttpError(ResponseStatus responseCode) {

		}
	}

}
