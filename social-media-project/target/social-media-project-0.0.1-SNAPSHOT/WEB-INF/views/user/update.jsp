<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 6/7/2022
  Time: 3:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/vendor/bootstrap/bootstrap.css"
</head>
<body>
   

    
    <%--@elvariable id="userRequestDto" type="java"--%>
    <form:form action="${pageContext.request.contextPath}/user/update" method="post" modelAttribute="userRequestDto">
        <div class="container">
            <div class="row h-w">
                <h4>Create User</h4>

                <div class="form-group">
                    <form:input  path="id" placeholder="${userRequestDto.id}" readonly="true" class="form-control"/>
                </div>
                <div class="mb-3">
                    <label  class="form-label">Name</label>
                    <form:input path="name" class="form-control"  placeholder="name"/>
                </div>

                <div class="mb-3">
                    <label class="form-label">Email address</label>
                    <form:input path="email" class="form-control" placeholder="name@example.com"/>
                </div>

                <div class="mb-3">
                    <label  class="form-label">Password</label>
                    <form:input path="password"  class="form-control" placeholder="password"/>
                </div>

<%--                <div class="mb-3">--%>
<%--                    <form:select path="locationName" cssClass="dropdown">--%>
<%--                        <form:option selected="true" value="Select Your Location" disabled="true" />--%>
<%--                        <form:options items="${locationList}"/>--%>
<%--                    </form:select>--%>
<%--                </div>--%>
                <br><br>
                <input type="file"/><br><br>

                <input type="submit" value="Save" class="btn btn-primary">
            </div>
        </div>
    </form:form>

  <style>
      .h-w{
          height: 200px;
          width: 500px;
          margin-top: 100px;
      }
  </style>
</body>
</html>
