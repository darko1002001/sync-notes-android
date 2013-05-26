package com.dg.android.syncnotes.communication.requests;

import java.util.List;

import android.content.Context;

import com.dg.android.syncnotes.communication.RestConstants;
import com.dg.android.syncnotes.communication.parsers.NotesListParser;
import com.dg.android.syncnotes.domain.Note;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.requests.ParameterHttpRequestImpl;

public class GetNotesRequest extends ParameterHttpRequestImpl<List<Note>>{

	private String categoryId;

	public GetNotesRequest(Context context, String string,
			HttpCallback<List<Note>> callback) {
		super(context, RequestMethod.GET, new NotesListParser(), callback);
		this.categoryId = string;
	}

	@Override
	protected String getUrl() {
		return String.format(RestConstants.NOTES_GET,categoryId);
	}


}
