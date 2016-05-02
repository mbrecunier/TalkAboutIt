package com.epicodus.talkaboutit.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epicodus.talkaboutit.R;
import com.epicodus.talkaboutit.models.Category;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryDetailFragment extends Fragment {
    @Bind(R.id.categoryNameTextView) TextView mCategoryNameTextView;

    private Category mCategory;


    public static CategoryDetailFragment newInstance(Category category) {
        CategoryDetailFragment categoryDetailFragment = new CategoryDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("category", Parcels.wrap(category));
        categoryDetailFragment.setArguments(args);
        return categoryDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCategory = Parcels.unwrap(getArguments().getParcelable("category"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_detail, container, false);
        ButterKnife.bind(this, view);

        mCategoryNameTextView.setText(mCategory.getName());
        return view;
    }

}
