package com.example.lab_06_bai3_sqlite_custom_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Travel> listStudent;
    ListView lvStudent;
    TravelAdapter lvAdapter;
    String nameAdd;
    EditText plt;
    int iSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listStudent=new ArrayList<>();
        listStudent.add(new Travel(1, "Da Lat"));
        listStudent.add(new Travel(2, "Da Lat"));
        listStudent.add(new Travel(3, "Da Lat"));
        listStudent.add(new Travel(4, "Da Lat"));
        listStudent.add(new Travel(5, "Da Lat"));
        listStudent.add(new Travel(6, "Da Lat"));
        listStudent.add(new Travel(7, "Da Lat"));
        listStudent.add(new Travel(8, "Da Lat"));
        listStudent.add(new Travel(9, "Da Lat"));
        lvAdapter=new TravelAdapter(listStudent);

        lvStudent = findViewById(R.id.lvTravel);
        lvStudent.setAdapter(lvAdapter);

        lvStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Travel product = (Travel) lvAdapter.getItem(position);
                iSelect=position;
            }
        });

        plt=findViewById(R.id.txtTravel);
        findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameAdd=plt.getText().toString().trim();
                listStudent.add(new Travel(nameAdd));
                lvAdapter.notifyDataSetChanged();
            }
        });
    }
}