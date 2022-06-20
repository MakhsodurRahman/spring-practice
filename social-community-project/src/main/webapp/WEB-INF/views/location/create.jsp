<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 5/24/2022
  Time: 10:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>location</title>
    <link  href="${pageContext.request.contextPath}/vendor/bootstrap/bootstrap.css" rel="stylesheet" >
</head>
<body>
    <div>
        <form:form action="${pageContext.request.contextPath}/store" method="post" modelAttribute="location">

            <div class="d-flex justify-content-center ">
                <label >Location : </label>
                <form:input path="locationName"/>

                <input type="submit" value="Save">
            </div>

        </form:form>
    </div>
</body>
</html>
