package com.codeup.adlister.dao;

import com.codeup.adlister.controllers.Config;
import com.codeup.adlister.models.Job;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLJobsDao implements Jobs {
    private Connection connection = null;

    public MySQLJobsDao(Config config) {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
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
            stmt = connection.prepareStatement("SELECT * FROM Jobs j JOIN Users u ON u.id = j.user_id");
            ResultSet rs = stmt.executeQuery();
            return createJobsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all Jobs.", e);
        }
    }

    @Override
    public int insert(Job job) {
        try {
            String insertQuery = "INSERT INTO Jobs(user_id, title, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, job.getUser_id());
            stmt.setString(2, job.getTitle());
            stmt.setString(3, job.getDescription());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new job.", e);
        }
    }


    private Job extractJob(ResultSet rs) throws SQLException {
        return new Job(
                rs.getInt("id"),
                rs.getString("rest_name"),
                rs.getString("title"),
                rs.getString("description")
        );
    }

    private List<Job> createJobsFromResults(ResultSet rs) throws SQLException {
        List<Job> jobs = new ArrayList<>();
        while (rs.next()) {
            jobs.add(extractJob(rs));
        }
        return jobs;
    }
}
