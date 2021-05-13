package com.example.midterm_t6_10_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private TextView tvName,tvGia;
    private ImageView imgDonut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_portrait);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String gia = intent.getStringExtra("gia");
        int img=intent.getIntExtra("img",0);
        tvName=findViewById(R.id.tvName1);
        imgDonut=findViewById(R.id.imgDetail);
        tvGia = findViewById(R.id.tvGia);
        tvName.setText(name);
        imgDonut.setImageResource(img);
        tvGia.setText(gia);
    }
}