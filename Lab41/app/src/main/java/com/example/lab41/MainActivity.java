package com.example.lab41;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
//Arrays that store the names and images that are to be used int the Recycler View
    String[] myNames = {"Nathan","Naledi","Richard","John","Katlego","James","Ricardo","Daniel"};
//    Images are stored in integer arrays as the address is passed (which is an integer) not the image file
    int[] image = {R.drawable.profile_picture,R.drawable.profile_picture1,R.drawable.profile_picture2,R.drawable.profile_picture3,R.drawable.profile_picture4,R.drawable.profile_picture5,R.drawable.profile_picture6,R.drawable.profile_picture7};

    RecyclerView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       cardView = findViewById(R.id.mainRecyclerView);

//       Custom Adapter that we use for the Recycler View
       MyAdapter anAdapter = new MyAdapter(this,myNames,image);
//       Setting our custom adapter to our Recycler View
       cardView.setAdapter(anAdapter);
       cardView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
}