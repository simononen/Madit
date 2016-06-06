package com.app.simo.madit.Prices;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.app.simo.madit.R;

import java.util.List;

public class PricesCustomAdapter extends ArrayAdapter<Price> {
    public PricesCustomAdapter(Context context, int resource, List<Price> price) {
        super(context, resource, price);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.price_list_item, parent, false);
        }

        // Get the data item for this position
        Price ph = getItem(position);

        TextView tvprice = (TextView) convertView.findViewById(R.id.price);

        tvprice.setText(ph.getPrice());


        // Return the completed view to render on screen
        return convertView;
    }
}

