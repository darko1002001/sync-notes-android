package com.dg.android.syncnotes.communication.requests;

import android.content.Context;

import com.dg.android.syncnotes.communication.RestConstants;
import com.dg.android.syncnotes.communication.parsers.CategoryParser;
import com.dg.android.syncnotes.domain.Category;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.requests.ParameterHttpRequestImpl;

public class CreateCategoryRequest extends ParameterHttpRequestImpl<Category> {


	public CreateCategoryRequest(Context context, Category category,
			HttpCallback<Category> callback) {
		super(context, RequestMethod.POST, new CategoryParser(), callback);
		addParam("[category][title]", category.getTitle());
		addParam("[category][name]", category.getName());
		addParam("[category][description]", category.getDescription());
	}

	@Override
	protected String getUrl() {
		return RestConstants.CATEGORIES_POST;
	}

}
