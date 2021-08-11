package com.example.examination;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private ArrayList<Visitor> myVisitorlist;
    private Context context;

    public CustomAdapter(ArrayList<Visitor> myVisitorlist, Context context) {
        this.myVisitorlist = myVisitorlist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return myVisitorlist.size();
    }

    @Override
    public Object getItem(int position) {
        return this.myVisitorlist.get(position);
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
            holder.dov = (TextView)convertView.findViewById(R.id.dateOfVisitLabel);
            holder.phone = (TextView)convertView.findViewById(R.id.phoneLabel);
            holder.temp = (TextView)convertView.findViewById(R.id.tempLabel);

        }
        else {
            holder = (ViewHolder)convertView.getTag();
        }

        Visitor visitor = myVisitorlist.get(position);
        holder.fname.setText(visitor.getFirstName());
        holder.lname.setText(visitor.getLastName());
        holder.dov.setText(visitor.getDateOfVisit());
        holder.phone.setText(visitor.getContactNumber());
        holder.temp.setText((visitor.getTemperature()));

        return convertView;
    }

    private static class ViewHolder{
        public TextView fname;
        public TextView lname;
        public TextView dov;
        public TextView phone;
        public TextView temp;

    }

}


