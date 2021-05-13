package com.example.lab_05_recycleview_horizontalvertical;

public class Device {


    private Integer id;
    private  int image;
    private String name;
    private int rate;
    private int rateNumber;
    private double price;
    private int discount;

    public Device(){

    }

    public Device(Integer id, String name, int rate, int rateNumber, double price, int discount, int image) {
        this.id = id;
        this.name = name;
        this.rate = rate;
        this.rateNumber = rateNumber;
        this.price = price;
        this.discount = discount;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getRateNumber() {
        return rateNumber;
    }

    public void setRateNumber(int rateNumber) {
        this.rateNumber = rateNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
