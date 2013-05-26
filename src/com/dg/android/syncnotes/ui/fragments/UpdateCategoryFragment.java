package com.dg.android.syncnotes.ui.fragments;

import android.os.Bundle;
import android.view.View;

import com.dg.android.syncnotes.R;
import com.dg.android.syncnotes.communication.requests.UpdateCategoryRequest;
import com.dg.android.syncnotes.domain.Category;
import com.dg.android.syncnotes.util.NotificationUtil;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.domain.ResponseStatus;

public class UpdateCategoryFragment extends BaseCategoryFragment {

	private Category category;

	public static UpdateCategoryFragment newInstance(Category c) {
		UpdateCategoryFragment fragment = new UpdateCategoryFragment();
		fragment.setCategory(c);
		return fragment;
	}

	public void setCategory(Category c) {
		this.category = c;
	}

	private final class UpdateCallback implements HttpCallback<Category> {
		@Override
		public void onSuccess(Category responseData) {
			getCallback().onCategoryModified(responseData);
			NotificationUtil.makeText(getActivity(),
					R.string.toast_category_updated);
			destroySelf();
		}

		@Override
		public void onHttpError(ResponseStatus responseCode) {
			NotificationUtil.makeText(getActivity(),
					R.string.toast_unable_to_update_category);
		}
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		populateCategory(category);
	}

	@Override
	public void onSaveButtonClicked(Category category) {
		category.setId(this.category.getId());
		new UpdateCategoryRequest(getActivity(), category, new UpdateCallback())
				.executeAsync();
	}

}
