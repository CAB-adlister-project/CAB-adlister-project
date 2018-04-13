package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {

            response.sendRedirect("/profile");
            return;
        }

        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        // validate input
        boolean inputHasErrors = false;

        //create a list of possible errors and responses
        ArrayList<String> errors = new ArrayList<>();

        //sets the checks for register form / add more features

        if (username.isEmpty()||password.isEmpty()) {
            errors.add("Username or password must not be empty.");
            inputHasErrors = true;
        }

        if (inputHasErrors) {
            request.getSession().setAttribute("errors", errors);
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }

        User user = DaoFactory.getUsersDao().findByUsername(username);
        if (user == null) {

            response.sendRedirect("/login");
            return;
        }

        boolean validAttempt = Password.check(password, user.getPassword());
        if (validAttempt) {
            request.getSession().setAttribute("user", user);

            response.sendRedirect("/jobs");
            return;

        } else {

            response.sendRedirect("/login");
            return;
        }
    }
}