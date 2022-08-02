package com.turtlemint.utils;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.turtlemint.model.IssuesModel;

public class DataConverter {

    @TypeConverter
    public String string(IssuesModel.UserEntity user) {
        if (user == null) {
            return null;
        }
        return new Gson().toJson(user, new TypeToken<IssuesModel.UserEntity>() {
        }.getType());
    }

    @TypeConverter
    public IssuesModel.UserEntity userEntity(String list) {
        if (list == null) {
            return null;
        }
        return new Gson().fromJson(list, new TypeToken<IssuesModel.UserEntity>() {
        }.getType());
    }
}