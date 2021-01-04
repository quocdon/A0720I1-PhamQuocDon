<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hi_XV
  Date: 1/4/2021
  Time: 8:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Customer</title>
</head>
<body>
<h2>LIST OF CUSTOMER</h2>
<h3>Account: ${username}</h3>
<h3><a href="login">Log out</a></h3>
<table>
    <tr>
        <th>Username</th>
        <th>Password</th>
        <th>CustomerName</th>
        <th>Name</th>
        <th>Birthday</th>
        <th>Address</th>
        <th>Image</th>
    </tr>
    <c:forEach items="${customerList}" var="customer">
        <tr>
            <td>customer.username</td>
            <td>customer.password</td>
            <td>customer.customerName</td>
            <td>customer.birthday</td>
            <td>customer.address</td>
            <td><img src="<c:url value="${customer.image}"/>" style="width: 150px"></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
