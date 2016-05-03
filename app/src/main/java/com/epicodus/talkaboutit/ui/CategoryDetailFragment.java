package com.epicodus.talkaboutit.ui;


import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.epicodus.talkaboutit.Constants;
import com.epicodus.talkaboutit.R;
import com.epicodus.talkaboutit.models.Category;
import com.epicodus.talkaboutit.models.Post;
import com.firebase.client.Firebase;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryDetailFragment extends Fragment implements View.OnClickListener{
    @Bind(R.id.categoryNameTextView) TextView mCategoryNameTextView;
    @Bind(R.id.addPostButton) Button mAddPostButton;
    private Category mCategory;

    public static CategoryDetailFragment newInstance(Category category) {
        CategoryDetailFragment categoryDetailFragment = new CategoryDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("category", Parcels.wrap(category));
        categoryDetailFragment.setArguments(args);
        return categoryDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCategory = Parcels.unwrap(getArguments().getParcelable("category"));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_detail, container, false);
        ButterKnife.bind(this, view);
        mAddPostButton.setOnClickListener(this);

        mCategoryNameTextView.setText(mCategory.getName());
        return view;
    }


    @Override
    public void onClick(View v) {
        if(v == mAddPostButton) {

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater = LayoutInflater.from(getActivity());
                final View dialogView = inflater.inflate(R.layout.post_dialog, null);
                dialogBuilder.setView(dialogView);

                final EditText titleEditText = (EditText) dialogView.findViewById(R.id.titleEditText);
                final EditText authorEditText = (EditText) dialogView.findViewById(R.id.authorEditText);
                final EditText bodyEditText = (EditText) dialogView.findViewById(R.id.bodyEditText);

                dialogBuilder.setTitle("New Post");

                dialogBuilder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        String title = titleEditText.getText().toString();
                        String body = bodyEditText.getText().toString();
                        String author = authorEditText.getText().toString();
                        String category = mCategoryNameTextView.getText().toString();

                        Post newPost = new Post(title, body, author, category);
                        Firebase ref = new Firebase(Constants.FIREBASE_URL_POSTS);
                        ref.push().setValue(newPost);
                    }
                });
                dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        //pass
                    }
                });
                AlertDialog b = dialogBuilder.create();
                b.show();
        }
    }
}
