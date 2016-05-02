package com.epicodus.talkaboutit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epicodus.talkaboutit.R;
import com.epicodus.talkaboutit.models.Category;
import com.epicodus.talkaboutit.util.FirebaseRecyclerAdapter;
import com.firebase.client.Query;

/**
 * Created by Guest on 5/2/16.
 */
public class FirebaseCategoryListAdapter extends FirebaseRecyclerAdapter<CategoryViewHolder, Category> {

    public FirebaseCategoryListAdapter(Query query, Class<Category> itemClass) {
        super(query, itemClass);
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_list_item, parent, false);
        return new CategoryViewHolder(view, getItems());
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        holder.bindCategory(getItem(position));
    }

    @Override
    protected void itemAdded(Category item, String key, int position) {}

    @Override
    protected void itemChanged(Category oldItem, Category newItem, String key, int position) {}

    @Override
    protected void itemRemoved(Category item, String key, int position) {}

    @Override
    protected void itemMoved(Category item, String key, int oldPosition, int newPosition) {}
}
