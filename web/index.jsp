<%@ page import="com.synisys.dao.Dao" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  com.synisys.model.User: rima.khrkhryan
  Date: 3/15/2018
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>LogIn</title>
  </head>
  <body>
    <h2>LOGIN </h2>

    <form action="/portfolio" method="POST">
        First name:<br>
        <input type="text" name="userName" >
        <br>
        Last name:<br>
        <input type="password" name="password">
        <br><br>
        <input type="submit" value="Login">
    </form>


  </body>
</html>
