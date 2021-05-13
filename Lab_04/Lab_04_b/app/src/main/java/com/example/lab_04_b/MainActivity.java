package com.example.lab_04_b;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView grvThing;
    ArrayList<ElectricThing> arrayList;
    CustomAdapter ctAdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grvThing = findViewById(R.id.grvThing);

        arrayList = new ArrayList<>();
        arrayList.add(new ElectricThing("Cáp chuyển từ Cổng USB sang PS2...", 5,
                10000, 15, R.drawable.giacchuyen,30 ));
        arrayList.add(new ElectricThing("Cáp chuyển từ Cổng USB sang PS2...", 3,
                10000, 15, R.drawable.daynguon,20 ));

        arrayList.add(new ElectricThing("Cáp chuyển từ Cổng USB sang PS2...", 5,
                10000, 15, R.drawable.dauchuyendoipsps,10 ));

        arrayList.add(new ElectricThing("Cáp chuyển từ Cổng USB sang PS2...", 4,
                10000, 15, R.drawable.daucam,15 ));

        arrayList.add(new ElectricThing("Cáp chuyển từ Cổng USB sang PS2...", 2,
                10000, 15, R.drawable.daynguon,18 ));

        arrayList.add(new ElectricThing("Cáp chuyển từ Cổng USB sang PS2...", 1,
                10000, 15, R.drawable.giacchuyen,40 ));


        ctAdt = new CustomAdapter(MainActivity.this, R.layout.item_gridview, arrayList);

        grvThing.setAdapter(ctAdt);


    }
}