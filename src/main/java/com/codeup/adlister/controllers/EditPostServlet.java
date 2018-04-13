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

@WebServlet(name = "EditPostServlet", urlPatterns ="/editPost")
public class EditPostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            User user = (User) request.getSession().getAttribute("user");
            Job job = new Job(
                    (int) user.getId(),
                    request.getParameter("rest_name"),
                    request.getParameter("title"),
                    request.getParameter("description")
            );
            DaoFactory.getJobsDao().insert(job);
            response.sendRedirect("/profile");
        }
    }
