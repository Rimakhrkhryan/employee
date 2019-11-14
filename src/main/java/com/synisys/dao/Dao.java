package com.synisys.dao;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import com.synisys.model.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by rima.khrkhryan on 3/19/2018.
 */
public class Dao {

    public Connection getConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Driver driver = new SQLServerDriver();
        DriverManager.deregisterDriver(driver);
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = null;
        String uri = "jdbc:sqlserver://SIS4W002\\SQLEXPRESS:1433;databasename=employee;";
        conn = DriverManager.getConnection(uri, "rima", "root");
        return conn;
    }


    public List<Employee> loadUsers(String tableName) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        List<Employee> employees = new ArrayList<Employee>();
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * from " + tableName);
        while (result.next()) {
            Employee employee = new Employee();
            employee.setAddress(result.getString("address"));
            employee.setLastName(result.getString("lastName"));
            employee.setName(result.getString("name"));
            employee.setJobTitle(result.getString("JobTitle"));
            employee.setId(result.getInt("id"));
            employee.setFlag(result.getString("flag"));
            employees.add(employee);
        }
        stmt.close();
        return employees;
    }


    public void save(Employee employee, String tableName) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        String query = "INSERT INTO "+ tableName + " VALUES (?,?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        System.out.println(employee.getFlag());
        pstmt.setInt(1, employee.getId());
        pstmt.setString(2, employee.getName());
        pstmt.setString(3, employee.getLastName());
        pstmt.setString(4, employee.getAddress());
        pstmt.setString(5, employee.getJobTitle());
        pstmt.setString(6, employee.getFlag());
        pstmt.executeUpdate();
        statement.close();


    }

    public void deleteUser(int id, String tableName) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        PreparedStatement ps = conn.prepareStatement("DELETE  FROM " + tableName + " WHERE id=" + id);
        ps.executeUpdate();
        statement.close();
    }

    public void deleteTable(String tableName) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        PreparedStatement ps = conn.prepareStatement("DELETE  FROM  " + tableName);
        ps.executeUpdate();
        statement.close();
    }
}
