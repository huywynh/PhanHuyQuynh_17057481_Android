package com.example.lab_05_recycleview_horizontalvertical;

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

public class DeviceAdapter extends RecyclerView.Adapter<DeviceAdapter.DeviceViewHolder> {

    private Context context;
    private List<Device> devices;

    public DeviceAdapter(Context context, List<Device> devices) {
        this.context = context;
        this.devices = devices;
    }

    @NonNull
    @Override
    public DeviceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.device_layout, parent,false);

        return new DeviceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeviceViewHolder holder, int position) {

        Device device = devices.get(position);
        holder.ivImage.setImageResource(device.getImage());
        holder.tvName.setText(device.getName());
        holder.rtRate.setRating(device.getRate());
        holder.tvRateNumber.setText("("+device.getRateNumber()+")");
        DecimalFormat df = new DecimalFormat("###,###,###.00");
        holder.tvPrice.setText(df.format(device.getPrice())+" đ");
        holder.tvDiscount.setText("-"+device.getDiscount());
    }

    @Override
    public int getItemCount() {
        return devices.size();
    }

    public class DeviceViewHolder extends  RecyclerView.ViewHolder {

        private ImageView ivImage;
        private TextView tvName;
        private RatingBar rtRate;
        private TextView tvRateNumber;
        private TextView tvPrice;
        private  TextView tvDiscount;

        public DeviceViewHolder(@NonNull View itemView) {
            super(itemView);

            ivImage = itemView.findViewById(R.id.ivImage);
            tvName = itemView.findViewById(R.id.tvName);
            rtRate = itemView.findViewById(R.id.rtRate);
            tvRateNumber = itemView.findViewById(R.id.tvRateNumber);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvDiscount = itemView.findViewById(R.id.tvDiscount);
        }
    }
}
