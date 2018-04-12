package com.codeup.adlister.dao;

import com.codeup.adlister.models.Job;

import java.util.List;

public interface Jobs {
    // get a list of all the ads
    List<Job> all();
    // insert a new job and return the new job's id
    int insert(Job job);

//    List<Job> userAll(long userId);

    List<Job> FindJobsByUserID(int id);

    void userDelete(int id);

    Job singleJob(int adId);

    Object getCategories();

    Object search(String query);

//    List<Job> searchCat(int query);
}
