package com.codeup.adlister.dao;

import com.codeup.adlister.controllers.Config;
import com.codeup.adlister.models.Job;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Jobs {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }



    @Override
    public List<Job> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM Jobs");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all Jobs.", e);
        }
    }

    @Override
    public Long insert(Job job) {
        try {
            String insertQuery = "INSERT INTO Jobs(user_id, title, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, job.getUserId());
            stmt.setString(2, job.getTitle());
            stmt.setString(3, job.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new job.", e);
        }
    }

    private Job extractAd(ResultSet rs) throws SQLException {
        return new Job(
            rs.getLong("id"),
            rs.getLong("rest_id"),
            rs.getString("title"),
            rs.getString("description")
        );
    }

    private List<Job> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Job> jobs = new ArrayList<>();
        while (rs.next()) {
            jobs.add(extractAd(rs));
        }
        return jobs;
    }
}
