package com.epicodus.talkaboutit.ui;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.epicodus.talkaboutit.Constants;
import com.epicodus.talkaboutit.R;
import com.epicodus.talkaboutit.models.Category;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryDetailFragment extends Fragment implements View.OnClickListener{
    @Bind(R.id.categoryNameTextView) TextView mCategoryNameTextView;
    @Bind(R.id.addPostButton) Button mAddPostButton;

    private Category mCategory;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;



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

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        mEditor = mSharedPreferences.edit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_detail, container, false);
        ButterKnife.bind(this, view);
        mAddPostButton.setOnClickListener(this);

        mCategoryNameTextView.setText(mCategory.getName());
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v == mAddPostButton) {
            String category = mCategoryNameTextView.getText().toString();
            addToSharedPreferences(category);
            Intent intent = new Intent(getActivity(), AddPostActivity.class);
            startActivity(intent);
        }
    }

    private void addToSharedPreferences(String category) {
        mEditor.putString(Constants.PREFERENCES_CATEGORY_KEY, category).apply();
    }

}
