package com.example.phanhuyquynh_17057481_kttk;

public class User {
    private int id;
    private String name;
    private int tuoi;

    public User(int id, String name, int tuoi) {
        this.id = id;
        this.name = name;
        this.tuoi = tuoi;
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

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tuoi=" + tuoi +
                '}';
    }
}
