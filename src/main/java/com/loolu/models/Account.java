package com.loolu.models;

public class Account {
    private String email;
    private  String password;
    private  String firstname;
    private  String lastname;
    private  String username;



    public Account setEmail(String email) {
        this.email = email;
        return this;
    }

    public Account setPassword(String password) {
        this.password = password;
        return this;
    }

    public Account setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public Account setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public Account setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }
}
