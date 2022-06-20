
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 6/6/2022
  Time: 10:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>social-media</title>
    <link rel="stylesheet"  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/all.min.css" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/js/all.min.js" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/vendor/bootstrap/bootstrap.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-2">
        <div class="row">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">Social Media</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav mr-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="#">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Post</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">User</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
        <%--        location and user section--%>

        <div class="row">
            <div class="col-md-4">
                <div class="create">

                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        
                        <h5>Location</h5>
                        <a href="${pageContext.request.contextPath}/location/create/" target="_blank">Create Location</a><br><br>
                        <a href="${pageContext.request.contextPath}/location/maintain/" target="_blank">Location List</a>
                    </sec:authorize>

                </div>
                <br><br>
                <div>
                    <h5>User</h5>
                    <a href="${pageContext.request.contextPath}/user/create/" target="_blank">Create User</a><br><br>
                   <a href="${pageContext.request.contextPath}/user/maintain/" target="_blank">User List</a>
                </div>
                <br><br>
                <div>
                    <h5>Status</h5>
                    <a href="${pageContext.request.contextPath}/status/create/" target="_blank">Post</a><br><br>
                    <a href="${pageContext.request.contextPath}/status/maintain/" target="_blank">All Post</a>
                </div>
            </div>
        </div>

        <hr>
        <!-- Add a logout button -->
        <form:form action="${pageContext.request.contextPath}/logout"
                   method="POST">

            <input type="submit" value="Logout" />

        </form:form>
    </div>



<style>
    a{
        text-decoration: none;
    }
</style>
</body>
</html>
