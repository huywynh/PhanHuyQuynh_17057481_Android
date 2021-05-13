package com.example.middle_term_nhom_t5.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.middle_term_nhom_t5.Model.ItemAPI;
import com.example.middle_term_nhom_t5.Model.Shirt;
import com.example.middle_term_nhom_t5.Model.Size;
import com.example.middle_term_nhom_t5.R;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int QUANTITY_DEFAULT = 1;
    private ImageView imageView;
    private TextView nameTv, priceTv;
    private RadioButton xBtn, lBtn, xlBtn, sBtn;
    private Button addToBagBtn;
    private Intent intent;
    private Shirt shirt;
    private static List<Shirt> shirts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        addEvents();
        addControls();
    }

    private void addControls() {
        imageView = findViewById(R.id.image_detail_image_view);
        nameTv = findViewById(R.id.image_detail_name_tv);
        priceTv = findViewById(R.id.image_detail_price_tv);
        xBtn = findViewById(R.id.image_detail_x_btn);
        lBtn = findViewById(R.id.image_detail_l_btn);
        xlBtn = findViewById(R.id.image_detail_xl_btn);
        sBtn = findViewById(R.id.image_detail_s_btn);
        addToBagBtn = findViewById(R.id.image_detail_add_to_bag);

        intent = getIntent();
        shirt = (Shirt) intent.getSerializableExtra("ITEM");

        imageView.setImageResource(shirt.getImgRes());
        nameTv.setText(shirt.getName());
        priceTv.setText("$" + shirt.getPrice());
        xBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    shirt.setSize(Size.X);
                }
            }
        });
        lBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    shirt.setSize(Size.L);
                }
            }
        });
        xlBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    shirt.setSize(Size.XL);
                }
            }
        });
        sBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                shirt.setSize(Size.S);
            }
        });
        addToBagBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_detail_add_to_bag:
                sendItemDetail();
                break;
        }
    }

    private void sendItemDetail() {
        Intent intent = new Intent(this, ActivityItemList.class);
        if (shirt.getSize() == null) {
            shirt.setSize(Size.X);
        }
boolean duplicate = false;
        if(shirts.size() > 0){
            for(Shirt item_in_list:shirts){
                if(item_in_list.getId() == shirt.getId()){
                    int newQuantity = item_in_list.getQuantity() + 1;
                    item_in_list.setQuantity(newQuantity);
                    duplicate = true;
                    break;
                }
            }

        }
        if(duplicate == false){
            shirts.add(shirt);
        }
        ItemAPI.getInstance().setShirtList(shirts);
        Log.d("LIST", "sendItemDetail: " +  shirts.toString());
        startActivity(intent);
    }

    private void addEvents() {
    }
}