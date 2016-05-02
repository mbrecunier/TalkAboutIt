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
import com.epicodus.talkaboutit.models.Category;
import com.firebase.client.Firebase;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddCategoryFragment extends Fragment implements View.OnClickListener {
    @Bind(R.id.addCategoryButton) Button mAddCategoryButton;
    @Bind(R.id.newCategoryEditText) EditText mNewCategoryEditText;


    public static AddCategoryFragment newInstance(Category category) {
        AddCategoryFragment addCategoryFragment = new AddCategoryFragment();
        Bundle args = new Bundle();
        args.putParcelable("category", Parcels.wrap(category));
        return addCategoryFragment;
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_add_category, container, false);
        ButterKnife.bind(this, view);

        mAddCategoryButton.setOnClickListener(this);
        return view;
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
