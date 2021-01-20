<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Hi_XV
  Date: 1/13/2021
  Time: 6:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js" type="text/javascript"></script>
    <script src="js/search.js" type="text/javascript"></script>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="${pageContext.request.contextPath}/users?action=create">Add New User</a>
    </h2>
    <h2>
        <input type="text" placeholder="search" id="searchName">
        <button id="search">Search</button>
    </h2>
</center>
<div align="center" id="result">
</div>

</body>
</html>
