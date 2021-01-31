<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hi_XV
  Date: 1/24/2021
  Time: 10:23 AM
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
    <div class="jumbotron banner d-flex justify-content-between" style="margin-bottom:0">
        <%--      logo--%>
        <a class="navbar-brand col-sm-3" href="index.jsp" >
            <img src="https://furamavietnam.com/wp-content/uploads/2018/08/logo.png" alt="">
        </a>
        <%--  Heading--%>
            <div class="text-center col-sm-6">
                <h1>FURAMA RESORT</h1>
                <p>Khu nghỉ dưỡng ẩm thực tọa lạc tại TP Đà Nẵng</p>
            </div>
            <div class="col-sm-3 text-right flex-column">
                <c:if test="${username == null}">
                    <a class="btn" href="login">Log in</a>
                </c:if>
                <c:if test="${username != null}">
                    <div><a>Tài khoản: ${username}</a></div>
                    <div><a href="logout">Đăng xuất</a></div>
                </c:if>
            </div>
    </div>
    <%--    Navigation bar--%>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="collapse navbar-collapse" id="navbarFurama">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                </li>
                <%--                <li class="nav-item">--%>
                <%--                    <a class="nav-link" href="#">Link</a>--%>
                <%--                </li>--%>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="employee" role="button" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        Nhân viên
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="employee-create">Thêm mới nhân viên</a>
                        <a class="dropdown-item" href="employee-list">Danh sách nhân viên</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="customer" role="button" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        Khách hàng
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="customer-create">Thêm mới</a>
                        <a class="dropdown-item" href="customer-list">Danh sách</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="service" role="button" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        Dịch vụ
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="service-create">Thêm mới</a>
                        <%--                        <a class="dropdown-item" href="#">Danh sách</a>--%>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="contract" role="button" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        Hợp đồng
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="contract-create">Thêm mới</a>
                        <%--                        <a class="dropdown-item" href="#">Danh sách</a>--%>
                    </div>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"
                       name="search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
    <div class="row">
        <!-- Left navigation -->
        <div class="col-sm-2">
            <ul class="nav nav-pills flex-column">
                <li class="nav-item">
                    <a class="nav-link" href="employee-list">Danh sách nhân viên</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="customer-list">Danh sách khách hàng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="contract-create">Tạo hợp đồng mới</a>
                </li>
            </ul>
            <hr class="d-sm-none">
        </div>
        <%--        Content--%>
        <div class="col-sm-10">
            <img class="col-sm-12" src="https://media2.reatimes.vn/upload/ol4yvthypo2k1vgfhnxktq/files/villa.jpg" style="margin: 0">
        </div>
    </div>
    <div class="jumbotron text-center" style="margin-bottom:0">
        <p>Tạo bởi Phạm Quốc Đôn - A0720i1</p>
    </div>
</div>
</body>
</html>
