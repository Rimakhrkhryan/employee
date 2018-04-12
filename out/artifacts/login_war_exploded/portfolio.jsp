<%@ page import="com.synisys.model.Employee" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.synisys.model.Admin" %>


<%--
  Created by IntelliJ IDEA.
  User: rima.khrkhryan
  Date: 4/11/2018
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Portfolio</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

<jsp:useBean id="dao" class="com.synisys.dao.Dao"/>
<jsp:useBean id="employee" class="com.synisys.model.Employee"/>


<%!

    public String drawTable(List<Employee> employees) {
        String context = "<table><tr> <th>Id</th><th>Name</th><th>Last Name</th> <th>Address</th><th>Job Title</th></tr>";
        for (Employee currentEmployee : employees) {
            context += "<tr><td>" + currentEmployee.getId()+"</td><td>" +currentEmployee.getName() + "</td><td>" + currentEmployee.getLastName() +
                    "</td><td>" + currentEmployee.getAddress() + "</td><td>" + currentEmployee.getJobTitle() + "</td></tr>";
        }
        context += "</table>";
        return context;
    }
%>


<form action="/registerNewEmployee.jsp" method="POST">
    <input type="submit" value="Add Employee"/>
</form>
<br>
<form action="/delete" method="POST">
    <p>
        Enter deleted user id
    </p>
    <input type="number" name="id">
    <input type="submit" value="Delete User"/>
</form>
<br>
<form action = "/save" method="POST">
    <input type="submit"value="Save"/>
</form>
<form action="/logout" method="GET">
    <input type="submit" value="logout"/>
</form>


<h2>
    Employees
</h2>
<%
    out.print(drawTable(Admin.employees));
%>
<h2>
    New Employees
</h2>
<%
    out.print(drawTable(Admin.newEmployees));
%>
</body>
</html>
