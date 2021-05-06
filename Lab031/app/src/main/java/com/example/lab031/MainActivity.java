package com.example.lab031;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button searchBtn;
    EditText link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchBtn = findViewById(R.id.searchButton);
        link = findViewById(R.id.linkText);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String header = "http://";
                String url = link.getText().toString();
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(header.concat(url)));

                startActivity(i);
            }
        });
    }
}