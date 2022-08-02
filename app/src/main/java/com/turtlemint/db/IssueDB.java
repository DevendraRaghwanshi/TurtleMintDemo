package com.turtlemint.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.turtlemint.model.IssuesModel;
import com.turtlemint.utils.DataConverter;

@Database(entities = {IssuesModel.class}, version = 2, exportSchema = false)
@TypeConverters({DataConverter.class})
public abstract class IssueDB extends RoomDatabase {

    public abstract DaoAccess daoAccess();
}