<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 5/18/2022
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>student form</title>
    <style>
        .margin-top{
            margin-top: 15px;
        }
    </style>
    <link  href="${pageContext.request.contextPath}/vendor/bootstrap/bootstrap.css" rel="stylesheet" >
</head>
<body>
    <form:form action="${pageContext.request.contextPath}/store" method="post" modelAttribute="studentform">
        <div class="margin-top">
            <label>Reg Number : </label>
            <form:input path="reg"></form:input>
        </div>

        <div class=" margin-top">
            <label>Student Name : </label>
            <form:input path="name"></form:input>
        </div>

        <div class=" margin-top">
            <label>Student email : </label>
            <form:input path="email"></form:input>
        </div>

       <div class="margin-top">
           <label>Select Department : </label>
           <form:select path="department">
               <form:option Selected="true" value="choose your department" disabled="true" />
               <form:options items="${departmentList}" />
           </form:select>
       </div>

        <div class="margin-top">
            <label>Select Subject : </label>
            <form:select path="subject">
                <form:option value="choose your subject" Selected="true" disabled="true"/>
                <form:options items="${subjectList}"/>
            </form:select>
        </div>

        <div class="margin-top">

            <label>Student Sesston : </label>
            <form:input path="session"></form:input>
        </div>

        <input type="submit" value="Save">
    </form:form>

</body>
</html>
