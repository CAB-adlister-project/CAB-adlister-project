package com.codeup.adlister.dao;

import com.codeup.adlister.models.Job;

import java.util.HashMap;
import java.util.List;

public abstract class ListJobsDao implements Jobs {
    private List<Job> jobs;

    public List<Job> all() {
        if (jobs == null) {
//            jobs = generateJobs();
        }
        return jobs;
    }

    public int insert(Job job) {
        // make sure we have jobs
        if (jobs == null) {
//            jobs = generateJobs();
        }
        // we'll assign an "id" here based on the size of the jobs list
        // really the dao would handle this
        job.setId((int) jobs.size());
        jobs.add(job);
        return job.getId();
    }
    @Override
    public List<Job> search(String searchQuery){return null;}
//
//    @Override
//    public List<Job> userAll(long userId) {
//        return null;
//    }

    @Override
    public void userDelete(int id){}


    @Override
    public Job singleJob(int jobId) {
        return null;
    }

    @Override
    public HashMap<Integer, String> getCategories() {return null;}

//    @Override
//    public List<Job> searchCat(int query){return null;}



}

