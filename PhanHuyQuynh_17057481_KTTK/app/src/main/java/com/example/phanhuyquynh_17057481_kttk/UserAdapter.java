package com.example.phanhuyquynh_17057481_kttk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<User> users;

    public UserAdapter(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.UserViewHolder holder, int position) {
        User user = users.get(position);
        holder.setItem(user);
    }

    @Override
    public int getItemCount() {
        return users != null ? users.size() : 0;
    }

    public List<User> getItems() {
        return users;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName, tvAge;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(android.R.id.text1);
            tvAge = itemView.findViewById(android.R.id.text2);
        }

        public void setItem(User user) {
            tvName.setText(user.getName());
            tvAge.setText("Tuổi" + user.getTuoi());
        }
    }
}
