package com.example.newsfeed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Form extends AppCompatActivity {

    EditText user,post;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        DBHandler hand = new DBHandler(Form.this);
        user = findViewById(R.id.user);
        post = findViewById(R.id.postContent);
        btn = findViewById(R.id.submitButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stUser = user.getText().toString();
                String stPost = post.getText().toString();

                hand.addStudent(stUser,"18/06/2021",stPost);

                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

    }
}