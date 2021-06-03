package com.example.rankopo18000441;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
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

    EditText fname,lname,birth,gender,pAddress,eAddress,number,kin,cKin,fac,prog;
    static int day,months,years;
    Button registerBtn, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student);
        DBHandler hand = new DBHandler(RegisterStudent.this);
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        fname = findViewById(R.id.firstnameEditText);
        lname = findViewById(R.id.lastnameEditText);
        birth = findViewById(R.id.editTextDate);
        gender = findViewById(R.id.genderEditText);
        pAddress = findViewById(R.id.postalAddressEditText);
        eAddress = findViewById(R.id.emailAddressEditText);
        number = findViewById(R.id.phoneEditText);
        kin = findViewById(R.id.kinNameEditText);
        cKin = findViewById(R.id.kinContactEditText);
        fac = findViewById(R.id.facultyEditText);
        prog = findViewById(R.id.programmeEditText);
        registerBtn = findViewById(R.id.registerStudentButton);
        cancel = findViewById(R.id.cancelButton);
        Calendar myCalendar = Calendar.getInstance();

        birth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                day = myCalendar.get(Calendar.DAY_OF_MONTH);
                months = myCalendar.get(Calendar.MONTH);
                years = myCalendar.get(Calendar.YEAR);

                DatePickerDialog d = new DatePickerDialog(RegisterStudent.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month=month+1;
                        birth.setText(dayOfMonth+"/"+month+"/"+year);
                    }
                },years,months,day);
                d.show();
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // getting the data from the EditText widgets
                String myFirstname = fname.getText().toString();
                String myLastname = lname.getText().toString();
                String myDOB = birth.getText().toString();
                String myGender = gender.getText().toString();
                String myPAddress = pAddress.getText().toString();
                String myEAddress = eAddress.getText().toString();
                String myCNumber = number.getText().toString();
                String myNextKin = kin.getText().toString();
                String myNextKinContact = cKin.getText().toString();
                String myFaculty = fac.getText().toString();
                String myProgramme = prog.getText().toString();

                if(myFirstname.isEmpty() || myLastname.isEmpty() || myDOB.isEmpty() || myGender.isEmpty() ||myPAddress.isEmpty() || myEAddress.isEmpty()
                || myCNumber.isEmpty() || myNextKin.isEmpty() || myNextKinContact.isEmpty() || myFaculty.isEmpty() || myProgramme.isEmpty())
                {
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
                if(!myGender.equalsIgnoreCase("male") || !myGender.equalsIgnoreCase("female"))
                {
                    Toast myToast = Toast.makeText(getApplicationContext(), " Invalid Gender", Toast.LENGTH_LONG);
                    myToast.setGravity(Gravity.CENTER, 0, 0);
                    myToast.show();
                    return;
                }
                if(myCNumber.length() != 8 || myNextKinContact.length() != 8)
                {
                    Toast myToast = Toast.makeText(getApplicationContext(), " Please confirm your phone number or next ofkin phone number", Toast.LENGTH_LONG);
                    myToast.setGravity(Gravity.CENTER, 0, 0);
                    myToast.show();
                    return;
                }
                // otherwise add date and time that we get from the EditText widgets above in the method
                hand.addStudent(myFirstname,myLastname,myDOB,myGender,myPAddress,myEAddress,myCNumber,myNextKin,myNextKinContact,myFaculty,myProgramme);
                Toast.makeText(getApplicationContext(),"Success\n Student registered",Toast.LENGTH_LONG).show();
                // clearing the EditText widgets so new data can be easily input
                fname.setText("");
                lname.setText("");
                birth.setText("");
                gender.setText("");
                pAddress.setText("");
                eAddress.setText("");
                number.setText("");
                kin.setText("");
                cKin.setText("");
                fac.setText("");
                prog.setText("");
            }


        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });





        }
    }
