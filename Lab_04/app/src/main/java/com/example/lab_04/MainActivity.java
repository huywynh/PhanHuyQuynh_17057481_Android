package com.example.lab_04;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements SendingData{

    TextView tvThanhTienMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvThanhTienMain = findViewById(R.id.tvThanhTienMain);
        //DecimalFormat
        getSupportFragmentManager().beginTransaction().add(R.id.frmContainerBelow, BelowFragment.newInstance("1")).commit();

    }

    @Override
    public void SendData(String sendData) {
        Toast.makeText(this, sendData, Toast.LENGTH_SHORT).show();
        getSupportFragmentManager().beginTransaction().replace(R.id.frmContainerBelow, BelowFragment.newInstance(sendData)).commit();
    }


}