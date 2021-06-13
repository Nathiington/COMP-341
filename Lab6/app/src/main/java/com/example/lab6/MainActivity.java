package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button dateBtn,timeBtn,saveBtn,viewBtn;
    EditText editTime,editDate;
    static int minutes,hours,day,months,years;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHandler hand = new DBHandler(MainActivity.this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        editTime = findViewById(R.id.editTextTime);
        timeBtn = findViewById(R.id.timeButton);
        timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // getting an instance of an abstract Calendar object
                Calendar myCalendar = Calendar.getInstance();
                // getting the minutes and hours from the calendar object
                minutes = myCalendar.get(Calendar.MINUTE);
                hours = myCalendar.get(Calendar.HOUR);

                // we create a TimePickerDialog object with the parameters of context and TimePickerDialog.OnTimeSetListener() method
                // we pass the TimePickerDialog.OnTimeSetListener() method as a parameter so we need to override the inbuilt function and use our own data
                // the onTimeSet method will create a timepicker view that we show at the end
                // it also sets the data to our adjacent EditText so we can see which Date we selected
                TimePickerDialog t = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        editTime.setText(hourOfDay + ":" + minute);
                    }
                },hours,minutes,false);
                t.show();
            }
        });


        editDate = findViewById(R.id.editTextDate);
        dateBtn =findViewById(R.id.dateButton);
        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar myCalendar = Calendar.getInstance();
                day = myCalendar.get(Calendar.DAY_OF_MONTH);
                months = myCalendar.get(Calendar.MONTH);
                years = myCalendar.get(Calendar.YEAR);

                DatePickerDialog d = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month=month+1;
                        editDate.setText(dayOfMonth+"/"+month+"/"+year);
                    }
                },years,months,day);
                d.show();
            }
        });


        saveBtn = findViewById(R.id.saveButton);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // getting the data from the EditText widgets
                String myDate = editDate.getText().toString();
                String myTime = editTime.getText().toString();

                // if date and time is empty then do not update the database table at all
                if(myDate.isEmpty() && myTime.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"No Date/Time",Toast.LENGTH_LONG).show();
                    return;
                }
                // otherwise add date and time that we get from the EditText widgets above in the method
                    hand.addDateTime(myDate,myTime);
                    Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();
                    // clearing the EditText widgets so new data can be easily input
                    editDate.setText("");
                    editTime.setText("");
            }
        });

        viewBtn = findViewById(R.id.viewButton);
        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.list_view);
                ListView lv = findViewById(R.id.userList);

                ArrayList<DateTime> dateList = hand.getAllData();

                CustomAdapter myCAdapter = new CustomAdapter(dateList,MainActivity.this);
                lv.setAdapter(myCAdapter);
            }
        });



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                startActivity(new Intent(MainActivity.this,MainActivity.class));
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}