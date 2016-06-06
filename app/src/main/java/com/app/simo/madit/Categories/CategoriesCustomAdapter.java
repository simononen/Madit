package com.app.simo.madit.Categories;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.app.simo.madit.R;

import java.util.List;

public class CategoriesCustomAdapter extends ArrayAdapter<Category> {
    public CategoriesCustomAdapter(Context context, int resource, List<Category> objects) {
        super(context, resource, objects);
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;
        Category c = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        textView = (TextView) convertView.findViewById(R.id.category);
        textView.setText(c.getName());


        return convertView;
    }

}