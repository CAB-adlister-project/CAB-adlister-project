
package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.SearchServlet", urlPatterns = "/jobs/search")
public class SearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("searchQuery");
        request.setAttribute("jobs", DaoFactory.getJobsDao().search(query));
        request.getRequestDispatcher("/WEB-INF/Jobs/search.jsp").forward(request, response);
    }
}