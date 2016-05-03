package com.epicodus.talkaboutit.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epicodus.talkaboutit.Constants;
import com.epicodus.talkaboutit.R;
import com.epicodus.talkaboutit.adapters.FirebasePostListAdapter;
import com.epicodus.talkaboutit.models.Category;
import com.epicodus.talkaboutit.models.Post;
import com.firebase.client.Firebase;
import com.firebase.client.Query;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 5/3/16.
 */
public class PostListFragment extends Fragment {
    private SharedPreferences mSharedPreferences;
    private String mRecentCategory;
    private Category mCategory;

    private Query mQuery;
    private Firebase mFirebasePostsRef;
    @Bind(R.id.recyclerView2) RecyclerView mRecyclerView;
    private FirebasePostListAdapter mAdapter;


    public PostListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_post_list, container, false);
        ButterKnife.bind(this, view);

        //mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        //mRecentCategory = mSharedPreferences.getString(Constants.PREFERENCES_CATEGORY_KEY, null);

        mCategory = Parcels.unwrap(getArguments().getParcelable("category"));


        mFirebasePostsRef = new Firebase(Constants.FIREBASE_URL_POSTS);

        setUpFirebaseQuery(mCategory);
        setUpRecyclerView();

        return view;
    }

    private void setUpFirebaseQuery(Category category) {
        String post = mFirebasePostsRef.toString();
        Firebase ref = new Firebase(post);
        mQuery = ref.orderByChild(category.getName());
    }

    private void setUpRecyclerView() {
        mAdapter = new FirebasePostListAdapter(mQuery, Post.class);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);
    }
}
