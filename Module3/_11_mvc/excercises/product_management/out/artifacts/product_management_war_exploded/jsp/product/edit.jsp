<%--
  Created by IntelliJ IDEA.
  User: Hi_XV
  Date: 1/7/2021
  Time: 1:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body>
    <div class="container d-flex justify-content-center">
        <form method="post" action="products" class="col-sm-6">
            <h1 class="text-center">Edit Product</h1>
            <br>
            <table class="table">
                <tr class="form-group">
                    <td>ID: </td>
                    <td><input class="form-control" type="text" name = "id" value="${product.id}" required readonly></td>
                </tr>
                <tr>
                    <td>Name: </td>
                    <td><input class="form-control" type="text" name = "name" value="${product.name}" required></td>
                </tr>
                <tr>
                    <td>Price: </td>
                    <td><input class="form-control" type="text" name = "price" value="${product.price}" required></td>
                </tr>
                <tr>
                    <td>Description: </td>
                    <td><input class="form-control" type="text" name = "description" value="${product.description}" required></td>
                </tr>
                <tr>
                    <td>Manufacturer: </td>
                    <td><input class="form-control" type="text" name = "manufacturer" value="${product.manufacturer}" required></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input class="btn btn-primary" type="submit" value="Submit"><input class="btn btn-secondary" type="reset" value="Reset"></td>
                </tr>
                <input type="hidden" name="action" value="edit">
            </table>
        </form>

    </div>
</body>
</html>
