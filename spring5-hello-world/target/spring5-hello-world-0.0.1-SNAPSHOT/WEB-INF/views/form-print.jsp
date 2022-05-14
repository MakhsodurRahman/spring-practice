<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 5/14/2022
  Time: 12:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>form print</title>
    <link href="${pageContext.request.contextPath}/vendor/bootstrap/bootstrap.css" rel="stylesheet"/>
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
           <th scope="col">Text-Field</th>
           <th scope="col">Email</th>
           <th scope="col">Dropdown Selection</th>
           <th scope="col">Phone Number</th>
       </tr>
       </thead>
       <tbody>
       <tr>
           <th scope="row">1</th>
           <td>Name : ${formPrint.textField}</td>
           <td>email : ${formPrint.email}</td>
           <td>ddSelectionOption : ${formPrint.ddSelectionOption}</td>
           <td>phoneNumber : ${formPrint.phoneNumber}</td>
       </tr>
       <tr>
           <th scope="row">2</th>
           <td>Name : ${formPrint.textField}</td>
           <td>email : ${formPrint.email}</td>
           <td>ddSelectionOption : ${formPrint.ddSelectionOption}</td>
           <td>phoneNumber : ${formPrint.phoneNumber}</td>
       </tr>
       <tr>
           <th scope="row">3</th>
           <td>Name : ${formPrint.textField}</td>
           <td>email : ${formPrint.email}</td>
           <td>ddSelectionOption : ${formPrint.ddSelectionOption}</td>
           <td>phoneNumber : ${formPrint.phoneNumber}</td>
       </tr>
       </tbody>
   </table>
</body>
</html>
