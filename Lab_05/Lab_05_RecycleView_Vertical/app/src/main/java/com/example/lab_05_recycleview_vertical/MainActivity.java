package com.example.lab_05_recycleview_vertical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvProducts;
    private List<Product> products;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvProducts = findViewById(R.id.rcvProducts);
        products = ProductList.getProducts();

        productAdapter = new ProductAdapter(MainActivity.this, products);

        rcvProducts.setAdapter(productAdapter);
        rcvProducts.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));

    }
}