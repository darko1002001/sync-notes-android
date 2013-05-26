package com.dg.android.syncnotes.communication.parsers;

import java.io.InputStream;
import java.util.List;

import com.dg.android.syncnotes.domain.Note;
import com.dg.libs.rest.parsers.BaseJacksonMapperResponseParser;
import com.fasterxml.jackson.core.type.TypeReference;

public class NotesListParser extends
		BaseJacksonMapperResponseParser<List<Note>> {

	@Override
	public List<Note> parse(InputStream instream) throws Exception {
		return mapper.readValue(instream, new TypeReference<List<Note>>() {
		});
	}

}
