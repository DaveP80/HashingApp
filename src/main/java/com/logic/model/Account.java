package com.logic.model;

import java.io.Serializable;

public class Account implements Serializable {

    private int id;

    public String password;

    public Account(String password) { //useful constructor
        this.password = password;
    }

    public Account(int id, String password) {
        this.id = id;
        this.password = password;
    }

    public Account() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
