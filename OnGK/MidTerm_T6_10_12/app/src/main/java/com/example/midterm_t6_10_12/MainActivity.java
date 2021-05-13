package com.example.midterm_t6_10_12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvDonut;
    private MyAdapter myAdapter;
    private List<DoNut> doNuts;
    private EditText search;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btnDonut);
        addControl();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search=findViewById(R.id.editSearch);
                String text = search.getText().toString();
                if(text.isEmpty()){
                    addControl();
                }else {
                    searchControl(text);
                }
            }
        });

    }
    public void addControl()
    {
        doNuts = loadData();
        myAdapter = new MyAdapter(this);
        myAdapter.setData(doNuts);
        rcvDonut = findViewById(R.id.rcDonut);
        rcvDonut.setAdapter(myAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        rcvDonut.setLayoutManager(new LinearLayoutManager(this));
    }
    public void searchControl(String name)
    {
        doNuts = search(name);
        myAdapter = new MyAdapter(this);
        myAdapter.setData(doNuts);
        rcvDonut = findViewById(R.id.rcDonut);
        rcvDonut.setAdapter(myAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        rcvDonut.setLayoutManager(new LinearLayoutManager(this));
    }
    public List<DoNut> loadData()
    {
        List<DoNut> doNuts = new ArrayList<>();
        doNuts.add(new DoNut("Tasty Donut","Spicy tasty donut family", "$10.00",R.drawable.donut_yellow_1, R.drawable.group_17));
        doNuts.add(new DoNut("Pink Donut","Spicy tasty donut family", "$20.00",R.drawable.pinkdonut, R.drawable.group_17));
        doNuts.add(new DoNut("Floating Donut","Spicy tasty donut family", "$30.00",R.drawable.green_donut, R.drawable.group_17));
        doNuts.add(new DoNut("Tasty Donut","Spicy tasty donut family", "$40.00",R.drawable.reddonut, R.drawable.group_17));
        return doNuts;
    }
    public  List<DoNut> search(String name){
        List<DoNut> list1= (List<DoNut>) loadData();
        List<DoNut> list2=new ArrayList<>();
        for (DoNut a : list1)
            if(a.getName().toLowerCase().contains(name.toLowerCase()))
                list2.add(a);

        return list2;
    }
}