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
<form action="/create" method="post">
    <label>Id</label>
    <input type="text" name="id">
    <br>
    <label>Name</label>
    <input type="text" name="name">
    <br>
    <input type="submit" value="Create">
</form>
</body>
</html>
