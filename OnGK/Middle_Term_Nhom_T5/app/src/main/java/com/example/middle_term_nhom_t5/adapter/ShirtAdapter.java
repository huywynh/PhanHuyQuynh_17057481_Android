package com.example.middle_term_nhom_t5.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.middle_term_nhom_t5.Model.Shirt;
import com.example.middle_term_nhom_t5.R;
import com.example.middle_term_nhom_t5.activity.SecondActivity;

import java.util.List;

//Anh xa
public class ShirtAdapter extends RecyclerView.Adapter<ShirtAdapter.ShirtViewHolder> {
    private Context mContext;
    private List<Shirt> shirtList;

    public ShirtAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<Shirt> shirts) {
        this.shirtList = shirts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ShirtViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ShirtViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShirtViewHolder holder, int position) {
        Shirt shirt = shirtList.get(position);
        if (shirt == null) {
            return;
        } else {
            holder.imageView.setImageResource(shirt.getImgRes());
            holder.namtTv.setText(shirt.getName());
            holder.priceTv.setText("$" + shirt.getPrice());
        }
    }

    @Override
    public int getItemCount() {
        if (shirtList != null) {
            return shirtList.size();
        }
        return 0;
    }

    public class ShirtViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView namtTv, priceTv;

        public ShirtViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.shirt_image_view);
            namtTv = itemView.findViewById(R.id.shirt_name_tv);
            priceTv = itemView.findViewById(R.id.shirt_price_tv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, SecondActivity.class);
                    Shirt shirt = shirtList.get(getAdapterPosition());
                    intent.putExtra("ITEM", shirt);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
