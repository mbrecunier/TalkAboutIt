package com.epicodus.talkaboutit.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.epicodus.talkaboutit.Constants;
import com.epicodus.talkaboutit.R;
import com.firebase.client.Firebase;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddCategoryFragment extends Fragment implements View.OnClickListener {
    @Bind(R.id.addCategoryButton) Button mAddCategoryButton;
    @Bind(R.id.newCategoryEditText) EditText mNewCategoryEditText;

    public AddCategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mAddCategoryButton.setOnClickListener(this);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_category, container, false);
    }

    @Override
    public void onClick(View v) {
        if (v == mAddCategoryButton) {
            Firebase ref = new Firebase(Constants.FIREBASE_URL_CATEGORIES);
            String category = mNewCategoryEditText.getText().toString();
            ref.push().setValue(category);
            Toast.makeText(getContext(), "Added", Toast.LENGTH_SHORT).show();
        }
    }

}
