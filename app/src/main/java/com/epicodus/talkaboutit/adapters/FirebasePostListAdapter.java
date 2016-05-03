package com.epicodus.talkaboutit.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epicodus.talkaboutit.R;
import com.epicodus.talkaboutit.models.Post;
import com.epicodus.talkaboutit.util.FirebaseRecyclerAdapter;
import com.firebase.client.Query;

/**
 * Created by Guest on 5/3/16.
 */
public class FirebasePostListAdapter extends FirebaseRecyclerAdapter<PostViewHolder, Post> {

    public FirebasePostListAdapter(Query query, Class<Post> itemClass) {
        super(query, itemClass);
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_list_item, parent, false);
        return new PostViewHolder(view, getItems());
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        holder.bindPost(getItem(position));
    }

    @Override
    protected void itemAdded(Post item, String key, int position) {}

    @Override
    protected void itemChanged(Post oldItem, Post newItem, String key, int position) {}

    @Override
    protected void itemRemoved(Post item, String key, int position) {}

    @Override
    protected void itemMoved(Post item, String key, int oldPosition, int newPosition) {}
}