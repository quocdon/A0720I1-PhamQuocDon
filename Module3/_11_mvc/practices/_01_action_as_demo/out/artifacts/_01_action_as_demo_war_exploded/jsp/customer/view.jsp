<%--
  Created by IntelliJ IDEA.
  User: Hi_XV
  Date: 1/7/2021
  Time: 11:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Customer</title>
</head>
<body>
<p>Information of customer</p>
    <table>
        <tr>
            <td>Name</td>
            <td>${customer.name}</td>
        </tr>
        <tr>
            <td>Email</td>
            <td>${customer.email}</td>
        </tr>
        <tr>
            <td>Address</td>
            <td>${customer.address}</td>
        </tr>
    </table>
    <a href="customers">Back to list !^^</a>
</body>
</html>
