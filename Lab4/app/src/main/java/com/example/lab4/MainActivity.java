package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button sendButton;
    EditText enterName;
    ListView nameList;

    ArrayList<String> myArrayList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendButton = findViewById(R.id.savebtn);
        enterName = findViewById(R.id.editTextName);
        nameList = findViewById(R.id.savedNameList);

//       Adapters are used as middle men to transfer data between a data structure and a list view
        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,myArrayList);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = enterName.getText().toString();
//              Setting our adapter to our data structure
                nameList.setAdapter(myAdapter);
                myArrayList.add(name);
//              'Set state' method when if data is added or removed it refreshes the list view
                myAdapter.notifyDataSetChanged();
//              This will clear the edit text after the button is clicked
                enterName.getText().clear();
            }
        });

//        OnItemClickListener enables us to add onclick functionality to to an item in our list view
//        This can also be used for other objects
        nameList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//              To get the specific index that we want to send to the toast
                String data= (String) parent.getItemAtPosition(position);
                Toast myToast = Toast.makeText(getApplicationContext(), " You clicked " + data,Toast.LENGTH_LONG);
                myToast.setGravity(Gravity.CENTER, 0, 0);
                myToast.show();
            }
        });
    }


}