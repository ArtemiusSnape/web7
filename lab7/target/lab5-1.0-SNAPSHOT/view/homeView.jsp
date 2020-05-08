<%@ page import="model.entities.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Home Page</title>
        <link href="http://localhost:8080/lab5_war_exploded/view/styles.css" rel="stylesheet">
    </head>

    <body>
        <p  style="color: red;">${errorString}</p>
        <%User user = (User)session.getAttribute("user"); %>
        <%int userType = (user == null ? -1 : user.getUser_type()); %>
        <%if (userType == -1) {%>
            <h2>Home Page</h2>
        <%} else if (userType == 0) { %>
            <h2>User Page</h2>
        <%} else if (userType == 1) { %>
            <h2>Admin Page</h2>
        <%}%>
        <div >
            <%if (userType == -1) {%>
                <button class="return-button" onclick="location.href='${pageContext.request.contextPath}?command=login'">Login</button>
                <button class="return-button" onclick="location.href='${pageContext.request.contextPath}?command=registration'">Registration</button>
            <%} else {%>
                <button class="return-button" onclick="location.href='${pageContext.request.contextPath}?command=logout'">Log Out</button>

            <%}%>
        </div>
        <%if (userType >= 0) {%>
        <h3  class="info-box">Choose an option:</h3>
        <div class="numberlist">
            <ol>

                    <li><a href="${pageContext.request.contextPath}?command=requestsList">View list of requests</a></li>
                    <li><a href="${pageContext.request.contextPath}?command=workersList">View list of workers</a></li>

                    <li><a href="${pageContext.request.contextPath}?command=tenantsList">View list of tenants</a></li>
                    <li><a href="${pageContext.request.contextPath}?command=workPlansList">View list of work plans</a></li>
                <%}%>
                <%if (userType >= 1) {%>
                    <li><a href="${pageContext.request.contextPath}?command=setWorkerToJob">Set worker to job</a></li>
                    <li><a href="${pageContext.request.contextPath}?command=overdueRequests">Get overdue requests</a></li>
                    <li><a href="${pageContext.request.contextPath}?command=cancelRequest">Cancel request</a></li>
                <%}%>



            </ol>
        </div>
    </body>
</html>