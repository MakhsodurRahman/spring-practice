
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
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/vendor/bootstrap.js" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/vendor/bootstrap/bootstrap.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<div>
        <div class="container">
            <div class="row">

                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container-fluid">
                        <a class="navbar-brand" href="#">Social Media</a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">

                                <sec:authorize access="hasRole('ADMIN')">
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown1" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                        Location
                                    </a>

                                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown1">
                                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/location/create/">Create</a></li>
                                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/location/maintain/">List</a></li>
                                    </ul>
                                </li>
                                </sec:authorize>

                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                        User
                                    </a>
                                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown2">
                                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/user/create/">Create</a></li>
                                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/user/maintain/">List</a></li>
                                    </ul>
                                </li>


                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown3" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                        Post
                                    </a>
                                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown3">
                                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/status/create/">Create</a></li>
                                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/status/maintain/">List</a></li>
                                    </ul>
                                </li>

                                 <li class="nav-item">
                                        <sec:authorize access="!isAuthenticated()">
                                            <a class="btn btn-primary" href="/user/login">Login</a>
                                        </sec:authorize>

                                        <sec:authorize access="isAuthenticated()">
                                            <sec:authentication property="name"/>
                                            <form:form action="${pageContext.request.contextPath}/user/logout"
                                                       method="POST">

                                                <input type="submit" value="Logout" />

                                            </form:form>
                                        </sec:authorize>

                                  </li>
                            </ul>

                        </div>
                    </div>
                </nav>
            </div>
        <%--        location and user section--%>


        <!-- Add a logout button -->

    </div>
</div>


<style>
    a{
        text-decoration: none;
    }
</style>
</body>
</html>
