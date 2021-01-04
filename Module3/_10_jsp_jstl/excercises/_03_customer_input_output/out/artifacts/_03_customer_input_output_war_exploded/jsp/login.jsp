<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hi_XV
  Date: 1/4/2021
  Time: 7:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Input Customer</title>
</head>
<body>
<h2>Login</h2>
<form method="post" action="login">
    <label>Username: </label>
    <input type="text" name="username">
    <label>Password: </label>
    <input type="text" name="password">
    <label></label>
    <input type="submit" value="Login">
    <label></label>
    <a href="${pageContext.request.contextPath}/register">Register</a>
</form>
<c:if test="${status != null }">
    <h3>${status}</h3>
</c:if>
</body>
</html>
