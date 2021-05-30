package com.example.fullpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fullpractice.model.User;
import com.example.fullpractice.util.UserRoomDatabase;

public class AddUserRoomActivity extends AppCompatActivity {

    private EditText name;
    private EditText email;
    private EditText age;
    private Button submitBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user_room);

        name = findViewById(R.id.name_et);
        email = findViewById(R.id.email_et);
        age = findViewById(R.id.age_et);
        submitBtn = findViewById(R.id.submit_btn);

        submitBtn.setOnClickListener(v -> {
            User user = new User(name.getText().toString(), email.getText().toString(), Integer.parseInt(age.getText().toString()));
            saveNewUser(user);
        });

    }

    private void saveNewUser(User user) {
        UserRoomDatabase db = UserRoomDatabase.getDatabase(this.getApplicationContext());
        db.userDao().insert(user);
        startActivity(new Intent(AddUserRoomActivity.this, MainActivity.class));
        finish();
    }
}