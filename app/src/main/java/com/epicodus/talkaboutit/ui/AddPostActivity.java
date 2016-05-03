package com.epicodus.talkaboutit.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.talkaboutit.Constants;
import com.epicodus.talkaboutit.R;
import com.epicodus.talkaboutit.models.Category;
import com.epicodus.talkaboutit.models.Post;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;

import org.parceler.Parcels;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddPostActivity extends AppCompatActivity implements View.OnClickListener{
    private SharedPreferences mSharedPreferences;
    private String mRecentCategory;
    @Bind(R.id.authorEditText) EditText mAuthorEditText;
    @Bind(R.id.titleEditText) EditText mTitleEditText;
    @Bind(R.id.bodyEditText) EditText mBodyEditText;
    @Bind(R.id.createPostButton) Button mCreatePostButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);
        ButterKnife.bind(this);
        mCreatePostButton.setOnClickListener(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mRecentCategory = mSharedPreferences.getString(Constants.PREFERENCES_CATEGORY_KEY, null);
    }

    @Override
    public void onClick(View v) {
        if(v == mCreatePostButton) {
            String title = mTitleEditText.getText().toString();
            String body = mBodyEditText.getText().toString();
            String author = mAuthorEditText.getText().toString();
            String category = mRecentCategory;

            Post newPost = new Post(title, body, author, category);
            Firebase ref = new Firebase(Constants.FIREBASE_URL_POSTS);
            ref.push().setValue(newPost);
            //toggle visibility
        }
    }
}
