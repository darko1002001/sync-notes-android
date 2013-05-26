package com.dg.android.syncnotes.communication.requests;

import android.content.Context;

import com.dg.android.syncnotes.communication.RestConstants;
import com.dg.android.syncnotes.communication.parsers.NoteParser;
import com.dg.android.syncnotes.domain.Note;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.requests.ParameterHttpRequestImpl;

public class CreateNoteRequest extends ParameterHttpRequestImpl<Note> {

	public CreateNoteRequest(Context context, Note Note,
			HttpCallback<Note> callback) {
		super(context, RequestMethod.POST, new NoteParser(), callback);
		addParam("[Note][title]", Note.getTitle());
		addParam("[Note][name]", Note.getName());
		addParam("[Note][description]", Note.getDescription());
	}

	@Override
	protected String getUrl() {
		return RestConstants.NOTES_POST;
	}

}
