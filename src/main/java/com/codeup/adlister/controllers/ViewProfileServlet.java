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

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int UserID = Integer.parseInt(request.getParameter("id"));
        User user = DaoFactory.getUsersDao().findByID(UserID);
        request.setAttribute("user", user );
        System.out.println(user.getEmail());
        List<Job> jobs = DaoFactory.getJobsDao().FindJobsByUserID((int)user.getId());
        request.setAttribute("jobs", jobs);
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }

}
