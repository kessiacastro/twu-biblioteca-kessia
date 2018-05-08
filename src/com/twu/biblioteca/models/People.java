package com.twu.biblioteca.models;

public class People {

    private String name;
    private String email;
    private String address;
    private String phone;
    private String type;
    private String password;

    public People(String name, String email, String address, String phone, String type, String password) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.type = type;
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getType() {
        return this.type;
    }

    public String getPassword() {
        return this.password;
    }
}
