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
<script src="js/script.js"></script>
<h2>
    Employees
</h2>
<table id="oldEmployees">
</table>
<h2>
    New Employees
</h2>
<table id="newEmployees">

</table>


<form action="/registerNewEmployee.jsp" action = "POST">
<button id="add" >Add Employee</button>
</form>

<br>
<p>
    Enter deleted user id
</p>

<input type="number" name="id" id="deletedEmployeesId">

<button id="delete" onclick="deleteEmployee()">Delete Employee</button>

<br>

<button id="save" onclick="save()">Save</button>

<form action="/logout" method="GET">
    <input type="submit" value="logout"/>
</form>



</body>
</html>
