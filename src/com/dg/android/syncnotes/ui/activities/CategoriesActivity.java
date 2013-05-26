package com.dg.android.syncnotes.ui.activities;

import java.util.List;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.dg.android.syncnotes.R;
import com.dg.android.syncnotes.communication.requests.GetCategoriesRequest;
import com.dg.android.syncnotes.domain.Category;
import com.dg.android.syncnotes.ui.adapters.CategoriesAdapter;
import com.dg.android.syncnotes.ui.fragments.CreateCategoryFragment;
import com.dg.android.syncnotes.ui.fragments.BaseCategoryFragment;
import com.dg.android.syncnotes.ui.fragments.BaseCategoryFragment.OnCategoryFragmentAction;
import com.dg.android.syncnotes.ui.fragments.UpdateCategoryFragment;
import com.dg.libs.android.logger.ALog;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.domain.ResponseStatus;

public class CategoriesActivity extends Activity implements
		OnCategoryFragmentAction {

	private ListView listViewCategories;
	private CategoriesAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_categories);

		listViewCategories = (ListView) findViewById(R.id.listViewCategories);

		new GetCategoriesRequest(this, new HttpCallbackImplementation())
				.executeAsync();

		listViewCategories
				.setOnItemClickListener(new OnItemClickListenerImplementation());
		registerForContextMenu(listViewCategories);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
		MenuItem update = menu.add(R.string.update);
		update.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		update.setOnMenuItemClickListener(new OnMenuItemClickListener() {

			@Override
			public boolean onMenuItemClick(MenuItem item) {
				showCategoryFragment(UpdateCategoryFragment.newInstance(adapter
						.getItem(info.position)));
				return true;
			}
		});
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuItem add = menu.add(R.string.add);
		add.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		add.setOnMenuItemClickListener(new OnMenuItemClickListener() {

			@Override
			public boolean onMenuItemClick(MenuItem item) {
				showCategoryFragment(new CreateCategoryFragment());
				return true;
			}
		});

		return super.onCreateOptionsMenu(menu);
	}

	private void showCategoryFragment(BaseCategoryFragment fragment) {
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		ft.replace(R.id.frameLayoutNewCategoryWrapper, fragment);
		ft.commit();
	}

	private final class OnItemClickListenerImplementation implements
			OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Intent intent = new Intent(getApplicationContext(),
					NotesActivity.class);
			intent.putExtra(NotesActivity.CATEGORY_ID, adapter
					.getItem(position).getId());
			startActivity(intent);
		}

	}

	private final class HttpCallbackImplementation implements
			HttpCallback<List<Category>> {
		@Override
		public void onSuccess(List<Category> responseData) {
			ALog.d(responseData.toString());
			adapter = new CategoriesAdapter(CategoriesActivity.this,
					responseData);
			listViewCategories.setAdapter(adapter);
		}

		@Override
		public void onHttpError(ResponseStatus responseCode) {
		}
	}

	@Override
	public void onCategoryAdded(Category category) {
		adapter.add(category);
	}

	@Override
	public void onCategoryModified(Category category) {
		adapter.replace(category);
	}

}
