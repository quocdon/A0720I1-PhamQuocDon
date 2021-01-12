<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hi_XV
  Date: 1/7/2021
  Time: 12:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body>
<div class="container">
    <h1 class="text-center">Product List</h1>
    <div class="d-flex justify-content-between">
        <p><a class="btn btn-outline-primary" href="products?action=create">Create new product</a></p>
        <form method="post" action="products" class="form-inline">
            <input class="form-control" type="search" name="search" aria-label="search" placeholder="Search">
            <input class="btn btn-outline-primary" type="submit" value="Search">
            <input type="hidden" name="action" value="search">
        </form>
        <p><a class="btn btn-outline-primary" href="search">Advanced Search</a></p>
    </div>
    <c:if test="${products != null}">
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
    </c:if>
    <c:if test="${message != null}">
        <h3>${message}</h3>
    </c:if>


</div>
</body>
</html>
