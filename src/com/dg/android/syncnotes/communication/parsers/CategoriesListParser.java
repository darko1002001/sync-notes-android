package com.dg.android.syncnotes.communication.parsers;

import java.io.InputStream;
import java.util.List;

import com.dg.android.syncnotes.domain.Category;
import com.dg.libs.rest.parsers.BaseJacksonMapperResponseParser;
import com.fasterxml.jackson.core.type.TypeReference;

public class CategoriesListParser extends
		BaseJacksonMapperResponseParser<List<Category>> {

	@Override
	public List<Category> parse(InputStream instream) throws Exception {
		return mapper.readValue(instream, new TypeReference<List<Category>>() {
		});
	}

}
