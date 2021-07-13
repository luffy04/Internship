package com.example.intern;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void addUser(Country country);

    @Query("select * from Country")
    public List<Country> getUsers();

    @Delete
    public void deleteUser(Country country);

    @Update
    public void updateUser(Country country);

    @Query("DELETE FROM country")
    void delete();

}
