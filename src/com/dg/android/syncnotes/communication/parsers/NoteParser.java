package com.dg.android.syncnotes.communication.parsers;

import java.io.InputStream;

import com.dg.android.syncnotes.domain.Note;
import com.dg.libs.rest.parsers.BaseJacksonMapperResponseParser;

public class NoteParser extends BaseJacksonMapperResponseParser<Note> {

	@Override
	public Note parse(InputStream instream) throws Exception {
		return mapper.readValue(instream, Note.class);
	}

}
