<%--
  Created by IntelliJ IDEA.
  User: Hi_XV
  Date: 2/8/2021
  Time: 3:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
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
                    <a class="dropdown-item" href="employee-create">Thêm mới</a>
                    <a class="dropdown-item" href="employee-list?page=1">Danh sách</a>
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
</body>
</html>
