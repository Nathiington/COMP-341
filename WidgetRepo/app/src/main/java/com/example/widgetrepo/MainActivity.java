package com.example.widgetrepo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextInputLayout t;
    AutoCompleteTextView a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t = findViewById(R.id.textInputLayout);
        a = findViewById(R.id.courseDropwdown);

        String[] items = {
                "CSSE",
                "Maths",
                "Bio",
                "Earth"
        };

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(MainActivity.this,R.layout.dropdown,items);
        a.setAdapter(myAdapter);


    }
}