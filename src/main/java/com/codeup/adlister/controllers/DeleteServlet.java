
package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/jobs");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        String id = request.getParameter("id");
        DaoFactory.getJobsDao().userDelete(Integer.valueOf(id));
        if(request.getHeader("Referer").contains("show")){
            response.sendRedirect("/jobs");
        } else {
            response.sendRedirect(request.getHeader("Referer"));
        }
    }
}