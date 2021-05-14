package com.example.bai_1_room_db_basic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Person> list = new ArrayList<>();
    PersonAdapter adapter;
    Button btnAdd;
    Button btnRemove;
    Button btnCancel;
    EditText editPutName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        list = ConnectDB.getInstance(MainActivity.this).personDAO().getAllPersons();
        adapter = new PersonAdapter(this,list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(adapter);
        btnAdd = findViewById(R.id.btnAdd);
        editPutName = findViewById(R.id.editPutName);
        btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editPutName.setText("");
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editPutName.getText().toString();
                ConnectDB.getInstance(MainActivity.this).personDAO().addPerson(new Person(name));
                list = ConnectDB.getInstance(MainActivity.this).personDAO().getAllPersons();
                adapter = new PersonAdapter(MainActivity.this,list);
                recyclerView.setAdapter(adapter);
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);
            }
        });
    }
}