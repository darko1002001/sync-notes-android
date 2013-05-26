package com.dg.android.syncnotes.communication.requests;

import android.content.Context;

import com.dg.android.syncnotes.communication.RestConstants;
import com.dg.android.syncnotes.communication.parsers.CategoryParser;
import com.dg.android.syncnotes.domain.Category;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.requests.ParameterHttpRequestImpl;

public class UpdateCategoryRequest extends ParameterHttpRequestImpl<Category>{

	private Category category;

	public UpdateCategoryRequest(Context context, Category category,
			HttpCallback<Category> callback) {
		super(context, RequestMethod.PUT, new CategoryParser(), callback);
		this.category = category;
		addParam("[category][title]", category.getTitle());
		addParam("[category][name]", category.getName());
		addParam("[category][description]", category.getDescription());
	}

	@Override
	protected String getUrl() {
		return String.format(RestConstants.CATEGORIES_PUT, category.getId());
	}


}
