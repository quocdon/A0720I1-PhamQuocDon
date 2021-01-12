<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hi_XV
  Date: 1/4/2021
  Time: 8:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h2>Register</h2>
<form method="post" action="register">
    <label>Username: </label>
    <input type="text" name="username" id="username">
    <label>Password: </label>
    <input type="text" name="password">
    <label>Name: </label>
    <input type="text" name="customerName">
    <label>Birthday: </label>
    <input type="text" name="birthday">
    <label>Address: </label>
    <input type="text" name="address">
    <label>Image: </label>
    <input type="file" name="image">
    <label></label>
    <input type="submit" value="Register">
</form>
<c:if test="${status != null}">
    <h3>${status}</h3>
</c:if>
</body>
</html>
