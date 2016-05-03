package com.epicodus.talkaboutit.ui;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.epicodus.talkaboutit.Constants;
import com.epicodus.talkaboutit.R;

public class AddPostActivity extends AppCompatActivity {
    private SharedPreferences mSharedPreferences;
    private String mRecentCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mRecentCategory = mSharedPreferences.getString(Constants.PREFERENCES_CATEGORY_KEY, null);
    }
}
