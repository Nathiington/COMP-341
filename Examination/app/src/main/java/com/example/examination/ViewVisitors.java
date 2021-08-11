package com.example.examination;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ViewVisitors extends AppCompatActivity {

    ListView lv;
    FloatingActionButton add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_visitors);


        DBHandler hand = new DBHandler(ViewVisitors.this);
        ArrayList<Visitor> visitors = hand.getAllVisitorData();
        CustomAdapter myCAdapter = new CustomAdapter(visitors,ViewVisitors.this);

        lv = findViewById(R.id.VisitorsListView);
        lv.setAdapter(myCAdapter);

        add = findViewById(R.id.registerVisitorButton);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),RegisterVisitor.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        DBHandler hand = new DBHandler(ViewVisitors.this);
        ArrayList<Visitor> studentList = hand.getAllVisitorData();

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
                ArrayList<Visitor> users = new ArrayList<>();

                for(Visitor v: studentList)
                {
                    if(v.getFirstName().toLowerCase().contains(newText.toLowerCase()) || v.getLastName().toLowerCase().contains(newText.toLowerCase()) || v.getContactNumber().toLowerCase().contains(newText.toLowerCase()) || v.getTemperature().contains(newText) || v.getDateOfVisit().contains(newText))
                    {
                        users.add(v);
                    }

                }
                CustomAdapter searchedStudents = new CustomAdapter(users,ViewVisitors.this);
                lv.setAdapter(searchedStudents);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}