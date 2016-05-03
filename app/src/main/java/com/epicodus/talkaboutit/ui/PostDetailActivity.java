package com.epicodus.talkaboutit.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.epicodus.talkaboutit.R;
import com.epicodus.talkaboutit.adapters.PostPagerAdapter;

import com.epicodus.talkaboutit.models.Post;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PostDetailActivity extends AppCompatActivity {
    @Bind(R.id.viewPager) ViewPager mViewPager;
    private PostPagerAdapter adapterViewPager;
    ArrayList<Post> mPosts = new ArrayList<>();
    private Post mPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        ButterKnife.bind(this);

        mPosts = Parcels.unwrap(getIntent().getParcelableExtra("posts"));
        int startingPosition = Integer.parseInt(getIntent().getStringExtra("position"));
        adapterViewPager = new PostPagerAdapter(getSupportFragmentManager(), mPosts);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);

    }
}
