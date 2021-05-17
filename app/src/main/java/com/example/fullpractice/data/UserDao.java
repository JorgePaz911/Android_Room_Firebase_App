package com.example.fullpractice.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.fullpractice.model.User;

import java.util.List;

@Dao
public interface UserDao {
    //Takes care of all CRUD operations

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(User user);

    @Query("DELETE FROM contact_table")
    void deleteAll();

    @Query("SELECT * FROM contact_table ORDER BY name ASC")
    LiveData<List<User>> getAllUsers();
}
