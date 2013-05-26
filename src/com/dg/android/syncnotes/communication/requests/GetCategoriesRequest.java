package com.dg.android.syncnotes.communication.requests;

import java.util.List;

import android.content.Context;

import com.dg.android.syncnotes.communication.RestConstants;
import com.dg.android.syncnotes.communication.parsers.CategoriesListParser;
import com.dg.android.syncnotes.domain.Category;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.requests.ParameterHttpRequestImpl;

public class GetCategoriesRequest extends ParameterHttpRequestImpl<List<Category>>{

	public GetCategoriesRequest(Context context,
			HttpCallback<List<Category>> callback) {
		super(context, RequestMethod.GET, new CategoriesListParser(), callback);
	}

	@Override
	protected String getUrl() {
		return RestConstants.CATEGORIES_GET;
	}


}
