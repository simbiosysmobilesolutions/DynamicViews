package com.simbiosyscorp.tutorials.dynamicviews;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SpinnerClass extends Activity implements AdapterView.OnItemSelectedListener{

    Spinner mySpinner;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        mySpinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter myAdapter = ArrayAdapter.createFromResource(this,R.array.days,R.layout.spinner_row);
        mySpinner.setAdapter(myAdapter);
        mySpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView tempTV=(TextView)view;
        String selectedDay=tempTV.getText().toString();
        Toast.makeText(getApplicationContext(), "You Selected : " + selectedDay, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
