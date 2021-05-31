package com.example.fullpractice.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.fullpractice.model.User;
import com.example.fullpractice.util.UserRoomDatabase;

import java.util.List;

public class UserRepository {

    private UserDao userDao;
    private LiveData<List<User>> allUsers;

    public UserRepository(Application application){
        UserRoomDatabase db = UserRoomDatabase.getDatabase(application);
        userDao = db.userDao();
        allUsers = userDao.getAllUsers();
    }

    public LiveData<List<User>> getAllUsers(){
        return allUsers;
    }

    public void insert(User user){
        UserRoomDatabase.databaseWriteExecutor.execute(() -> userDao.insert(user));
    }

    public LiveData<User> get(int id){
        return userDao.get(id);
    }

    public void delete(User user){
        UserRoomDatabase.databaseWriteExecutor.execute(() -> userDao.delete(user));
    }

    public void update(User user){
        UserRoomDatabase.databaseWriteExecutor.execute(() -> userDao.update(user));
    }
}









