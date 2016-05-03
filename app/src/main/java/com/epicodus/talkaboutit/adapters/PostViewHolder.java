package com.epicodus.talkaboutit.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.epicodus.talkaboutit.R;
import com.epicodus.talkaboutit.models.Post;
import com.epicodus.talkaboutit.ui.PostDetailActivity;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 5/3/16.
 */
public class PostViewHolder extends RecyclerView.ViewHolder {
    private List<Post> mPosts = new ArrayList<>();
    @Bind(R.id.postTitleTextView) TextView mPostNameTextView;
    private Context mContext;

    public PostViewHolder(View itemView, ArrayList<Post> posts) {
        super(itemView);
        mContext = itemView.getContext();
        ButterKnife.bind(this, itemView);
        mPosts = posts;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(mContext, PostDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("posts", Parcels.wrap(mPosts));
                mContext.startActivity(intent);
            }
        });
    }

    public void bindPost(Post post) {
        mPostNameTextView.setText(post.getTitle());
    }
}
