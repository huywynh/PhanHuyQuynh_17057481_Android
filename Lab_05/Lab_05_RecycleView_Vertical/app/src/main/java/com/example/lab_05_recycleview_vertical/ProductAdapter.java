package com.example.lab_05_recycleview_vertical;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {


    private Context context;
    private List<Product> products;

    public ProductAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        Product product = products.get(position);

        DecimalFormat df = new DecimalFormat("###,###,###");

        holder.ivImage.setImageResource(product.getImage());
        holder.tvName.setText(product.getName());
        holder.rtRate.setRating(product.getRate());
        holder.tvRateNumber.setText("(" +product.getRateNumber()+")");
        holder.tvPrice.setText(df.format(product.getPrice()) +" đ");
        holder.tvDiscount.setText("-" + product.getDiscount());

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivImage;
        private TextView tvName;
        private RatingBar rtRate;
        private TextView tvRateNumber;
        private TextView tvPrice;
        private TextView tvDiscount;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            this.ivImage = itemView.findViewById(R.id.ivImage);
            this.tvName = itemView.findViewById(R.id.tvName);
            this.rtRate = itemView.findViewById(R.id.rtRate);
            this.tvRateNumber = itemView.findViewById(R.id.tvRateNumber);
            this.tvPrice = itemView.findViewById(R.id.tvPrice);
            this.tvDiscount = itemView.findViewById(R.id.tvDiscount);

        }
    }
}
