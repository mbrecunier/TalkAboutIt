package com.epicodus.talkaboutit.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epicodus.talkaboutit.Constants;
import com.epicodus.talkaboutit.R;
import com.epicodus.talkaboutit.adapters.FirebaseCategoryListAdapter;
import com.epicodus.talkaboutit.models.Category;
import com.firebase.client.Firebase;
import com.firebase.client.Query;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryListFragment extends Fragment {
    private Query mQuery;
    private Firebase mFirebaseCategoriesRef;
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private FirebaseCategoryListAdapter mAdapter;


    public CategoryListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_category_list, container, false);
        ButterKnife.bind(this, view);

        mFirebaseCategoriesRef = new Firebase(Constants.FIREBASE_URL_CATEGORIES);

        setUpFirebaseQuery();
        setUpRecyclerView();

        return view;
    }

    private void setUpFirebaseQuery() {
        String category = mFirebaseCategoriesRef.toString();
        mQuery = new Firebase(category);
    }

    private void setUpRecyclerView() {
        mAdapter = new FirebaseCategoryListAdapter(mQuery, Category.class);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);
    }
}
