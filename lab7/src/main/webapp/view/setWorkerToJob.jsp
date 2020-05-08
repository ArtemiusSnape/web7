<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 3/27/2020
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Set Worker To Job</title>
    <link href="http://localhost:8080/lab5_war_exploded/view/styles.css" rel="stylesheet">
</head>
<body>
<form  class="page-form" id="set-worker-to-job" method = "POST">
    Worker id: <input type = "number" min="1" name = "worker_id">
    Request id: <input type = "number" min="1" name = "request_id">
    <input type = "submit" value = "Submit" />
</form>
</body>
</html>
