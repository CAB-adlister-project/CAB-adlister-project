package com.codeup.adlister.models;

public class Job {
    private int user_id;
    private int id;
    private String rest_name;
    private String title;
    private String description;

    public Job(int id,int user_id, String rest_name, String title, String description) {
        this.id = id;
        this.user_id = user_id;
        this.rest_name = rest_name;
        this.title = title;
        this.description = description;
    }

<<<<<<< HEAD
    public Job(long userId, String rest_name, String title, String description) {
        this.userId = userId;
=======
    public Job(int user_id, String rest_name, String title, String description) {
        this.user_id = user_id;
        this.rest_name = rest_name;
>>>>>>> 81b1c0c2edb7447620a9dedfb59b1240a02a35cd
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRest_name() {
        return rest_name;
    }

    public void setRest_name(String rest_name) {
        this.rest_name = rest_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
