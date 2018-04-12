<%--
  Created by IntelliJ IDEA.
  User: rima.khrkhryan
  Date: 4/11/2018
  Time: 4:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>
<form action="/addUser" method="POST">
    <div class="container">
        <h1>Sign Up</h1>
        <p>Please fill in this form to create an account.</p>
        <hr>

        <input type="text" placeholder="Enter name" name="name" required >
        <br><br>
        <input type="text" placeholder="Enter last name" name="lastName" required >
        <br><br>
        <input type="text" placeholder="Enter address" name="address" required >
        <br><br>
        <input type="text" placeholder="Enter Job Title" name="jobTitle" required>
        <br><br>
        <button type="submit" class="signupbtn">Add</button>
    </div>
</form>
</body>
</html>