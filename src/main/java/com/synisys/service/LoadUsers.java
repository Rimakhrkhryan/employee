package com.synisys.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.synisys.dao.Dao;
import com.synisys.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by rima.khrkhryan on 4/17/2018.
 */
@WebServlet("/loadUsers")
/**
 * load employees from tables of db
 */
public class LoadUsers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        Dao dao = new Dao();
        try {
            List<Employee> employees = dao.loadUsers("employees");
            List<Employee> tmpEmployees = dao.loadUsers("tmp");
            employees.addAll(tmpEmployees);
            ObjectMapper mapper = new ObjectMapper();
            response.setContentType("application/json");
            response.getWriter().write(mapper.writeValueAsString(employees));


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }
}
