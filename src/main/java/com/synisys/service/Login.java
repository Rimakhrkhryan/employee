package com.synisys.service;

import com.synisys.model.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by rima.khrkhryan on 3/20/2018.
 */
@WebServlet("/ErrorHandler")
public class Login extends HttpServlet {
    int count = 0;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie position;
        response.setContentType("text/html");
        String requestUserName = request.getParameter("userName");
        String requestPassword = request.getParameter("password");
        Admin admin  = new Admin();
        if (requestUserName.equals(admin.getUserName()) && requestPassword.equals(admin.getPassword())){
                position = new Cookie("login", "Admin");
                position.setMaxAge(24 * 60 * 60);
                response.addCookie(position);
               response.sendRedirect("/portfolio.jsp");
        }
        else if (count < 3 ){
            response.sendRedirect("index.jsp");
        } else {
            request.getRequestDispatcher("/ErrorPage.jsp").forward(request, response);
        }
        count++;
    }

}
