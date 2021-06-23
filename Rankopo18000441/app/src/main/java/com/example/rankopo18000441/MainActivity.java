package com.example.rankopo18000441;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton register;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHandler hand = new DBHandler(MainActivity.this);
        ArrayList<Student> studentList = hand.getAllData();
        CustomAdapter myCAdapter = new CustomAdapter(studentList,MainActivity.this);

        lv = findViewById(R.id.studentsList);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        DBHandler hand = new DBHandler(MainActivity.this);
        ArrayList<Student> studentList = hand.getAllData();

        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem searchItem = menu.findItem(R.id.appSearchBar);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<Student> users = new ArrayList<>();

                for(Student s: studentList)
                {
                    if(s.getFirstName().toLowerCase().contains(newText.toLowerCase()) || s.getLastName().toLowerCase().contains(newText.toLowerCase()) || s.getContactNumber().toLowerCase().contains(newText.toLowerCase()) || s.getEmail().toLowerCase().contains(newText.toLowerCase()) || s.getCourse().toLowerCase().contains(newText.toLowerCase()))
                    {
                        users.add(s);
                    }

                }
                CustomAdapter searchedStudents = new CustomAdapter(users,MainActivity.this);
                lv.setAdapter(searchedStudents);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}