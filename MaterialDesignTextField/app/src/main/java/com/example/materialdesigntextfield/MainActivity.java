package com.example.materialdesigntextfield;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.*;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText uName;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uName =  findViewById(R.id.UsernameEditText);
        login = findViewById(R.id.Loginbutton);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String st = uName.getText().toString();

                Intent i = new Intent(MainActivity.this,Home.class);
                i.putExtra("userName",st);

                startActivity(i);
            }
        });
    }
}