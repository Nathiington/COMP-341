package com.example.rankopo18000441;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RegisterStudent extends AppCompatActivity {

    EditText fname, lname, birth, eAddress, number, prog;
    Button registerBtn, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student);
        DBHandler hand = new DBHandler(RegisterStudent.this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        fname = findViewById(R.id.firstnameEditText);
        lname = findViewById(R.id.lastnameEditText);
        eAddress = findViewById(R.id.emailAddressEditText);
        number = findViewById(R.id.phoneEditText);
        prog = findViewById(R.id.programmeEditText);
        registerBtn = findViewById(R.id.registerStudentButton);
        Calendar myCalendar = Calendar.getInstance();

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // getting the data from the EditText widgets
                String myFirstname = fname.getText().toString();
                String myLastname = lname.getText().toString();
                String myEAddress = eAddress.getText().toString();
                String myCNumber = number.getText().toString();
                String myProgramme = prog.getText().toString();

                if (myFirstname.isEmpty() || myLastname.isEmpty() || myEAddress.isEmpty()
                        || myCNumber.isEmpty() || myProgramme.isEmpty()) {
                    Toast myToast = Toast.makeText(getApplicationContext(), " Please fill in all categories ", Toast.LENGTH_LONG);
                    myToast.setGravity(Gravity.CENTER, 0, 0);
                    myToast.show();
                    return;
                }
                if (!myEAddress.trim().matches(emailPattern)) {
                    Toast myToast = Toast.makeText(getApplicationContext(), " Invalid Email address", Toast.LENGTH_LONG);
                    myToast.setGravity(Gravity.CENTER, 0, 0);
                    myToast.show();
                    return;
                }

                if (myCNumber.length() != 8) {
                    Toast myToast = Toast.makeText(getApplicationContext(), " Please confirm your phone number or next ofkin phone number", Toast.LENGTH_LONG);
                    myToast.setGravity(Gravity.CENTER, 0, 0);
                    myToast.show();
                    return;
                }
                // otherwise add date and time that we get from the EditText widgets above in the method
                hand.addStudent(myFirstname, myLastname, myEAddress, myCNumber, myProgramme);
                Toast.makeText(getApplicationContext(), "Success\n Student registered", Toast.LENGTH_LONG).show();
                // clearing the EditText widgets so new data can be easily input
                fname.setText("");
                lname.setText("");
                eAddress.setText("");
                number.setText("");
                prog.setText("");
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
