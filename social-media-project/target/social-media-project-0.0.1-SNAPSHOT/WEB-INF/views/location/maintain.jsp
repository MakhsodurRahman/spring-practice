<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 6/7/2022
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Location List</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/vendor/bootstrap/bootstrap.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="h-w">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Location Name</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="location" items="${locationList}">
                        <tr>
                            <td>${location.getId()}</td>
                            <td>${location.getLocationName()}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </div>

<style>
    .h-w{
        height: 300px;
        width: 500px;
        display: flex;
        align-content: center;
        align-items: center;
    }
</style>

</body>
</html>
