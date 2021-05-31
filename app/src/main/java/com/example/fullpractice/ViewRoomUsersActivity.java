package com.example.fullpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.fullpractice.adapter.RecyclerRoomAdapter;
import com.example.fullpractice.model.SharedViewModel;
import com.example.fullpractice.model.User;
import com.example.fullpractice.model.UserViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewRoomUsersActivity extends AppCompatActivity implements RecyclerRoomAdapter.ItemClickListener {

    private RecyclerView recyclerView;
    private UserViewModel userViewModel;
    private SharedViewModel sharedViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_room_users);

        recyclerView = findViewById(R.id.room_rec_view);

        sharedViewModel = new ViewModelProvider(this)
                .get(SharedViewModel.class);

        userViewModel = new ViewModelProvider
                .AndroidViewModelFactory(ViewRoomUsersActivity.this.getApplication())
                .create(UserViewModel.class);

        userViewModel.getAllUsers().observe(ViewRoomUsersActivity.this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                users.sort(Comparator.comparing(User::getAge));
                setAdapter(users);
            }
        });
    }

    private void setAdapter(List<User> users) {
        RecyclerRoomAdapter adapter = new RecyclerRoomAdapter(users, this);
        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onUserClick(User user) {
        sharedViewModel.setSelectedUser(user);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.frag_container);
        if (fragment == null) {
            fragment = new ViewUserDetailsFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.frag_container, fragment)
                    .commit();
        }
    }
}