package com.example.rankopo18000441;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button view;
    FloatingActionButton register;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHandler hand = new DBHandler(MainActivity.this);
        ListView lv = findViewById(R.id.studentsList);

        ArrayList<Student> studentList = hand.getAllData();

        CustomAdapter myCAdapter = new CustomAdapter(studentList,MainActivity.this);
        lv.setAdapter(myCAdapter);

        register = findViewById(R.id.addStudent);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),RegisterStudent.class);
                startActivity(i);
            }
        });


    }
}