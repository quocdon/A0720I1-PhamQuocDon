<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: duytr
  Date: 2/24/2021
  Time: 7:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Create Student</h3>
<form:form action="/create" method="post" modelAttribute="student">
    <label>Id</label>
    <form:input path="id"/>
    <br>
    <label>Name</label>
    <form:input path="name"/>
    <br>
    <form:select path="subject">
        <form:options items="${subjects}"/>
    </form:select>
<%--    <form:radiobuttons path="subject" items="${subjects}"/>--%>
    <input type="submit" value="Create">
</form:form>
</body>
</html>
