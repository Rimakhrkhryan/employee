package com.synisys.service;

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
 * Created by rima.khrkhryan on 4/12/2018.
 */


/**
 * saved in employees table all data of tmp table with help flag
 */
@WebServlet("/save")
public class Save extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Dao dao = new Dao();
        try {
            List<Employee> employees = dao.loadUsers("tmp");
            for (Employee employee : employees) {
                if (employee.getFlag().equals("add")) {
                    employee.setFlag("old");
                    dao.save(employee, "employees");
                } else if (employee.getFlag().equals("delete")) {
                    dao.deleteUser(employee.getId(), "employees");
                }
            }
            dao.deleteTable("tmp");
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
