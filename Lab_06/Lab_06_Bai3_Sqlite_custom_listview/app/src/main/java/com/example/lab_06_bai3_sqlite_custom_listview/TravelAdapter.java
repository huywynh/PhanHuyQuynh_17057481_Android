package com.example.lab_06_bai3_sqlite_custom_listview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TravelAdapter extends BaseAdapter {
    ArrayList<Travel> listProduct;

    TravelAdapter(ArrayList<Travel> listProduct) {
        this.listProduct = listProduct;
    }

    @Override
    public int getCount() {
        return listProduct.size();
    }

    @Override
    public Object getItem(int position) {
        return listProduct.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listProduct.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewProduct;
        if (convertView == null) {
            viewProduct = View.inflate(parent.getContext(), R.layout.item_travel, null);
        } else viewProduct = convertView;

        Travel product = (Travel) getItem(position);
        ((TextView) viewProduct.findViewById(R.id.tvName)).setText(String.format("%s", product.getName()));

        return viewProduct;
    }


}
