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
    <%@include file="jsp/container/header.jsp" %>
    <%--    Navigation bar--%>
    <%@include file="jsp/container/navbar.jsp" %>
    <div class="row">
        <!-- Left navigation -->
        <%@include file="jsp/container/panel.jsp" %>
        <%--        Content--%>
        <div class="col-sm-10">
            <img class="col-sm-12" src="https://media2.reatimes.vn/upload/ol4yvthypo2k1vgfhnxktq/files/villa.jpg"
                 style="margin: 0">
        </div>
    </div>
    <%--        footer--%>
    <%@include file="jsp/container/footer.jsp" %>
</div>
</body>
</html>
