package com.example.lab_04_b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private Context ctx;
    private int layout;
    private ArrayList<ElectricThing> arrayList;

    public CustomAdapter(Context ctx, int layout, ArrayList<ElectricThing> arrayList) {
        this.ctx = ctx;
        this.layout = layout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        if(view==null){
            view = LayoutInflater.from(ctx).inflate(layout, viewGroup, false);

            viewHolder = new ViewHolder();

            viewHolder.tvName = view.findViewById(R.id.tvName);
            viewHolder.tvreducePercent = view.findViewById(R.id.tvreducePercent);
            viewHolder.tvpeopleRate = view.findViewById(R.id.tvrpeopleRate);
            viewHolder.tvnewPrice = view.findViewById(R.id.tvnewPrice);
            viewHolder.imgThing = view.findViewById(R.id.imgThing);
            viewHolder.rtbRate = view.findViewById(R.id.rtBar);

            view.setTag(viewHolder);
        } else {viewHolder = (ViewHolder) view.getTag();
        }
        //assign values

        viewHolder.tvName.setText(arrayList.get(i).getName());
        viewHolder.tvnewPrice.setText(String.valueOf(arrayList.get(i).getNewPrice()));
        viewHolder.tvpeopleRate.setText("("+String.valueOf(arrayList.get(i).getPeopleRate())+")");
        viewHolder.tvreducePercent.setText("-"+String.valueOf(arrayList.get(i).getReducePercent())+"%");

        viewHolder.imgThing.setImageResource(arrayList.get(i).getImageThing());
        viewHolder.rtbRate.setRating(arrayList.get(i).getRate());

        return view;
    }
    private class ViewHolder{
        TextView tvName;
        TextView tvnewPrice;
        TextView tvpeopleRate;
        TextView tvreducePercent;
        ImageView imgThing;
        RatingBar rtbRate;
    }

}
