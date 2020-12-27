<%--
  Created by IntelliJ IDEA.
  User: Hi_XV
  Date: 12/27/2020
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer List</title>
    <style>
        table {
            border: 1px solid black;
            border-collapse: collapse;
            width: 50%;
        }

        th {
            padding: 5px;
            margin: 5px;
            border: 1px solid black;
            border-collapse: collapse;
        }

        td {
            margin: auto;
            border: 1px solid black;
            border-collapse: collapse;
            text-align: center;
        }
        img{
            width: 100px;
        }
    </style>
</head>
<body>
<h2>LIST OF CUSTOMERS</h2>
<table>
    <tr>
        <th>Name</th>
        <th>Birthday</th>
        <th>Address</th>
        <th>Image</th>
    </tr>
    <c:forEach items="${customerList}" var="customer">
        <tr>
            <td>${customer.getName()}</td>
            <td><c:out value="${customer.birthday}"/></td>
            <td><c:out value="${customer.address}"/></td>
            <td><img src="${customer.image}"></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
