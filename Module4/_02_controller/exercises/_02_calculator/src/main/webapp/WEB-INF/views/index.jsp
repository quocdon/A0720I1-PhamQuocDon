<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: quocd
  Date: 2/26/2021
  Time: 12:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculator</title>
  </head>
  <body>
  <h1>Calculator</h1>
  <form action="/result", method="post">
    <input type="text" name="number1" required>
    <input type="text" name="number2" required>
    <br>
    <br>
    <button type="submit" name="operator" value="+">Addition</button>
    <button type="submit" name="operator" value="-">Subtraction</button>
    <button type="submit" name="operator" value="*">Multiple</button>
    <button type="submit" name="operator" value="/">Division</button>
  </form>
  <hr>
  <c:choose>
    <c:when test="${error != null}">
      <h2 style="color: red">${error}</h2>
    </c:when>
    <c:when test="${result != null}">
      <h2 style="color: darkblue">${number1} ${operator} ${number2} = ${result}</h2>
    </c:when>
  </c:choose>
  </body>
</html>
