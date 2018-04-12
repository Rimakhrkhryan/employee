package com.synisys.service;

import com.synisys.model.Admin;
import com.synisys.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by rima.khrkhryan on 4/12/2018.
 */
public class Delete extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        for (Employee employee: Admin.employees) {
            if(employee.getId() ==Integer.parseInt (request.getParameter("id"))){
                Admin.employees.remove(employee);
                response.sendRedirect("/portfolio.jsp");
                return;
            }
        }
    }
}
