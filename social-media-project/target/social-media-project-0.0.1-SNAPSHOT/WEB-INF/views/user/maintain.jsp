<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title> User List </title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/vendor/style.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/vendor/add-customer-style.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/vendor/bootstrap/bootstrap.css"
</head>
<body>

<div id="container">
    <div >

        <input type="button" value="Add user"
               onclick="window.location.href='/user/create'; return false;" class="add-button">

        <table class="table table-dark table-striped">
            <tr>
                <th>ID</th>
                <th>Image</th>
                <th>Name</th>
                <th>Email</th>
                <th>Location</th>
                <th>Password</th>
                <th>Update</th>
                <th>Delete</th>

            </tr>

            <c:forEach var="user" items="${userList}">

                <c:url var="updateLink" value="/user/update">
                    <c:param name="userId" value="${user.getId()}"/>
                </c:url>

                <c:url var="deleteLink" value="/user/delete">
                    <c:param name="userId" value="${user.getId()}"/>
                </c:url>

                <tr>
                    <td>${user.getId()}</td>
                    <td class="td"><img src="images${user.getAttachment().getAttachmentPath()}" alt="" height="50px" width="50px" style="object-fit: cover"/></td>
                        <%--                    <td><img src="/images/${user.getAttachment().getAttachmentPath()}" height="100" width="100" style="object-fit: cover"></td>--%>
                    <td>${user.getName()}</td>
                    <td>${user.getEmail()}</td>
                    <td>${user.getLocation().getLocationName()}</td>
                    <td>${user.getPassword()}</td>


                    <td><a href="${updateLink}">Update</a></td>
                    <td>
                        <a href="${deleteLink}" onclick="if(!(confirm('Are your sure your want to delete this customer?'))) return false">Delete</a>
                    </td>
                </tr>
            </c:forEach>

        </table>

    </div>
</div>
</body>
</html>