package com.example.midterm_t6_10_12;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ThingViewHolder> {

    private Context context;
    private List<DoNut> doNuts;

    public void setData(List<DoNut> doNuts)
    {
        this.doNuts = doNuts;
        notifyDataSetChanged();
    }
    public MyAdapter(Context context)

    {
        this.context = context;
    }

    @NonNull
    @Override
    public ThingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.donut_item,parent,false);
        return new ThingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThingViewHolder holder, int position) {

        DoNut doNut = doNuts.get(position);
        if(doNut == null )
        {
            return;
        }
        holder.tvName.setText(doNut.getName());
        holder.tvName1.setText(doNut.getName1());
        holder.tvName2.setText(doNut.getName2());
        holder.imgDoNut.setImageResource(doNut.getImgDonut());
        holder.imgAdd.setImageResource(doNut.getImgAdd());
        holder.imgDoNut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailActivity.class);
                intent.putExtra("name",doNut.getName());
                intent.putExtra("img", doNut.getImgDonut());
                intent.putExtra("gia",doNut.getName2());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (doNuts != null) {
            return doNuts.size();
        }
        return 0;
    }

    public class ThingViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvName1, tvName2,tvGia;
        ImageView imgDoNut, imgAdd;
        MyAdapter myAdapter;

        public ThingViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvName1 = itemView.findViewById(R.id.tvName1);
            tvName2 = itemView.findViewById(R.id.tvName2);
            imgDoNut = itemView.findViewById(R.id.imgDonut);
            imgAdd = itemView.findViewById(R.id.imgAdd);
            tvGia = itemView.findViewById(R.id.tvGia);

        }
    }
}
