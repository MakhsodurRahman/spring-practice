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
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/vendor/bootstrap/bootstrap.css">
</head>
<body>

    <%--@elvariable id="status" type="java"--%>
    <form:form action="${pageContext.request.contextPath}/status/store" method="post" modelAttribute="status" enctype="multipart/form-data">
        <div class="container">
            <div class="row h-w">
                <h4>Create Status</h4>

                <div class="mb-3">
                    <label  class="form-label">Title</label>
                    <form:input path="title" class="form-control"  placeholder="title"/>
                </div>

                <div class="mb-3">
                    <label class="form-label">Description</label>
                    <form:textarea path="description" class="form-control"/>
                </div>


                <div class="mb-3 dropdown-center">
                    <form:select path="location" class="btn btn-info dropdown-toggle" type="button" id="dropdownCenterBtn" data-bs-toggle="dropdown" aria-expanded="false">
                        <form:option selected="true" value="Select Your Location" disabled="true" />
                        <form:options items="${locationList}"/>
                    </form:select>
                </div>
                <br><br>

                <div class="mb-3 dropdown-center">
                    <form:select path="privacy" class="btn btn-info dropdown-toggle" type="button" id="dropdownCenterBtn" data-bs-toggle="dropdown" aria-expanded="false">
                        <form:option selected="true" value="Select Privacy" disabled="true" />
                        <form:options items="${privacyList}"/>
                    </form:select>
                </div>
                <input type="file" name="images" multiple="multiple" accept="image/*"/><br><br>

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
