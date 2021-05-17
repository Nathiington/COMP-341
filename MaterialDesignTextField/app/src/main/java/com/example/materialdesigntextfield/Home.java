package com.example.materialdesigntextfield;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    TextView name;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        name = findViewById(R.id.userGreeting);
        logout= findViewById(R.id.Logoututton);

        Intent i = getIntent();

        String st = i.getStringExtra("userName");
        String hello = "Hello ".concat(st);

        name.setText(hello);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this,MainActivity.class);
                startActivity(i);
            }
        });

    }
}