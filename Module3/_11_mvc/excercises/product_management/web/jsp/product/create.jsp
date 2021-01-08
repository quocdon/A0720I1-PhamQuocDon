<%--
  Created by IntelliJ IDEA.
  User: Hi_XV
  Date: 1/7/2021
  Time: 12:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body>
<div class="container d-flex justify-content-center">
    <form method="post" action="products" class="col-sm-6">
        <h1 class="text-center">Create New Product</h1>
        <br>
        <table class="table">
            <tr class="form-group">
                <td>Name: </td>
                <td><input class="form-control" type="text" name = "name" required></td>
            </tr>
            <tr class="form-group">
                <td>Price: </td>
                <td><input class="form-control" type="text" name = "price" required></td>
            </tr>
            <tr class="form-group">
                <td>Description: </td>
                <td><input class="form-control" type="text" name = "description" required></td>
            </tr>
            <tr class="form-group">
                <td>Manufacturer: </td>
                <td><input class="form-control" type="text" name = "manufacturer" required></td>
            </tr>
            <tr class="form-group">
                <td></td>
                <td><input type="submit" value="Submit" class="btn btn-primary">
                    <input type="reset" value="Reset" class="btn btn-secondary">
                </td>
            </tr>
            <input type="hidden" name="action" value="create">
        </table>
    </form>

</div>

</body>
</html>
