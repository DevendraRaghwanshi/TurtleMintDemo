package com.turtlemint.utils;

import android.app.Application;

import com.turtlemint.db.Repository;

public class MyApplication extends Application {
    private static MyApplication mInstance;

    public Repository repository;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        repository = new Repository(getApplicationContext());
    }


    public static synchronized MyApplication getInstance() {
        return mInstance;
    }
}