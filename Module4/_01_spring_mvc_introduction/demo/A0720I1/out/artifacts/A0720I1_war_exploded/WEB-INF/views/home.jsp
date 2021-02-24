<%--
  Created by IntelliJ IDEA.
  User: duytr
  Date: 2/22/2021
  Time: 6:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h3>Login</h3>
  <form action="/login" method="post">
    <label>UserName</label>
    <input type="text" name="username">
    <br>
    <label>Password</label>
    <input type="password" name="password">
    <br>
    <input type="submit" value="Login">
  </form>
  </body>
</html>
