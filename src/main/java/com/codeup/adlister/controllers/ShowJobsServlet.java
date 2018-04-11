package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowJobsServlet", urlPatterns ="/jobs/show")
public class ShowJobsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        int JobID = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("categories", DaoFactory.getJobsDao().getCategories());
        request.setAttribute("job", DaoFactory.getJobsDao().singleJob(JobID));
        request.getRequestDispatcher("/WEB-INF/jobs/show.jsp").forward(request, response);
    }
}
