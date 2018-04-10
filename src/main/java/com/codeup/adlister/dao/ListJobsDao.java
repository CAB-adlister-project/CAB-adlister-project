package com.codeup.adlister.dao;

import com.codeup.adlister.models.Job;

import java.util.ArrayList;
import java.util.List;

public class ListJobsDao implements Jobs {
    private List<Job> jobs;

    public List<Job> all() {
        if (jobs == null) {
            jobs = generateJobs();
        }
        return jobs;
    }

    public int insert(Job job) {
        // make sure we have jobs
        if (jobs == null) {
            jobs = generateJobs();
        }
        // we'll assign an "id" here based on the size of the jobs list
        // really the dao would handle this
        job.setId((int) jobs.size());
        jobs.add(job);
        return job.getId();
    }

    private List<Job> generateJobs() {
        List<Job> jobs = new ArrayList<>();
        return jobs;
    }
}
