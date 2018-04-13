package com.codeup.adlister.models;

public class Job {
    private int user_id;
    private int id;
    private String rest_name;
    private String title;
    private String description;
    private String job_cat;

    public Job(int id,int user_id, String rest_name, String title, String description, String job_cat) {
        this.id = id;
        this.user_id = user_id;
        this.rest_name = rest_name;
        this.title = title;
        this.description = description;
        this.job_cat = job_cat;
    }

    public Job(int user_id, String rest_name, String title, String description, String job_cat) {
        this.user_id = user_id;
        this.rest_name = rest_name;
        this.title = title;
        this.description = description;
        this.job_cat = job_cat;
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

    public String getJob_cat() {
        return job_cat;
    }

    public void setJob_cat(String job_cat) {
        this.job_cat = job_cat;
    }
}
