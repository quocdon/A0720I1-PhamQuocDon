<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>

<%--
  Created by IntelliJ IDEA.
  User: Hi_XV
  Date: 2/22/2021
  Time: 8:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<form action="/search", method="get">
    <label>English</label>
    <input type="text" name="word">
    <input type="submit" value="search">
</form>
<hr>
<c:if test="${vietnamese != null}">
    <h3>English: ${english}</h3>
    <h3>Tiếng Việt: ${vietnamese}</h3>
</c:if>
</body>
</html>
