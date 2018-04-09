package com.codeup.adlister.dao;

import com.codeup.adlister.controllers.Config;

public class DaoFactory {
    private static Jobs jobsDao;
    private static Users usersDao;
    private static Config config = new Config();

    public static Jobs getJobsDao() {
        if (jobsDao == null) {
            jobsDao = new MySQLAdsDao(config);
        }
        return jobsDao;
    }

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }
}
