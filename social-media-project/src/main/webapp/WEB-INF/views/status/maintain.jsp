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
    <div id="contant">

        <input type="button" value="Add Status"
               onclick="window.location.href='/status/create'; return false;" class="add-button">

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

                <c:url var="deleteLink" value="/status/delete">
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

    </div>
</div>
</body>
</html>