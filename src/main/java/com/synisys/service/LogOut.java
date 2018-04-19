package com.synisys.service;

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
@WebServlet("/logout")

/**
 * log out whit cleaning all cookes
 */
public class LogOut extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookies[] = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie killMyCookie = new Cookie(cookies[i].getName(), null);
                killMyCookie.setMaxAge(0);
                killMyCookie.setPath("/");
                response.addCookie(killMyCookie);
            }
        }
        response.sendRedirect("/index.jsp");
    }


}
