<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hi_XV
  Date: 2/1/2021
  Time: 7:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Room</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="collapse navbar-collapse" id="navbarFurama">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="create">New Room<span class="sr-only">(current)</span></a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"
                       name="search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
    <div>
        <form method="post" action="create" class="col-sm-6">
            <h1 class="text-center">Room Information</h1>
            <br>
            <table class="table table-striped">
                <tr class="form-group">
                    <td>Name:</td>
                    <td><input class="form-control" type="text" name="name" required></td>
                </tr>
                <c:if test="${nameFlag != null}">
                    <tr>
                        <td></td>
                        <td style="color: red">${nameFlag}</td>
                    </tr>
                </c:if>
                <tr class="form-group">
                    <td>Phone:</td>
                    <td><input class="form-control" type="text" name="phone" required></td>
                </tr>
                <c:if test="${nameFlag != null}">
                    <tr>
                        <td></td>
                        <td style="color: red">${phoneFlag}</td>
                    </tr>
                </c:if>
                <tr class="form-group">
                    <td>Rent Date</td>
                    <td><input class="form-control" type="date" name="rentDate" required></td>
                </tr>
                <tr class="form-group">
                    <td>PaymentMethod:</td>
                    <td>
                        <select name="paymentMethod" class="form-control">
                            <c:forEach var="method" items="${methodList}">
                                <option value="${method.paymentMethod}">${method.paymentMethod}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr class="form-group">
                    <td>Remark:</td>
                    <td><input class="form-control" type="text" name="remark"></td>
                </tr>
                <tr class="form-group">
                    <td></td>
                    <td><input type="submit" value="Submit" class="btn btn-primary">
                        <input type="reset" value="Reset" class="btn btn-secondary">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>

