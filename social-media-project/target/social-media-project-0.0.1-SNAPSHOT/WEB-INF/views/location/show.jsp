<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 6/7/2022
  Time: 11:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Locaiton</title>
</head>
<body>
    <h3> Location Id : ${location.getId()}</h3>
   <h4> Location Name : ${location.getLocationName()}</h4>

    <div class="mt-3">
        <h5 class="mt-2"><a href="${pageContext.request.contextPath}/location/create/">Back to Create Location</a></h5>
        <h5 class="mt-2"><a href="${pageContext.request.contextPath}/location/maintain/">Location List</a></h5>
    </div>
</body>
</html>
