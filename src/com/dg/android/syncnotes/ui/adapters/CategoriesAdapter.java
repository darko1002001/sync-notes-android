package com.dg.android.syncnotes.ui.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.dg.android.syncnotes.R;
import com.dg.android.syncnotes.domain.Category;
import com.dg.libs.android.logger.ALog;

public class CategoriesAdapter extends BaseAdapter {

	private LayoutInflater inflater;
	private List<Category> list;

	public CategoriesAdapter(Context context, List<Category> objects) {
		super();
		this.list = objects;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = inflater.inflate(R.layout.categories_adapter, null);

		TextView title = (TextView) v.findViewById(R.id.textViewTitle);
		TextView description = (TextView) v
				.findViewById(R.id.textViewDescription);

		Category item = getItem(position);

		title.setText(item.getTitle());
		description.setText(item.getDescription());

		return v;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Category getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	public void replace(Category category) {
		ALog.d(category.toString());
		int position = ListView.INVALID_POSITION;
		for (int i = 0; i < list.size(); i++) {
			if (category.getId().equals(list.get(i).getId())) {
				position = i;
				break;
			}
		}
		if (position != ListView.INVALID_POSITION) {
			list.set(position, category);
			notifyDataSetChanged();
			return;
		}
		throw new IllegalArgumentException(
				"Category with sent id must be present in the list to update it");
	}

	public void add(Category category) {
		list.add(category);
		notifyDataSetChanged();
	}

}
