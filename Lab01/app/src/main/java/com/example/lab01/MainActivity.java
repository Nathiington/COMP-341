package com.example.lab01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Button sumBtn,multiplyBtn;
    EditText num1,num2;
    TextView results;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.number1);
        num2 = findViewById(R.id.number2);
        sumBtn = findViewById(R.id.sumButton);
        multiplyBtn = findViewById(R.id.multiplyButton);
        results = findViewById(R.id.resultsBox);


//******************** Using the setOnClickListener is an alternative to making a function and passing it as an onClick method.
//******************** The code is similar to the Add() function described below
        sumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numb1 = Integer.parseInt(num1.getText().toString());
                int numb2 = Integer.parseInt(num2.getText().toString());
                int sum = numb1 + numb2;
                results.setText(String.valueOf(sum));
            }
        });

        multiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numb1 = Integer.parseInt(num1.getText().toString());
                int numb2 = Integer.parseInt(num2.getText().toString());
                int product = numb1 * numb2;
                results.setText(String.valueOf(product));
            }
        });
    }

//************************** In the function we parse 2 strings to integer (as text fields only get 'text' and you need to convert them to string then to whatever yuo want)
//    public void Add(View v)
//    {
//        int numb1 = Integer.parseInt(num1.getText().toString());
//        int numb2 = Integer.parseInt(num2.getText().toString());
//        int sum = numb1 + numb2;
//        int product =numb1 * numb2;
//
//************************** 2 if statements are used as the add method would be passed as an onClick so it would be looking for the ID of what was clicked then taking the appropriate action
//
////        if (v == findViewById(R.id.sumButton))
////        {
////        The toast is a pop-up
////            //Toast.makeText(this,("The sum  is: " + sum), Toast.LENGTH_SHORT).show();
////            results.setText(String.valueOf(sum));
////        }
////        if (v == findViewById(R.id.multiplyButton))
////        {
////            you need to convert everything to string as text fields/ text anything understands string
////            results.setText(String.valueOf(product));
////        }
//************************* this function has the same functionality as the if statements above
//        switch(v.getId())
//        {
//            case (R.id.sumButton):
//                results.setText(String.valueOf(sum));
//                break;
//            case (R.id.multiplyButton):
//                results.setText(String.valueOf(product));
//                break;
//        }
//    }
}