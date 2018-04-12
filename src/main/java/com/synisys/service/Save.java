package com.synisys.service;

import com.synisys.dao.Dao;
import com.synisys.model.Admin;
import com.synisys.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by rima.khrkhryan on 4/12/2018.
 */
public class Save extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {


        try {
            for (Employee currentEmployee : Admin.newEmployees) {
                Admin.employees.add(currentEmployee);
            }
            Dao dao = new Dao();
            dao.save(Admin.employees);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        Admin.newEmployees = new ArrayList<Employee>();
        response.sendRedirect("/portfolio.jsp");
    }
}
