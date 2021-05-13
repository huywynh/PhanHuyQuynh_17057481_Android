package com.example.middle_term_nhom_t5.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.middle_term_nhom_t5.Model.ItemAPI;
import com.example.middle_term_nhom_t5.Model.Shirt;
import com.example.middle_term_nhom_t5.adapter.ShirtListAdapter;
import com.example.middle_term_nhom_t5.R;

import java.util.List;

public class ActivityItemList extends AppCompatActivity {
    private List<Shirt> shirtList;
    private ShirtListAdapter shirtListAdapter;
    private RecyclerView recyclerView;
    private Intent intent;
    public static TextView subTotalTv;
    public static TextView totalTv;
    private Button checkoutBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        addControls();
    }

    private void addControls() {
        shirtList = ItemAPI.getInstance().getShirtList();

        shirtListAdapter = new ShirtListAdapter(this);
        shirtListAdapter.setData(shirtList);
        recyclerView = findViewById(R.id.item_list_rcv);
        recyclerView.setAdapter(shirtListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        subTotalTv = findViewById(R.id.item_list_subtotal_tv);
        totalTv =  findViewById(R.id.item_list_subtotal_tv);
        checkoutBtn = findViewById(R.id.item_list_checkout_btn);
    }
}