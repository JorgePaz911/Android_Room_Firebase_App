package com.example.fullpractice;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.fullpractice.model.SharedViewModel;
import com.example.fullpractice.model.User;

public class ViewUserDetailsFragment extends Fragment {

    private Button backBtn;
    private TextView name;
    private TextView email;
    private TextView age;

    private SharedViewModel sharedViewModel;

    public ViewUserDetailsFragment() {
    }

    //Creating view
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_user_details, container, false);

        backBtn = view.findViewById(R.id.btn_back_frag);
        name = view.findViewById(R.id.name_frag_det);
        email = view.findViewById(R.id.email_frag_det);
        age = view.findViewById(R.id.age_frag_det);

        return view;
    }

    //View already created
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sharedViewModel = new ViewModelProvider(requireActivity())
                .get(SharedViewModel.class);

        if(sharedViewModel.getSelectedUser() != null){
            User user = sharedViewModel.getSelectedUser().getValue();
            assert user != null;
            name.setText(user.getName());
            email.setText(user.getEmail());
            age.setText(String.valueOf(user.getAge()));

        }

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = requireActivity().getSupportFragmentManager();
                fm.beginTransaction().remove(ViewUserDetailsFragment.this).commit();
            }
        });
    }
}