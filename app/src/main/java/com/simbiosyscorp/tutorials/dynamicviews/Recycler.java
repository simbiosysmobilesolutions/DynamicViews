package com.simbiosyscorp.tutorials.dynamicviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Recycler extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAdap adapter;
    List<Info> data=new ArrayList<Info>();
    int[] images={R.drawable.first,R.drawable.second,R.drawable.thirdd};
    String[] names={"A","B","C"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        recyclerView= (RecyclerView) findViewById(R.id.rview);
        adapter=new MyAdap(this,getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Hi",Toast.LENGTH_LONG).show();
            }
        });

    }
    public List<Info> getData(){
        for(int i = 0; i<images.length;i++){
            Info current = new Info(images[i],names[i]);
            data.add(current);
        }
        return data;
    }


}
