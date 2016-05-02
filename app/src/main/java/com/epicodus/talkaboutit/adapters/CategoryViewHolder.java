package com.epicodus.talkaboutit.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.epicodus.talkaboutit.R;
import com.epicodus.talkaboutit.models.Category;
import com.epicodus.talkaboutit.ui.CategoryDetailActivity;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 5/2/16.
 */
public class CategoryViewHolder extends RecyclerView.ViewHolder {
    private List<Category> mCategories = new ArrayList<>();
    @Bind(R.id.categoryNameTextView) TextView mCategoryNameTextView;
    private Context mContext;

    public CategoryViewHolder(View itemView, ArrayList<Category> categories) {
        super(itemView);
        mContext = itemView.getContext();
        ButterKnife.bind(this, itemView);
        mCategories = categories;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(mContext, CategoryDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("categories", Parcels.wrap(mCategories));
                mContext.startActivity(intent);
            }
        });
    }

    public void bindCategory(Category category) {
        mCategoryNameTextView.setText(category.getName());
    }
}
