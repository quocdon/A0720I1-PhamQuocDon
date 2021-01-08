<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hi_XV
  Date: 1/7/2021
  Time: 10:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CUSTOMER INFORMATION/title>
</head>
<body>
    <c:if test="${action == create}">
        <h1>Create customer</h1>
    </c:if>
    <c:if test="${action = edit}">
        <h1>Edit customer</h1>
    </c:if>
    <a href="/customer">Back to Customer List</a>
    <form method="post" action="customer">
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" <c:if test="${action = "></td>
            </tr>
        </table>
    </form>


</body>
</html>
