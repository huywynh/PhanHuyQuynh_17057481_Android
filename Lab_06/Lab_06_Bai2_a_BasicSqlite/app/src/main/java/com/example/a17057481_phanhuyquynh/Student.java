package com.example.a17057481_phanhuyquynh;

import java.util.List;

public class Student  {
    int id;
    String name;

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


    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

}
