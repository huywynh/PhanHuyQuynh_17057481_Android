package com.example.middle_term_nhom_t5.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.middle_term_nhom_t5.Model.ItemAPI;
import com.example.middle_term_nhom_t5.Model.Shirt;
import com.example.middle_term_nhom_t5.R;
import com.example.middle_term_nhom_t5.activity.ActivityItemList;

import java.util.List;

public class ShirtListAdapter extends RecyclerView.Adapter<ShirtListAdapter.ShirtListViewHolder> {
    private Context mContext;
    private List<Shirt> shirtList;

    public ShirtListAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<Shirt> shirts) {
        this.shirtList = shirts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ShirtListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ShirtListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShirtListViewHolder holder, int position) {
        Shirt shirt = shirtList.get(position);
        if (shirt == null) {
            return;
        } else {
            holder.imageView.setImageResource(shirt.getImgRes());
            holder.sizeTv.setText("Size " + shirt.getSize().toString());
            holder.nameTv.setText(shirt.getName());
            holder.priceTv.setText("$" + shirt.getTotalMoney());
            holder.quantityTv.setText("" + shirt.getQuantity());
        }
    }

    @Override
    public int getItemCount() {
        if (shirtList != null) {
            return shirtList.size();
        }
        return 0;
    }


    public class ShirtListViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView nameTv, priceTv, quantityTv, sizeTv;
        private ImageButton addBtn, subBtn;

        public ShirtListViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_list_image_view);
            nameTv = itemView.findViewById(R.id.image_list_name_tv);
            priceTv = itemView.findViewById(R.id.image_list_price_tv);
            quantityTv = itemView.findViewById(R.id.image_list_quantity_btn);
            sizeTv = itemView.findViewById(R.id.image_list_size_tv);
            addBtn = itemView.findViewById(R.id.image_list_add_quantity_btn);
            subBtn = itemView.findViewById(R.id.image_list_sub_quantity_btn);

            addBtn.setOnClickListener(v -> {
                Shirt shirt = shirtList.get(getAdapterPosition());
                int newQuantity = shirt.getQuantity();
                newQuantity++;
                shirt.setQuantity(newQuantity);
                quantityTv.setText(newQuantity + "");
                priceTv.setText("$" + shirt.getTotalMoney());
                double subTotal = getSubTotal(ItemAPI.getInstance().getShirtList());
                ActivityItemList.subTotalTv.setText("$" + subTotal);
                ActivityItemList.totalTv.setText("$" + subTotal);
            });
            subBtn.setOnClickListener(v -> {
                Shirt shirt = shirtList.get(getAdapterPosition());
                int newQuantity = shirt.getQuantity();
                if(newQuantity > 1){
                    newQuantity--;
                    shirt.setQuantity(newQuantity);
                    quantityTv.setText(newQuantity + "");
                    priceTv.setText("$" + shirt.getTotalMoney());
                    double subTotal = getSubTotal(ItemAPI.getInstance().getShirtList());
                    ActivityItemList.subTotalTv.setText("$" + subTotal);
                    ActivityItemList.totalTv.setText("$" + subTotal);
                }
            });
        }

        private double getSubTotal(List<Shirt> list) {
            double subTotal = 0;
            for (Shirt shirt : list) {
                subTotal += shirt.getTotalMoney();
            }
            return subTotal;

        }
    }
}
