package com.simbiosyscorp.tutorials.dynamicviews;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toListView(View view) {
    startActivity(new Intent(getApplicationContext(),ListViewClass.class));
    }
    public void toGridView(View view) {
        startActivity(new Intent(getApplicationContext(), GridViewClass.class));
    }
    public void toSpinnerView(View view) {
        startActivity(new Intent(getApplicationContext(),SpinnerClass.class));
    }
    public void toRecyclerView(View view) {
        startActivity(new Intent(getApplicationContext(),Recycler.class));
    }

}
