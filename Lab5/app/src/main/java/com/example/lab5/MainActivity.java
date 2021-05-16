package com.example.lab5;


import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    Button fragment1;
    Button fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = findViewById(R.id.firstButton);
        fragment2 = findViewById(R.id.secondButton);

        fragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment( new Fragment1());
            }
        });

        fragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment( new Fragment2());
            }
        });


    }

//    this method will load a fragment xml into the a specified frame layout
    public void loadFragment (Fragment fragment)
    {
        FragmentManager f = getFragmentManager();
        FragmentTransaction myTrans = f.beginTransaction();
//        the replace method will replace the frame layout with the fragment xml
        myTrans.replace(R.id.myFrameLayout,fragment);
//        commit will make the save changes to the frame and reload the state
        myTrans.commit();

    }
}