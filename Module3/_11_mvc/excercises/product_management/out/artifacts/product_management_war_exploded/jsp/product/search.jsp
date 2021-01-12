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
    <title>Search Product</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js" type="text/javascript"></script>
    <script src="js/search.js" type="text/javascript"></script>
</head>
<body>
<div class="container">
    <h1 class="text-center">Advanced Search</h1>
    <div class="d-flex justify-content-center">
        <input class="form-control col-sm-4" type="search" id="productName" aria-label="search" placeholder="Search">
        <button class="btn btn-outline-primary" id="search">Search</button>
        <a href="products" class="btn btn-outline-primary">Back to List</a>
    </div>
    <hr>
    <div class="text-center" id="result"></div>
</div>
</body>
</html>
