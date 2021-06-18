package com.example.newsfeed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private ArrayList<Post> myPostlist;
    private Context context;

    public CustomAdapter(ArrayList<Post> myPostlist, Context context) {
        this.myPostlist = myPostlist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return myPostlist.size();
    }

    @Override
    public Object getItem(int position) {
        return this.myPostlist.get(position);
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
            convertView = inf.inflate(R.layout.card,null);
            holder = new ViewHolder();

            holder.userName = (TextView)convertView.findViewById(R.id.userLabel);
            holder.dateStamp = (TextView)convertView.findViewById(R.id.postLabel);
            holder.postContents = (TextView)convertView.findViewById(R.id.dateLabel);
        }
        else {
            holder = (ViewHolder)convertView.getTag();
        }

        Post posts = myPostlist.get(position);
        holder.userName.setText(posts.getUser());
        holder.dateStamp.setText(posts.getTime());
        holder.postContents.setText(posts.getPost());
        return convertView;
    }

    private static class ViewHolder{
        public TextView userName;
        public TextView dateStamp;
        public TextView postContents;
    }

}


