package com.epicodus.talkaboutit.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.epicodus.talkaboutit.models.Category;
import com.epicodus.talkaboutit.ui.AddCategoryFragment;
import com.epicodus.talkaboutit.ui.CategoryDetailFragment;

import java.util.ArrayList;

/**
 * Created by Guest on 5/2/16.
 */
public class CategoryPagerAdapter extends FragmentPagerAdapter{
    private ArrayList<Category> mCategories;

    public CategoryPagerAdapter(FragmentManager fm, ArrayList<Category> categories) {
        super(fm);
        mCategories = categories;
    }

    @Override
    public Fragment getItem(int position) {
        return CategoryDetailFragment.newInstance(mCategories.get(position));
    }

    @Override
    public int getCount() {
        return mCategories.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mCategories.get(position).getName();
    }
}
