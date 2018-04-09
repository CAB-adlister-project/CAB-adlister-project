package com.codeup.adlister.dao;

import com.codeup.adlister.models.Job;

import java.util.ArrayList;
import java.util.List;

public class ListJobsDao implements Jobs {
    private List<Job> jobs;

    public List<Job> all() {
        if (jobs == null) {
            jobs = generateAds();
        }
        return jobs;
    }

    public Long insert(Job job) {
        // make sure we have jobs
        if (jobs == null) {
            jobs = generateAds();
        }
        // we'll assign an "id" here based on the size of the jobs list
        // really the dao would handle this
        job.setId((long) jobs.size());
        jobs.add(job);
        return job.getId();
    }

    private List<Job> generateAds() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job(
            1,
            1,
            "playstation for sale",
            "This is a slightly used playstation"
        ));
        jobs.add(new Job(
            2,
            1,
            "Super Nintendo",
            "Get your game on with this old-school classic!"
        ));
        jobs.add(new Job(
            3,
            2,
            "Junior Java Developer Position",
            "Minimum 7 years of experience required. You will be working in the scripting language for Java, JavaScript"
        ));
        jobs.add(new Job(
            4,
            2,
            "JavaScript Developer needed",
            "Must have strong Java skills"
        ));
        return jobs;
    }
}
