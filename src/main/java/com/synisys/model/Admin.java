package com.synisys.model;


/**
 * Created by rima.khrkhryan on 4/12/2018.
 */

public class Admin {
    private String userName;
    private String password;

    public Admin() {
        password = "admin";
        userName = "admin";
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
