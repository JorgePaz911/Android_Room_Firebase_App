package com.example.fullpractice.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fullpractice.R;
import com.example.fullpractice.model.User;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class RecyclerRoomAdapter extends RecyclerView.Adapter<RecyclerRoomAdapter.ViewHolder> {

    private List<User> userList;
    private ItemClickListener clickListener;

    public RecyclerRoomAdapter(List<User> userList, ItemClickListener clickListener) {
        this.userList = userList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_view_room_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerRoomAdapter.ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onUserClick(userList.get(position));
            }
        });
        User user = userList.get(position);
        holder.name.setText(user.getName());
        holder.email.setText(user.getEmail());
        String age = "Age:\n" + String.valueOf(user.getAge());
        holder.age.setText(age);
    }

    @Override
    public int getItemCount() {
        if(userList != null) return userList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private TextView email;
        private TextView age;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.row_name_txt);
            email = itemView.findViewById(R.id.row_email_txt);
            age = itemView.findViewById(R.id.age_txt_row);
        }
    }

    public interface ItemClickListener{
        public void onUserClick(User user);
    }

}
