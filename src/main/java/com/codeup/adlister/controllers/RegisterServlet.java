package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Email;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }

        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String rest_name = request.getParameter("rest_name");
        String password = request.getParameter("password");
        String rest_cat = request.getParameter("rest_cat");
        String passwordConfirmation = request.getParameter("confirm_password");




        // validate input
        boolean inputHasErrors = false;

        //create a list of possible errors and responses
        ArrayList<String> listOfErrors = new ArrayList<>();

        //sets the checks for register form / add more features
        if (password.isEmpty()) {
            String passwordIsEmpty = "You must enter a password.";
            listOfErrors.add(passwordIsEmpty);
            inputHasErrors = true;
        }
        if (!password.equals(passwordConfirmation)) {
            String passwordDontMatch = "Your passwords don't match.";
            listOfErrors.add(passwordDontMatch);
            inputHasErrors = true;
        }
        if (email.isEmpty()) {
            String emailIsEmpty = "You must enter a valid email.";
            listOfErrors.add(emailIsEmpty);
            inputHasErrors = true;
        }
        if (username.isEmpty()) {
            String usernameIsEmpty = "You must enter an username.";
            listOfErrors.add(usernameIsEmpty);
            inputHasErrors = true;
        } else {
            User user = DaoFactory.getUsersDao().findByUsername(username);
            if (user != null) {
                listOfErrors.add("This username already exists");
                inputHasErrors = true;
            }
        }
        if(!Email.validate(email)) {
            String invalidEmail = "You have entered an invalid email format.";
            listOfErrors.add(invalidEmail);
            inputHasErrors = true;
        }
        if(!Password.validateLength(password)) {
            String invalidPassword = "Password must be minimum 6 characters long.";
            listOfErrors.add(invalidPassword);
            inputHasErrors = true;
        }
        if (rest_name.isEmpty()) {
            String rest_nameIsEmpty = "You must enter a restaurant name";
            listOfErrors.add(rest_nameIsEmpty);
            inputHasErrors = true;
        }

        if (rest_cat.equalsIgnoreCase("null")) {
            String rest_nameIsEmpty = "You must enter a restaurant category";
            listOfErrors.add(rest_nameIsEmpty);
            inputHasErrors = true;
        }

//        username has to have these parameters
//        input = valid if (only letter) || (only letter & numbers)
//        Pattern pattern = Pattern.compile("[A-Za-z]+[0-9]+");
//        boolean validUsername = username != null && pattern.matcher(username).matches();
//
//        if (!validUsername) {
//            String invalidUsername = "Username must contain letters and/or numbers only.";
//            listOfErrors.add(invalidUsername);
//            inputHasErrors = true;
//        }
//
//        User user = DaoFactory.getUsersDao().findByUsername(username);
//
//        if (validUsername) {
//            String usernameExists = "User already exists.";
//            listOfErrors.add(usernameExists);
//            inputHasErrors = true;
////        }

        //check for errors
        if (inputHasErrors) {
            request.getSession().setAttribute("listOfErrors", listOfErrors);
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else {
            //otherwise create and save a new user
            User user = new User(username, email, rest_name, rest_cat, password);
            DaoFactory.getUsersDao().insert(user);
            response.sendRedirect("/login");
        }
    }
}
