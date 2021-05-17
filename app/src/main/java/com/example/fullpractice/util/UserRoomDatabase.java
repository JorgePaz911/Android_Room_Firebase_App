package com.example.fullpractice.util;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.fullpractice.data.UserDao;
import com.example.fullpractice.model.User;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserRoomDatabase extends RoomDatabase {

    public abstract UserDao userDao();
    public static final int NUMBER_OF_THREADS = 4;

    //volatile allows for this instance to get rid of itself whenever it needs to
    private static volatile UserRoomDatabase INSTANCE;

    //executor service. Helps runs things behind thread
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    //gets only one instance. singleton pattern
    public static UserRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (UserRoomDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            UserRoomDatabase.class, "user_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
