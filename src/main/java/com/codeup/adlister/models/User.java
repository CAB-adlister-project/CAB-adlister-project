package com.codeup.adlister.models;

import com.codeup.adlister.util.Password;

public class User {
    private long id;
    private String username;
    private String email;
    private String rest_name;
    private String rest_cat;
    private String password;

    public User() {}

    public User(String username, String email, String rest_name, String rest_cat, String password) {
        this.username = username;
        this.email = email;
        this.rest_name = rest_name;
        this.rest_cat = rest_cat;
        setPassword(password);
    }

    public User(long id, String username, String email, String rest_name, String rest_cat, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.rest_name = rest_name;
        this.rest_cat = rest_cat;
        this.password = password;
    }

    public String getRest_cat() {
        return rest_cat;
    }

    public void setRest_cat(String rest_cat) {
        this.rest_cat = rest_cat;
    }

    public String getRest_name() {
        return rest_name;
    }

    public void setRest_name(String rest_name) {
        this.rest_name = rest_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = Password.hash(password);
    }
}
