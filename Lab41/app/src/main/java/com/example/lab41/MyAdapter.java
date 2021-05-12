package com.example.lab41;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{
//    Object variables that will reference the text and images in our Recycler View
    String text[];
    int picture[];
    Context context;
//Constructor
    public MyAdapter(Context myContext,String[] names, int[] img)
    {
        context = myContext;
        text = names;
        picture = img;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
//        creating a view that holds our individual card being R.layout.row
        View view = inflater.inflate(R.layout.row,parent,false);
//        returning this view to the View Holder so it can load data into our view
//        here we create a View instance object for each 'person' in our array
        return new MyViewHolder(view);
    }
// this class will be used to create individual cards that will be repeated
    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView text;
        ImageView image;
//This is the object type that we create above
        public MyViewHolder( View itemView) {
            super(itemView);
//          here we are pointing to our text and image view widgets so they can hold the data
            text = itemView.findViewById(R.id.profileName);
            image = itemView.findViewById(R.id.displayPic);
        }
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {
//      here we are using our the holder to feed data into the widgets that were specified above
        holder.text.setText(text[position]);
        holder.image.setImageResource(picture[position]);
    }

//    this is to count how many ViewHolders (Cards) to create based on the number of names in the names array
    @Override
    public int getItemCount() {
        return text.length;
    }


}
