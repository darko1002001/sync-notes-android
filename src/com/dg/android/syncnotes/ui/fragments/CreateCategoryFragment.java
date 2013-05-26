package com.dg.android.syncnotes.ui.fragments;

import com.dg.android.syncnotes.R;
import com.dg.android.syncnotes.communication.requests.CreateCategoryRequest;
import com.dg.android.syncnotes.domain.Category;
import com.dg.android.syncnotes.util.NotificationUtil;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.domain.ResponseStatus;

public class CreateCategoryFragment extends BaseCategoryFragment {

	private final class CreateCallback implements HttpCallback<Category> {
		@Override
		public void onSuccess(Category responseData) {
			getCallback().onCategoryAdded(responseData);
			NotificationUtil.makeText(getActivity(), R.string.toast_category_added);
			destroySelf();
		}

		@Override
		public void onHttpError(ResponseStatus responseCode) {
			NotificationUtil.makeText(getActivity(), R.string.toast_unable_to_create_category);
		}
	}

	@Override
	public void onSaveButtonClicked(Category category) {
		new CreateCategoryRequest(getActivity(), category,
				new CreateCallback()).executeAsync();		
	}

}
