package com.epicodus.talkaboutit.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epicodus.talkaboutit.R;
import com.epicodus.talkaboutit.models.Post;

import org.parceler.Parcels;

import butterknife.ButterKnife;

/**
 * Created by Guest on 5/3/16.
 */
public class PostDetailFragment extends Fragment {
    private Post mPost;

    public static PostDetailFragment newInstance(Post post) {
        PostDetailFragment postDetailFragment = new PostDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("post", Parcels.wrap(post));
        postDetailFragment.setArguments(args);
        return postDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPost = Parcels.unwrap(getArguments().getParcelable("post"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post_detail, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
