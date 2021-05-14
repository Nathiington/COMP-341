package com.example.lab5;

import android.os.Bundle;

import android.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class Fragment2 extends Fragment {

    Button fragment;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.fragment_2, container, false);

        fragment =(Button) view.findViewById(R.id.MainButton2);

        fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast myToast = Toast.makeText( getActivity()," Something from fragment 2! " , Toast.LENGTH_LONG);
                myToast.setGravity(Gravity.CENTER, 0, 0);
                myToast.show();
            }

        });

        return view;
    }


}