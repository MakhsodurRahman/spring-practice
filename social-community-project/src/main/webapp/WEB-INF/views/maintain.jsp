<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 5/18/2022
  Time: 12:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>student form maintain</title>
</head>
<body>

<table>
  <tr>
    <td>Name : ${formPrint.textField}</td>
    <td>email : ${formPrint.email}</td>
    <td>ddSelectionOption : ${formPrint.ddSelectionOption}</td>
    <td>phoneNumber : ${formPrint.phoneNumber}</td>

  </tr>
</table>

<table class="table">
  <thead>
  <tr>
    <th scope="col">ID</th>
    <th scope="col">REG</th>
    <th scope="col">Name</th>
    <th scope="col">Email</th>
    <th scope="col">Department</th>
    <th scope="col">Subject</th>
    <th scope="col">Session</th>
  </tr>
  </thead>
  <tbody>
        <c:forEach var="student" items="${studentFormList}">
          <tr>
            <td class="td">${student.getId()}</td>
            <td class="td">${student.getReg()}</td>
            <td class="td">${student.getName()}</td>
            <td class="td">${student.getEmail()}</td>
            <td class="td">${student.getDepartment()}</td>
            <td class="td">${student.getSubject()}</td>
            <td class="td">${student.getSession()}</td>
          </tr>

        </c:forEach>


        </tbody>
</table>
</body>
</html>
