package com.example.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button sendBtn;
    TextView label;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendBtn = findViewById(R.id.Sendbutton);
        name = findViewById(R.id.NameField);



        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String st = name.getText().toString();

                Intent i = new Intent(MainActivity.this,MainActivity2.class);
                i.putExtra("userName",st);

                startActivity(i);

            }
        });
    }

}