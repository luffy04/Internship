package com.example.intern;

import androidx.room.RoomDatabase;
import androidx.room.Database;

@Database(entities = {Country.class}, version = 2,exportSchema = true)
public abstract class MyDatabase extends RoomDatabase {
    public abstract MyDao myDao();
}
