package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.Jobs;
import com.codeup.adlister.models.Job;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.JobsIndexServlet", urlPatterns = "/jobs")
public class JobsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Job> jobs = DaoFactory.getJobsDao().all();
        request.setAttribute("jobs", DaoFactory.getJobsDao().all());
        request.getRequestDispatcher("/WEB-INF/Jobs/index.jsp").forward(request, response);
    }
}
