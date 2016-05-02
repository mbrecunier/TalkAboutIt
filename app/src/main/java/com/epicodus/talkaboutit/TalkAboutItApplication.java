package com.epicodus.talkaboutit;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Guest on 5/2/16.
 */
public class TalkAboutItApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
