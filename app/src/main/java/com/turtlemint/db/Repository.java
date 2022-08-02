package com.turtlemint.db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.turtlemint.model.IssuesModel;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private final String DB_NAME = "sk_central";

    private final IssueDB noteIssueDB;
    private final Context context;


    public Repository(Context context) {
        this.context = context;
        noteIssueDB = Room.databaseBuilder(context, IssueDB.class, DB_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }


    public void addItem(IssuesModel model) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                noteIssueDB.daoAccess().insertTask(model);
                return null;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    public void addItem(final ArrayList<IssuesModel> list) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                noteIssueDB.daoAccess().insertTask(list);
                return null;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    public void updateItem(final IssuesModel model) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                noteIssueDB.daoAccess().updateTask(model);
                return null;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    public LiveData<IssuesModel> getItem(int id) {
        return noteIssueDB.daoAccess().getTask(id);
    }

    public LiveData<List<IssuesModel>> getItems() {
        return noteIssueDB.daoAccess().fetchAllTasks();
    }

    public void deleteCartItem(final IssuesModel model) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                noteIssueDB.daoAccess().deleteTask(model);
                return null;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
}