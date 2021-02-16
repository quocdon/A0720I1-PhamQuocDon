<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hi_XV
  Date: 1/29/2021
  Time: 12:13 AM
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
        <!-- Left navigation -->
        <%@include file="../container/panel.jsp" %>
        <%--        Content--%>
        <div class="col-sm-10">
            <c:if test="${customerList != null}">
                <table class="table table-striped">
                    <tr>
                        <th>ID</th>
                        <th>Hạng khách</th>
                        <th>Tên</th>
                        <th>Ngày sinh</th>
                        <th>Giới tính</th>
                        <th class="text-center">Edit</th>
                        <th class="text-center">Delete</th>
                    </tr>
                    <c:forEach items="${customerList}" var="customer">
                        <tr>
                            <td>${customer.id}</td>
                            <td>${customer.customerTypeName}</td>
                            <td><a href="customer-view?id=${customer.id}">${customer.name}</a></td>
                            <td>${customer.birthday}</td>
                            <td>${customer.gender}</td>
                            <td class="text-center">
                                <a href="customer-edit?id=${customer.id}">
                                    <span class="material-icons">edit</span>
                                </a>
                            </td>
                            <td class="text-center">
                                <a href="customer-remove?id=${customer.id}">
                                    <span class="material-icons">delete_forever</span>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>
    </div>
    <%@include file="../container/footer.jsp"%>
</div>
</body>
</html>
