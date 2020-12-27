<%--
  Created by IntelliJ IDEA.
  User: Hi_XV
  Date: 12/27/2020
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Discount Calculator</title>
  </head>
  <body>
  <form method="post" action="${pageContext.request.contextPath}/display-discount">
    <h2>Product description</h2>
    <input type="text" name="description">
    <h2>Price</h2>
    <input type="text" name="price">
    <h2>Discount percent</h2>
    <input type="text" name="discount-percent">
    <br>
    <input type="submit" value="Submit">
  </form>
  </body>
</html>
