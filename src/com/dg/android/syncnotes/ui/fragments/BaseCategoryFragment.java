package com.dg.android.syncnotes.ui.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dg.android.syncnotes.R;
import com.dg.android.syncnotes.domain.Category;
import com.dg.android.syncnotes.util.NotificationUtil;
import com.dg.libs.android.logger.ALog;

public abstract class BaseCategoryFragment extends Fragment {

	private EditText editTextName;
	private EditText editTextTitle;
	private EditText editTextDescription;

	public interface OnCategoryFragmentAction {
		public void onCategoryModified(Category category);

		public void onCategoryAdded(Category category);
	}

	private OnCategoryFragmentAction callback;

	public OnCategoryFragmentAction getCallback() {
		return callback;
	}

	public void populateCategory(Category c) {
		editTextName.setText(c.getName());
		editTextDescription.setText(c.getDescription());
		editTextTitle.setText(c.getTitle());
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			callback = (OnCategoryFragmentAction) activity;
		} catch (ClassCastException e) {
			ALog.d(OnCategoryFragmentAction.class.getSimpleName()
					+ " Must implement "
					+ OnCategoryFragmentAction.class.getSimpleName());
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		callback = null;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.base_category_fragment, null);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		editTextName = (EditText) view.findViewById(R.id.editTextName);
		editTextTitle = (EditText) view.findViewById(R.id.editTextTitle);
		editTextDescription = (EditText) view
				.findViewById(R.id.editTextDescription);
		Button buttonSave = (Button) view.findViewById(R.id.buttonSave);
		buttonSave.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				final Category c = new Category();
				c.setName(editTextName.getText().toString());
				c.setTitle(editTextTitle.getText().toString());
				c.setDescription(editTextDescription.getText().toString());
				if (c.isValid() == false) {
					NotificationUtil.makeText(getActivity(),
							R.string.toast_enter_required_parameters);
					return;
				}
				onSaveButtonClicked(c);
			}
		});

		Button buttonCancel = (Button) view.findViewById(R.id.buttonCancel);
		buttonCancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				destroySelf();
			}

		});
	}

	public void destroySelf() {
		getFragmentManager().beginTransaction()
				.remove(BaseCategoryFragment.this).commit();
	}

	public abstract void onSaveButtonClicked(Category category);
}
