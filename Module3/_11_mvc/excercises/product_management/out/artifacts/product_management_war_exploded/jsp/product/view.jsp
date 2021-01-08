<%--
  Created by IntelliJ IDEA.
  User: Hi_XV
  Date: 1/7/2021
  Time: 1:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Information</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="p-flex justify-content-center">
        <h1 class="text-center">Product Information</h1>
        <br>
        <table class="table table-bordered col-sm-6" style="margin: auto">
            <tr>
                <td style="width: 30%">ID:</td>
                <td class="col-sm-4 text-center">${product.id}</td>
            </tr>
            <tr>
                <td>Name:</td>
                <td class="text-center">${product.name}</td>
            </tr>
            <tr>
                <td>Price:</td>
                <td class="text-center">${product.price}</td>
            </tr>
            <tr>
                <td>Description:</td>
                <td class="text-center">${product.description}</td>
            </tr>
            <tr>
                <td>Manufacturer:</td>
                <td class="text-center">${product.manufacturer}</td>
            </tr>
        </table>
        <br><br>
        <div class="col-sm-3" style="margin: auto;">
            <a class="btn btn-outline-primary btn-block text-center" href="products">Back to list</a>
        </div>
    </div>
</div>
</body>
</html>
