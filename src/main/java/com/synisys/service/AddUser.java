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
public class AddUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("hello");
        Employee employee = new Employee();
        employee.setName(request.getParameter("name"));
        employee.setLastName(request.getParameter("lastName"));
        employee.setAddress(request.getParameter("address"));
        employee.setJobTitle(request.getParameter("jobTitle"));
        employee.setId((int)(Math.random()*100));
        Admin.newEmployees.add(employee);
//        Admin.newEmployees.add(employee);
        response.sendRedirect("/portfolio.jsp");
    }
}
