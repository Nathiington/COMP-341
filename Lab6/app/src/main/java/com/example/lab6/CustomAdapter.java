package com.example.lab6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private ArrayList<DateTime> myDatelist;
    private Context context;

    public CustomAdapter(ArrayList<DateTime> myDatelist, Context context) {
        this.myDatelist = myDatelist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return myDatelist.size();
    }

    @Override
    public Object getItem(int position) {
        return this.myDatelist.get(position);
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

            holder.time = (TextView)convertView.findViewById(R.id.time);
            holder.date = (TextView)convertView.findViewById(R.id.date);
        }
        else {
            holder = (ViewHolder)convertView.getTag();
        }

        DateTime student = myDatelist.get(position);
        holder.date.setText(student.getDate());
        holder.time.setText(student.getTime());


        return convertView;
    }

    private static class ViewHolder{
        public TextView date;
        public TextView time;

    }

}
