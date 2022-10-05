
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


                <!-- all post -->

        <div id="container">
            <div id="contant">

                <table class="table table-dark table-striped">
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Description</th>
                        <th>Location</th>
                        <th>Privacy</th>
                        <th class="th" colspan="2">Attachments</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>

                    <c:forEach var="status" items="${statusList}">

                        <c:url var="updateLink" value="/status/update">
                            <c:param name="statusId" value="${status.getId()}"/>
                        </c:url>

                        <c:url var="deleteLink" value="/">
                            <c:param name="statusId" value="${status.getId()}"/>
                        </c:url>

                        <tr>
                            <td>${status.getId()}</td>
                            <td>${status.getTitle()}</td>
                            <td>${status.getDescription()}</td>
                            <td>${status.getLocation().getLocationName()}</td>
                            <td>${status.getPrivacy()}</td>

                            <c:forEach var="image" items="${status.getStatusAttachmentList()}">
                                <td><img src="/images${image.getAttachmentPath()}" alt="" height="100px" width="100px" style="object-fit: cover"/></td>
                            </c:forEach>
                            <td><a href="${updateLink}">Update</a></td>
                            <td>
                                <a href="${deleteLink}" onclick="if(!(confirm('Are your sure your want to delete this customer?'))) return false">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <!-- end post -->
            </div>
        </div>
        </div>
</html>
