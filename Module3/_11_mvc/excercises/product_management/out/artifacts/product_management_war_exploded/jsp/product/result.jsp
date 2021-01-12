<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hi_XV
  Date: 1/8/2021
  Time: 7:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table class="table table-striped">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Manufacturer</th>
        <th class="text-center">Edit</th>
        <th class="text-center">Delete</th>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.id}</td>
            <td><a href="products?action=view&id=${product.id}">${product.name}</a></td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td>${product.manufacturer}</td>
            <td class="text-center">
                <a href="products?action=edit&id=${product.id}">
                    <span class="material-icons">edit</span>
                </a>
            </td>
            <td class="text-center">
                <a href="products?action=remove&id=${product.id}">
                    <span class="material-icons">delete_forever</span>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
