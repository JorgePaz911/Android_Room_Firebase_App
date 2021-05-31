package com.example.fullpractice.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {

    private final MutableLiveData<User> selectedUser = new MutableLiveData<>();

    public void setSelectedUser(User user){
        selectedUser.setValue(user);
    }

    public LiveData<User> getSelectedUser(){
        return selectedUser;
    }
}
