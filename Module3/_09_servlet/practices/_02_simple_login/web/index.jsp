<%--
  Created by IntelliJ IDEA.
  User: Hi_XV
  Date: 12/27/2020
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
    <style>
      .login{
        height: 180px;
        width: 230px;
        margin: 0;
        padding: 10px;
        border: 1px #CCC solid;
      }
      .login input{
        padding: 5px;
        margin: 5px;
      }
    </style>
  </head>
  <body>
  <form method="post" action="${pageContext.request.contextPath}/login">
    <div class="login">
      <h2>Login</h2>
      <input type="text" name="username" placeholder="Username">
      <input type="password" name="password" placeholder="Password">
      <input type="submit" value="Submit">
    </div>
  </form>
  </body>
</html>
