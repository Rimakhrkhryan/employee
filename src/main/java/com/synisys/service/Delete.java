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

/**
 * Created by rima.khrkhryan on 4/12/2018.
 */
@WebServlet("/delete")
/**
 * add employyee in tmp table whit flag of "delete"
 */
public class Delete extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            StringBuilder sb = new StringBuilder();
            String s;
            while ((s = request.getReader().readLine()) != null) {
                sb.append(s);
            }
            ObjectMapper mapper = new ObjectMapper();
            Employee employee = mapper.readValue(sb.toString(), Employee.class);
            employee.setFlag("delete");
            Dao dao = new Dao();
            try {
                dao.save(employee, "tmp");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        response.sendRedirect("/portfolio.jsp");
    }
}
