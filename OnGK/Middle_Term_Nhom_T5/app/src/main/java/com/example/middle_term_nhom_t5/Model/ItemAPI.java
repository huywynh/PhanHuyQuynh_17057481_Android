package com.example.middle_term_nhom_t5.Model;

import android.app.Application;

import java.util.List;

public class ItemAPI extends Application {
    private List<Shirt> shirtList;
    private static ItemAPI instance;

    public ItemAPI() {
    }

    public ItemAPI(List<Shirt> shirtList) {
        this.shirtList = shirtList;
    }

    public List<Shirt> getShirtList() {
        return shirtList;
    }

    public void setShirtList(List<Shirt> shirtList) {
        this.shirtList = shirtList;
    }

    public static ItemAPI getInstance() {
        if (instance == null) {
            instance = new ItemAPI();
        }
        return instance;
    }
}
