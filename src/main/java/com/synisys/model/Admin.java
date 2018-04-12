package com.synisys.model;


import com.synisys.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rima.khrkhryan on 4/12/2018.
 */
public class Admin {
   private String userName;
   private String password;
  public static  List<Employee> employees;
  public static  List<Employee> newEmployees;
    public Admin(){
        newEmployees = new ArrayList<Employee>();
        password = "admin";
        userName = "admin";
        Dao dao = new Dao();
        try {
            employees = dao.loadUsers();
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
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
