package com.example.middle_term_nhom_t5.Model;

import java.io.Serializable;

public class Shirt implements Serializable {
    private int id;
    private String name;
    private double price;
    private int imgRes;
    private Size size;
    private int quantity;
    private double totalMoney;

    public Shirt() {
    }

    public Shirt(int id, String name, double price, int imgRes) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imgRes = imgRes;
    }

    public Shirt(int id, String name, double price, int imgRes, Size size) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imgRes = imgRes;
        this.size = size;
    }

    public Shirt(int id, String name, double price, int imgRes, Size size, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imgRes = imgRes;
        this.size = size;
        this.quantity = quantity;
    }

    public Shirt(int id, String name, double price, int imgRes, Size size, int quantity, double totalMoney) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imgRes = imgRes;
        this.size = size;
        this.quantity = quantity;
        this.totalMoney = totalMoney;
    }

    public Shirt(String name, double price, int imgRes) {
        this.name = name;
        this.price = price;
        this.imgRes = imgRes;
    }

    @Override
    public String toString() {
        return "Shirt{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", imgRes=" + imgRes +
                ", size=" + size +
                ", quantity=" + quantity +
                ", totalMoney=" + totalMoney +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalMoney() {
        return this.price*this.quantity;
    }

}
