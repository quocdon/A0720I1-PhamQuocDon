<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hi_XV
  Date: 1/25/2021
  Time: 10:55 PM
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
        <div class="col-sm-10">
            <c:if test="${employeeList != null}">
                <table class="table table-striped">
                    <tr>
                        <th>Mã NV</th>
                        <th>Họ tên</th>
                        <th>SĐT</th>
                        <th>Email</th>
                        <th>Vị trí</th>
                        <th>Phòng ban</th>
                        <th class="text-center">Edit</th>
                        <th class="text-center">Delete</th>
                    </tr>
                    <c:forEach items="${employeeList}" var="employee">
                        <tr>
                            <td>${employee.id}</td>
                            <td><a href="employee-view?id=${employee.id}">${employee.name}</a></td>
                            <td>${employee.phone}</td>
                            <td>${employee.email}</td>
                            <td>${employee.positionName}</td>
                            <td>${employee.departmentName}</td>
                            <td class="text-center">
                                <a href="employee-edit?id=${employee.id}&username=${employee.username}">
                                    <span class="material-icons">edit</span>
                                </a>
                            </td>
                            <td class="text-center">
                                <a href="employee-remove?id=${employee.id}">
                                    <span class="material-icons">delete_forever</span>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <div class="text-center">
                    <c:if test="${previousPage != null}">
                        <a href="${previousPage}">Trang trước</a>
                    </c:if>
                    <span> ${page}/${numPages} </span>
                    <c:if test="${nextPage != null}">
                        <a href="${nextPage}">Trang sau</a>
                    </c:if>
                </div>
            </c:if>
        </div>
    </div>
    <%--    footer--%>
    <%@include file="../container/footer.jsp" %>
</div>
</body>
</html>

