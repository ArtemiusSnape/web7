<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 3/27/2020
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cancel Request</title>
    <link href="http://localhost:8080/lab5_war_exploded/view/styles.css" rel="stylesheet">
</head>
<body>
<form class="page-form" id="cancel-request" method = "POST">
    Request id: <input type = "number" min="1" name = "request_id">
    <input type = "submit" value = "Submit" />
</form>
</body>
</html>
