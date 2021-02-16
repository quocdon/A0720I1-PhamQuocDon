<%--
  Created by IntelliJ IDEA.
  User: Hi_XV
  Date: 1/29/2021
  Time: 1:29 AM
  To change this template use File | Settings | File Templates.
--%>
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
    <%@include file="../container/header.jsp" %>
    <%--    Navigation bar--%>
    <%@include file="../container/navbar.jsp" %>
    <div class="row">
        <!-- Left panel -->
        <%@include file="../container/panel.jsp" %>
        <%--        Content--%>
        <div class="col-sm-10 flex-column justify-content-center">
            <table class="table table-bordered col-sm-6" style="margin: auto">
                <tr>
                    <td style="width: 30%">ID:</td>
                    <td class="col-sm-4 text-center">${customer.id}</td>
                </tr>
                <tr>
                    <td style="width: 30%">Hạng khách:</td>
                    <td class="col-sm-4 text-center">${customer.customerTypeName}</td>
                </tr>
                <tr>
                    <td>Tên khách:</td>
                    <td class="text-center">${customer.name}</td>
                </tr>
                <tr>
                    <td>Ngày sinh:</td>
                    <td class="text-center">${customer.birthday}</td>
                </tr>
                <tr>
                    <td>Giới tính:</td>
                    <td class="text-center">${customer.gender}</td>
                </tr>
                <tr>
                    <td>Số CMND:</td>
                    <td class="text-center">${customer.idCard}</td>
                </tr>
                <tr>
                    <td>Số điện thoại:</td>
                    <td class="text-center">${customer.phone}</td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td class="text-center">${customer.email}</td>
                </tr>
                <tr>
                    <td>Địa chỉ:</td>
                    <td class="text-center">${customer.address}</td>
                </tr>
            </table>
            <br><br>
            <div class="col-sm-3" style="margin: auto;">
                <a class="btn btn-outline-primary btn-block text-center" href="customer-list">Back to list</a>
            </div>
            <br><br>
        </div>
    </div>
    <%--    footer--%>
    <%@include file="../container/footer.jsp" %>
</div>
</body>
</html>
