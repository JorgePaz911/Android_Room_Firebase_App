package com.example.fullpractice.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.fullpractice.model.User;

import java.util.List;

@Dao
public interface UserDao {
    //Takes care of all CRUD operations

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(User user);

    @Query("DELETE FROM user_table")
    void deleteAll();

    @Query("SELECT * FROM user_table ORDER BY name ASC")
    LiveData<List<User>> getAllUsers();

    @Delete
    void delete(User user);

    @Update
    void update(User user);

    @Query("SELECT * FROM user_table WHERE user_table.userId == :id")
    LiveData<User> get(int id);

}
