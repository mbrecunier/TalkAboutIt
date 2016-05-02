package com.epicodus.talkaboutit.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.epicodus.talkaboutit.Constants;
import com.epicodus.talkaboutit.R;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private Firebase mNewCategoryRef;
    private ValueEventListener mNewCategoryRefListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNewCategoryRef = new Firebase(Constants.FIREBASE_URL_CATEGORIES);


        mNewCategoryRefListener = mNewCategoryRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String categories = dataSnapshot.getValue().toString();
                Log.d("Category added", categories);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        mNewCategoryRef.removeEventListener(mNewCategoryRefListener);
    }
}
