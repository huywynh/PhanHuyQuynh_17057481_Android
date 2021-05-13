package com.example.a17057481_phanhuyquynh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private StudentAdapter adapter;
    private RecyclerView recyclerView;
    private DatabaseHandler databaseHandler;
    private List<Student> listStudentName = new ArrayList<>();

    private Button btnAdd;
    private TextView tvName;
    private Button btnRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHandler = new DatabaseHandler(this);
        // createListStudent();
        getListStudentName();
        addStudent();
        removeStudent();
        recyclerView = findViewById(R.id.rvListStudentName);
        adapter = new StudentAdapter(listStudentName, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void createListStudent() {
        databaseHandler.addStudent(new Student("Do quang vinh"));
        databaseHandler.addStudent(new Student("Do quang vinh"));
        databaseHandler.addStudent(new Student("Do quang vinh"));
        databaseHandler.addStudent(new Student("Do quang vinh"));
    }

    private void getListStudentName() {
        listStudentName = databaseHandler.getStudentName();
    }

    private void addStudent() {
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvName = findViewById(R.id.tvName);
                String name = String.valueOf(tvName.getText());
                databaseHandler.addStudentName(name);
                listStudentName = databaseHandler.getStudentName();
                recyclerView = findViewById(R.id.rvListStudentName);
                adapter = new StudentAdapter(listStudentName, MainActivity.this
                );
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);

                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(linearLayoutManager);
            }
        });
    }

    private void removeStudent() {
        btnRemove = findViewById(R.id.btnRemove);
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvName = findViewById(R.id.tvName);
                String name = String.valueOf(tvName.getText());
                databaseHandler.deleteStudent(name);
                recyclerView = findViewById(R.id.rvListStudentName);
                adapter = new StudentAdapter(listStudentName, MainActivity.this
                );
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);

                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(linearLayoutManager);
            }
        });
    }
}