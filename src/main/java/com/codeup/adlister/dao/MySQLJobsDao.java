package com.codeup.adlister.dao;

import com.codeup.adlister.controllers.Config;
import com.codeup.adlister.models.Job;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
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
            String insertQuery = "INSERT INTO Jobs(user_id, title, description, job_cat) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, job.getUser_id());
            stmt.setString(2, job.getTitle());
            stmt.setString(3, job.getDescription());
            stmt.setString(4, job.getJob_cat());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new job.", e);
        }
    }
//
//    @Override
//    public List<Job> userAll(long userId) {
//        return null;
//    }
//
//    @Override
//    public void userDelete(int id) {
//
//    }

//
//    @Override
//    public Object getCategories() {
//        return null;
//    }
//
//    @Override
//    public Object search(String query) {
//        return null;
//    }
////
//    @Override
//    public List<Job> searchCat(int query) {
//        return null;
//    }


    private Job extractJob(ResultSet rs) throws SQLException {
        return new Job(
                rs.getInt("j.id"),
                rs.getInt("j.user_id"),
                rs.getString("u.rest_name"),
                rs.getString("j.title"),
                rs.getString("j.description"),
                rs.getString("j.job_cat")
        );
    }

    private List<Job> createJobsFromResults(ResultSet rs) throws SQLException {
        List<Job> jobs = new ArrayList<>();
        while (rs.next()) {
            jobs.add(extractJob(rs));
        }
        return jobs;
    }

    @Override
    public List<Job> search(String searchQuery) {
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT * FROM jobs j JOIN users u ON u.id = j.user_id WHERE " +
                    "j.title LIKE ? or u.rest_name LIKE ?" +
                    " or u.rest_cat LIKE ? or j.job_cat LIKE ? or j.description LIKE ?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%" + searchQuery + "%");
            stmt.setString(2, "%" + searchQuery + "%");
            stmt.setString(3, "%" + searchQuery + "%");
            stmt.setString(4, "%" + searchQuery + "%");
            stmt.setString(5, "%" + searchQuery + "%");



            ResultSet rs = stmt.executeQuery();
            return createJobsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ads.", e);
        }
    }


    @Override
//    public List<Job> searchCat(int query) {
//        PreparedStatement stmt = null;
//        try {
//            String sql = "SELECT * FROM jobs WHERE category = ?";
//            stmt = connection.prepareStatement(sql);
//            stmt.setInt(1, query);
//            ResultSet rs = stmt.executeQuery();
//            return createJobsFromResults(rs);
//        } catch (SQLException e) {
//            throw new RuntimeException("Error retrieving ads.", e);
//        }
//    }

//@Override
    public List<Job> FindJobsByUserID(int userId) {
        // used to display user ads on user profile
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM Jobs j JOIN Users u ON u.id = j.user_id WHERE u.id = ?");
            stmt.setLong(1, userId);
            ResultSet rs = stmt.executeQuery();
            return createJobsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving your ads");
        }
    }

    @Override
    public HashMap<Integer, String> getCategories(){
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM categories");
            ResultSet rs = stmt.executeQuery();
            HashMap<Integer, String> toReturn = new HashMap<>();
            while(rs.next()){
                toReturn.put(rs.getInt(1), rs.getString(2));
            }
            return toReturn;
        } catch (SQLException e) {
            throw new RuntimeException("Error finding categories");
        }
    }

    @Override
    public void userDelete(int id) { //allow user to delete ads from his profile page
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("DELETE FROM jobs where id = ?");
            stmt.setLong(1,id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting this ad");
        }
    }

    public List<Job> userList() {
        return null;
    }

//    private Job extractJob(ResultSet rs) {
//        try {
//            return new Job(
//                    rs.getInt("id"),
//                    rs.getInt("user_id"),
//                    rs.getString("title"),
//                    rs.getString("description")
//            );
//
//        } catch (SQLException e) {
//            throw new RuntimeException("Error in extractAd", e);
//        }
//    @Override


    public Job singleJob(int JobId) {
        PreparedStatement stmt = null;
        Job job= null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM Jobs j JOIN Users u ON u.id = j.user_id WHERE j.id = ?");
            stmt.setLong(1, JobId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                job = extractJob(rs);
            }
            return job;
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving Job.", e);
        }
    }
}
