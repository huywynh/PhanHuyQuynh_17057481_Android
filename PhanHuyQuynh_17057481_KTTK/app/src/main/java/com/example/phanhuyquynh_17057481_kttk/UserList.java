package com.example.phanhuyquynh_17057481_kttk;

import java.util.List;

public class UserList {
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public UserList(List<User> users) {
        this.users = users;
    }
}
