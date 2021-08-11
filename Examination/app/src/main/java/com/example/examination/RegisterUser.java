package com.example.examination;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterUser extends AppCompatActivity {

    EditText firstname,lastname,nationalID,contact,password,role;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        DBHandler handler = new DBHandler(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firstname = findViewById(R.id.userfirstnameEditText);
        lastname = findViewById(R.id.userlastnameEditText);
        nationalID = findViewById(R.id.nIDEditText);
        contact = findViewById(R.id.usercontactNumberEditText);
        password = findViewById(R.id.pwdEditText);
        role = findViewById(R.id.roleEditText);

        register = findViewById(R.id.registerUserButton);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fName = firstname.getText().toString();
                String lName = lastname.getText().toString();
                String nID = nationalID.getText().toString();
                String contactNo = contact.getText().toString();
                String pwd = password.getText().toString();
                String userRole = role.getText().toString();

                handler.addUser(fName,lName,nID,contactNo,pwd,userRole);

                Toast myToast = Toast.makeText( RegisterUser.this," Successfully registered " , Toast.LENGTH_LONG);
                myToast.setGravity(Gravity.CENTER, 0, 0);
                myToast.show();

                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}