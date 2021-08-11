package com.example.examination;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class RegisterVisitor extends AppCompatActivity {

    EditText firstName, lastName, temp, contact, date;
    Button regiser, cancel;
    static int day, months, years;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_visitor);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DBHandler hand = new DBHandler(this);

        firstName = findViewById(R.id.firstnameEditText);
        lastName = findViewById(R.id.lastnameEditText);
        temp = findViewById(R.id.temperatureEditText);
        contact = findViewById(R.id.contactNumberEditText);

        date = findViewById(R.id.dateOfVisitEditText);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar myCalendar = Calendar.getInstance();
                day = myCalendar.get(Calendar.DAY_OF_MONTH);
                months = myCalendar.get(Calendar.MONTH);
                years = myCalendar.get(Calendar.YEAR);

                DatePickerDialog d = new DatePickerDialog(RegisterVisitor.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month + 1;
                        date.setText(dayOfMonth + "/" + month + "/" + year);
                    }
                }, years, months, day);
                d.show();
            }
        });

        regiser = findViewById(R.id.registerVisitorButton);
        regiser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fName = firstName.getText().toString();
                String lName = lastName.getText().toString();
                String t = temp.getText().toString();
                String contactNo = contact.getText().toString();
                String dov = date.getText().toString();


                hand.addVisitor(fName,lName,dov,contactNo,t);

                Toast myToast = Toast.makeText( RegisterVisitor.this," Successfully registered " , Toast.LENGTH_LONG);
                myToast.setGravity(Gravity.CENTER, 0, 0);
                myToast.show();


            }
        });

        cancel = findViewById(R.id.cancelButton);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ViewVisitors.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, ViewVisitors.class));
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}