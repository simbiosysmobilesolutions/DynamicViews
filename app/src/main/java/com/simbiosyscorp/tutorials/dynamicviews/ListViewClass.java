package com.simbiosyscorp.tutorials.dynamicviews;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewClass extends Activity {

    ListView listView;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new CustomAdapter(this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Clicked " + (position+1) + " Item", Toast.LENGTH_SHORT).show();
            }
        });
    }

    class Person {
        int image;
        String name;
        String desc;

        public Person(int image, String name, String desc) {
            this.image = image;
            this.name = name;
            this.desc = desc;
        }
    }

    class CustomAdapter extends BaseAdapter {
        ArrayList<Person> persons;
        Context context;

        CustomAdapter(Context c) {
            this.context = c;
            persons = new ArrayList<Person>();
            Resources res = c.getResources();
            int i = 0;
            String[] names = res.getStringArray(R.array.names);
            String[] desc = res.getStringArray(R.array.description);
            int[] images = {R.drawable.first, R.drawable.second, R.drawable.thirdd, R.drawable.fourth};
            persons.clear();
            for (int j = 0; j < 100; j++) {

                i = j % names.length;
                persons.add(new Person(images[i], names[i], desc[i]));

            }
        }

        @Override
        public int getCount() {
            return persons.size();
        }

        @Override
        public Object getItem(int position) {
            return persons.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            MyViewHolder holder;
            View row = convertView;

            if (row == null) {
                count++;

                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.custom_row, parent, false);
                holder = new MyViewHolder(row);
                row.setTag(holder);
            } else {
                count++;
                holder = (MyViewHolder) row.getTag();

                Log.i("SIMBIOSYS-DEBUG", "This view is being recycled");

            }


            Person person = persons.get(position);

            holder.image.setImageResource(person.image);
            holder.name.setText(person.name);
            holder.desc.setText(person.desc);
            return row;
        }

        class MyViewHolder {
            ImageView image;
            TextView name;
            TextView desc;

            public MyViewHolder(View view) {
                image = (ImageView) view.findViewById(R.id.imageView);
                name = (TextView) view.findViewById(R.id.nameTV);
                desc = (TextView) view.findViewById(R.id.descTV);
            }
        }
    }

}
