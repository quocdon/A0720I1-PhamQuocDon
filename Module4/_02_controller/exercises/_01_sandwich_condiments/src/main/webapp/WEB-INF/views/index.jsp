<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: quocd
  Date: 2/25/2021
  Time: 11:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/sandwich", commandName = "sandwich" , method="post">
    <input type="checkbox"  name="condiments" value="lettuce">
    <label>Lettuce</label>
    <input type="checkbox"  name="condiments" value="tomato">
    <label>Tomato</label>
    <input type="checkbox"  name="condiments" value="mustard">
    <label>Mustard</label>
    <input type="checkbox"  name="condiments" value="sprouts">
    <label>Sprouts</label>
    <br><br>
    <input type="submit" value="Submit">
  </form>

  </body>
</html>
