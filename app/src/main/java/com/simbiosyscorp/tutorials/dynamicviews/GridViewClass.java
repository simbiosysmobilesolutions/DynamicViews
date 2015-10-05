package com.simbiosyscorp.tutorials.dynamicviews;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class GridViewClass extends AppCompatActivity {
    GridView gridView;
    private GridViewAdapter gridAdapter;
    int[] images = {R.drawable.flower1, R.drawable.flower2, R.drawable.flower3, R.drawable.flower4, R.drawable.flower5, R.drawable.flower6, R.drawable.flower7, R.drawable.flower8, R.drawable.flower9};
    ArrayList data = new ArrayList(Arrays.asList(images));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        gridView = (GridView) findViewById(R.id.gridView);
        gridAdapter = new GridViewAdapter(this, R.layout.images, getData());
        gridView.setAdapter(gridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Clicked on position :" + (position + 1), Toast.LENGTH_LONG).show();
            }
        });

    }
    private ArrayList<ImageItem> getData() {
        final ArrayList<ImageItem> imageItems = new ArrayList<>();
        TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);
        for (int i = 0; i < imgs.length(); i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
            imageItems.add(new ImageItem(bitmap, "Image#" + i));
        }
        return imageItems;
    }
    public class GridViewAdapter extends ArrayAdapter {
        private Context context;
        private int layoutResourceId;
        private ArrayList data = new ArrayList();

        public GridViewAdapter(Context context, int layoutResourceId, ArrayList<ImageItem> data) {
            super(context, layoutResourceId, data);
            this.layoutResourceId = layoutResourceId;
            this.context = context;
            this.data = data;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            ViewHolder holder = null;

            if (row == null) {
                LayoutInflater inflater = ((Activity) context).getLayoutInflater();
                row = inflater.inflate(layoutResourceId, parent, false);
                holder = new ViewHolder();
                holder.imageTitle = (TextView) row.findViewById(R.id.text);
                holder.image = (ImageView) row.findViewById(R.id.image);
                row.setTag(holder);
            } else {
                holder = (ViewHolder) row.getTag();
            }

            ImageItem item = (ImageItem) data.get(position);
            holder.imageTitle.setText(item.getTitle());
            holder.image.setImageBitmap(item.getImage());
            return row;
        }

        class ViewHolder {
            TextView imageTitle;
            ImageView image;
        }
    }
}
