<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 3/27/2020
  Time: 2:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Tenants List</title>
    <link href="http://localhost:8080/lab5_war_exploded/view/styles.css" rel="stylesheet">
</head>
<body>
<h3>Tenants List</h3>

<p style="color: red;">${errorString}</p>

<table border="1" cellpadding="5" cellspacing="1" style="border-collapse: collapse">
    <tr>
        <th>ID</th>
        <th>Name</th>

    </tr>

    <c:forEach items="${tenantsList}" var="tenant" >

        <tr>
            <td>${tenant.tenant_id}</td>
            <td>${tenant.tenant_name}</td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
