package com.example.lab_05_recycleview_vertical;

import java.util.ArrayList;
import java.util.List;

public class ProductList {

    private static List<Product> products = new ArrayList<>();
    private static ProductList instance;

    private  ProductList(){

        products.add(new Product(1, "Cáp chuyển từ cổng USB sang PS2", 4, 15, 70000, 39, R.drawable.sp1 ));
        products.add(new Product(2, "Cáp chuyển từ cổng USB sang PS2", 4, 15, 70000, 39, R.drawable.sp2 ));
        products.add(new Product(3, "Cáp chuyển từ cổng USB sang PS2", 4, 15, 70000, 39, R.drawable.sp3 ));
        products.add(new Product(4, "Cáp chuyển từ cổng USB sang PS2", 4, 15, 70000, 39, R.drawable.sp4 ));
        products.add(new Product(5, "Cáp chuyển từ cổng USB sang PS2", 4, 15, 70000, 39, R.drawable.sp5 ));
        products.add(new Product(6, "Cáp chuyển từ cổng USB sang PS2", 4, 15, 70000, 39, R.drawable.sp6 ));
    }

    public static List<Product> getProducts(){

        if(instance == null)
            instance = new ProductList();

        return products;
    }
}
