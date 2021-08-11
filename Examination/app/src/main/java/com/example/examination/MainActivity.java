package com.example.examination;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userEditText,pwdEditText;
    Button register,logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHandler handler = new DBHandler(this);

        userEditText = findViewById(R.id.nIDLoginEditText);
        pwdEditText = findViewById(R.id.pwdLoginEditText);
        logIn=findViewById(R.id.login);
        register=findViewById(R.id.register);

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = userEditText.getText().toString();
                String password = pwdEditText.getText().toString();
                if(handler.checkUserExist(username,password))
                {
                    Intent i = new Intent(getApplicationContext(),ViewVisitors.class);
                    startActivity(i);
                }
                else
                {
                    Toast myToast = Toast.makeText( MainActivity.this," Invalid ID or password " , Toast.LENGTH_LONG);
                    myToast.setGravity(Gravity.CENTER, 0, 0);
                    myToast.show();
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),RegisterUser.class);
                startActivity(i);
            }
        });


    }
}