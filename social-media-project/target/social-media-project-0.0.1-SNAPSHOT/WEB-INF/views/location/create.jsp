<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 6/7/2022
  Time: 11:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>location</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/vendor/bootstrap/bootstrap.css" rel="stylesheet">
</head>
<body>
    <%--@elvariable id="location" type="java"--%>
    <form:form action="${pageContext.request.contextPath}/location/store" method="post" modelAttribute="location">

        <div class="">

            <div class="mb-3">
                <label  class="form-label">Location Name </label>
                <form:input path="locationName" class="form-control"  placeholder="name"/>
            </div>
            <br><br>
            <input type="submit" value="Save" class="btn btn-primary">
        </div>

    </form:form>
</body>
</html>
