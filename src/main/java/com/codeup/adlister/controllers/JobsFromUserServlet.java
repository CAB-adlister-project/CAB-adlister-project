package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Job;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "JobsFromUserServlet", urlPatterns = "/jobs/alljobs")
public class JobsFromUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("id")!=null){
            int userId = Integer.parseInt(request.getParameter("id"));
            List<Job> jobs = DaoFactory.getJobsDao().FindJobsByUserID(userId);
            request.setAttribute("jobs", jobs);
            User user = DaoFactory.getUsersDao().findByID(userId);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/WEB-INF/alljobs.jsp").forward(request, response);
            return;
        }
    }
}
