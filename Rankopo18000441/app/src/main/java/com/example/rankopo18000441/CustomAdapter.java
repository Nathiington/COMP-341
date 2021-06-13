package com.example.rankopo18000441;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private ArrayList<Student> myStudentlist;
    private Context context;

    public CustomAdapter(ArrayList<Student> myStudentlist, Context context) {
        this.myStudentlist = myStudentlist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return myStudentlist.size();
    }

    @Override
    public Object getItem(int position) {
        return this.myStudentlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder =  null;

        if(convertView == null)
        {
            LayoutInflater inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inf.inflate(R.layout.list_row,null);
            holder = new ViewHolder();

            holder.fname = (TextView)convertView.findViewById(R.id.nameLabel);
            holder.lname = (TextView)convertView.findViewById(R.id.lastnameLabel);
            holder.email = (TextView)convertView.findViewById(R.id.emailLabel);
            holder.phone = (TextView)convertView.findViewById(R.id.phoneLabel);
            holder.course = (TextView)convertView.findViewById(R.id.programmeLabel);

        }
        else {
            holder = (ViewHolder)convertView.getTag();
        }

        Student student = myStudentlist.get(position);
        holder.fname.setText(student.getFirstName());
        holder.lname.setText(student.getLastName());
        holder.email.setText(student.getEmail());
        holder.phone.setText(student.getContactNumber());
        holder.course.setText(student.getCourse());


        return convertView;
    }

    private static class ViewHolder{
        public TextView fname;
        public TextView lname;
        public TextView email;
        public TextView phone;
        public TextView course;


    }

}

