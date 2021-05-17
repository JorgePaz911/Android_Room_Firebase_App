package com.example.fullpractice.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fullpractice.R;
import com.example.fullpractice.model.User;

import java.util.ArrayList;

public class RecyclerRoomAdapter extends RecyclerView.Adapter<RecyclerRoomAdapter.ViewHolder> {

    private ArrayList<User> userList;

    public RecyclerRoomAdapter(ArrayList<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_view_room_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerRoomAdapter.ViewHolder holder, int position) {
        User user = userList.get(position);
        holder.name.setText(user.getName());
        holder.email.setText(user.getEmail());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private TextView email;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.row_name_txt);
            email = itemView.findViewById(R.id.row_email_txt);
        }
    }
}
