package com.turtlemint.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.turtlemint.model.IssuesModel;

import java.util.List;

@Dao
public interface DaoAccess {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insertTask(IssuesModel model);

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTask(List<IssuesModel> model);

    @Transaction
    @Query("SELECT * FROM Issues")
    LiveData<List<IssuesModel>> fetchAllTasks();

    @Query("SELECT * FROM Issues WHERE id =:id")
    LiveData<IssuesModel> getTask(int id);

    @Update
    void updateTask(IssuesModel model);

    @Delete
    void deleteTask(IssuesModel model);
}
