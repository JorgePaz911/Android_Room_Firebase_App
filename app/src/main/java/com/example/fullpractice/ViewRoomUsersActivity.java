package com.example.fullpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.fullpractice.adapter.RecyclerRoomAdapter;
import com.example.fullpractice.model.User;

import java.util.ArrayList;

public class ViewRoomUsersActivity extends AppCompatActivity {

    private ArrayList<User> userList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_room_users);

        recyclerView = findViewById(R.id.room_rec_view);
        userList = new ArrayList<>();

        setUserInfo();
        setAdapter();
    }

    private void setAdapter() {
        RecyclerRoomAdapter adapter = new RecyclerRoomAdapter(userList);
        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setUserInfo() {
        userList.add(new User("Jorge", "j@j.com", 20));
        userList.add(new User("Jorge2", "2j@j.com", 22));
        userList.add(new User("Jorge3", "3j@j.com", 23));
    }
}