package com.epicodus.talkaboutit.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.epicodus.talkaboutit.models.Post;
import com.epicodus.talkaboutit.ui.PostDetailFragment;

import java.util.ArrayList;

/**
 * Created by Guest on 5/3/16.
 */
public class PostPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Post> mPosts;

    public PostPagerAdapter(FragmentManager fm, ArrayList<Post> posts) {
        super(fm);
        mPosts = posts;
    }

    @Override
    public Fragment getItem(int position) {
        return PostDetailFragment.newInstance(mPosts.get(position));
    }

    @Override
    public int getCount() {
        return mPosts.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mPosts.get(position).getTitle();
    }
}