<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 4/8/2020
  Time: 7:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link href="http://localhost:8080/lab5_war_exploded/view/styles.css" rel="stylesheet">
</head>
<body>
<form  class="page-form" id="set-worker-to-job" method = "POST">
    Name: <input type = "text"  required="required" name = "name">
    Login: <input type = "text"  required="required" name = "login">
    Password: <input type = "password"  required="required" name = "password">
    Confirm password: <input type = "password"  required="required" name = "password_confirm">
    <input type = "submit" value = "Submit" />
</form>
<p style="color: red;">${errorString}</p>
</body>
</html>
