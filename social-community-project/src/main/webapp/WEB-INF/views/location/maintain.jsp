<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 5/26/2022
  Time: 5:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>maintain</title>
    <link href="${pageContext.request.contextPath}/vendor/bootstrap/bootstrap.css" rel="stylesheet"/>

</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Location Name</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="location" items="${locaitonList}">
        <tr>
            <td class="td">${location.getId()}</td>
            <td class="td">${location.getLocationName()}</td>
        </tr>
    </c:forEach>


    </tbody>
</table>
</body>
</html>
