<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 3/27/2020
  Time: 11:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>${pageName}</title>
    <link href="http://localhost:8080/lab5_war_exploded/view/styles.css" rel="stylesheet">
</head>
<body>
<h3>${pageName}</h3>

<p style="color: red;">${errorString}</p>

<table border="1" cellpadding="5" cellspacing="1" style="border-collapse: collapse">
    <tr>
        <th>ID</th>
        <th>Type</th>
        <th>Description</th>
        <th>Deadline</th>
        <th>Status</th>
    </tr>

    <c:forEach items="${requestsList}" var="request" >

        <tr>
                <td>${request.request_id}</td>
                <td>${request.job_type}</td>
                <td>${request.job_descr}</td>
                <td>${request.to_date}</td>
                <td>${request.status}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
