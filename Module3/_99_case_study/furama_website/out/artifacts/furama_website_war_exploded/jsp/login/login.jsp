<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hi_XV
  Date: 1/29/2021
  Time: 8:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Furama Resort</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-4.6.0/dist/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/furamaStyle.css">
    <script src="css/bootstrap-4.6.0/dist/js/bootstrap.js"></script>
    <script src="css/jquery-3.5.1.slim.min.js"></script>
    <script src="css/bootstrap-4.6.0/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body>
<div class="container-fluid">
    <%--    Header--%>
    <%@include file="../container/header.jsp" %>
    <%--    Navigation bar--%>
    <%@include file="../container/navbar.jsp" %>
    <div class="row">
        <!-- Left navigation -->
        <%@include file="../container/panel.jsp" %>
        <%--        Content--%>
        <div class="col-sm-10 d-flex justify-content-center">
            <div class="col-sm-10">
                <form method="post" action="login" class="col-sm-9">
                    <h1 class="text-center">Đăng nhập</h1>
                    <br>
                    <table class="table table-striped">
                        <tr class="form-group">
                            <td>Tên đăng nhập:</td>
                            <td><input class="form-control" type="text" name="username" value="${user.username}"
                                       required></td>
                        </tr>
                        <tr class="form-group">
                            <td>Mật khẩu:</td>
                            <td><input class="form-control" type="password" name="password" value="${user.password}"
                                       required></td>
                        </tr>
                        <tr class="form-group">
                            <td></td>
                            <td><input type="submit" value="Submit" class="btn btn-primary">
                                <input type="reset" value="Reset" class="btn btn-secondary">
                            </td>
                        </tr>
                        <c:if test="${message != null}">
                            <tr>
                                <td></td>
                                <td style="color: red">${message}</td>
                            </tr>
                        </c:if>
                    </table>
                </form>
            </div>
        </div>
        <%--        end of main content--%>
    </div>
    <%--    footer--%>
    <%@include file="../container/footer.jsp" %>
</div>
</body>
</html>
