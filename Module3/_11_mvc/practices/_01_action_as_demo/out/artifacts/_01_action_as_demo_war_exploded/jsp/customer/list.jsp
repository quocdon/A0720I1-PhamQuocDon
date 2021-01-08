<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hi_XV
  Date: 1/7/2021
  Time: 10:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CUSTOMER LIST</title>
</head>
<body>
    <h1>Customer</h1>
    <p>
        <a href="customers?action=create">Create new Customer</a>
    </p>
    <table border="1">
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Email</td>
            <td>Address</td>
            <td>Delete</td>
            <td>Edit</td>
        </tr>
        <c:forEach items="${customers}" var="customer">
            <tr>
                <td>${customer.id}</td>
                <td><a href="customers?action=view&id=${customer.id}">${customer.name}</a></td>
                <td>${customer.email}</td>
                <td>${customer.address}</td>
                <td><a href="customers?action=edit&id=${customer.id}">edit</a></td>
                <td><a href="customers?action=delete&id=${customer.id}">delete</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
