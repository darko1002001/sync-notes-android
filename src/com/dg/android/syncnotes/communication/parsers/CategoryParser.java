package com.dg.android.syncnotes.communication.parsers;

import java.io.InputStream;

import com.dg.android.syncnotes.domain.Category;
import com.dg.libs.rest.parsers.BaseJacksonMapperResponseParser;

public class CategoryParser extends
		BaseJacksonMapperResponseParser<Category> {

	@Override
	public Category parse(InputStream instream) throws Exception {
		return mapper.readValue(instream, Category.class);
	}

}
