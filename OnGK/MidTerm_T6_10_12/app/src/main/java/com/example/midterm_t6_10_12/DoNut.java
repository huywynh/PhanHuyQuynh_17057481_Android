package com.example.midterm_t6_10_12;

public class DoNut {
    private String name, name1, name2;
    private int imgDonut, imgAdd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public int getImgDonut() {
        return imgDonut;
    }

    public void setImgDonut(int imgDonut) {
        this.imgDonut = imgDonut;
    }

    public int getImgAdd() {
        return imgAdd;
    }

    public void setImgAdd(int imgAdd) {
        this.imgAdd = imgAdd;
    }

    public DoNut(String name, String name1, String name2, int imgDonut, int imgAdd) {
        this.name = name;
        this.name1 = name1;
        this.name2 = name2;
        this.imgDonut = imgDonut;
        this.imgAdd = imgAdd;
    }
}
