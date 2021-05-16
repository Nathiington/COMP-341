package com.example.lab5;

import android.os.Bundle;

import android.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

// A fragment is created by right-clicking the project folder selecting: New -> Fragment -> Blank Fragment
public class Fragment1 extends Fragment {

//    In our Fragment we specify what we ant it to do just like an activity
//    So in this case, we set our buttons and views then we proceed to make our button do something
    Button fragment;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        inflater will set our xml layout to inflate/'grow' into the size of a container(our container being the frame layout)
        view = inflater.inflate(R.layout.fragment_1, container, false);

//        we have to cast our view to button so it can find it
        fragment =(Button) view.findViewById(R.id.MainButton1);

        fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast message that pops up at the center of the screen
                Toast myToast = Toast.makeText( getActivity()," Something from fragment 1! " , Toast.LENGTH_LONG);
                myToast.setGravity(Gravity.CENTER, 0, 0);
                myToast.show();

            }
        });

        return view;
    }
}