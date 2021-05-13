package com.example.lab_05_recycleview_horizontalvertical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvDevices;
    private List<Device> devices;
    private DeviceAdapter deviceAdapter;

    private RecyclerView rcvBooks;
    private List<Book> books;
    private BookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvDevices = findViewById(R.id.rcvDevices);
        devices  = DataList.getDevices();
        deviceAdapter = new DeviceAdapter(MainActivity.this, devices);
        rcvDevices.setAdapter(deviceAdapter);
        rcvDevices.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.HORIZONTAL, false));

        rcvBooks = findViewById(R.id.rcvBooks);
        books = DataList.getBooks();
        bookAdapter = new BookAdapter(MainActivity.this, books);
        rcvBooks.setAdapter(bookAdapter);
        rcvBooks.setLayoutManager(new GridLayoutManager(MainActivity.this, 2, RecyclerView.HORIZONTAL, false));

    }
}