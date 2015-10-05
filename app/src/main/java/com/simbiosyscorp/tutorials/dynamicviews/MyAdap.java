package com.simbiosyscorp.tutorials.dynamicviews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by Sharvani on 8/11/2015.
 */
public class MyAdap extends RecyclerView.Adapter<MyAdap.MyVH> {
    LayoutInflater inflater;
    List<Info> data = Collections.emptyList();

    public MyAdap(Context context, List<Info> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override

    public MyVH onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.custom_row_recycler, parent, false);
        MyVH vh = new MyVH(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(MyVH holder, int position) {
        Info temp = data.get(position);
        holder.imageView.setImageResource(temp.image);
        holder.textView.setText(temp.name);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyVH extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public MyVH(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}

