<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hi_XV
  Date: 1/28/2021
  Time: 11:25 AM
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
        <div class="col-sm-10 d-flex justify-content-center">
            <form method="post" action="service-create" class="col-sm-6">
                <h1 class="text-center">Thông tin dịch vụ</h1>
                <br>
                <table class="table table-striped">
                    <tr class="form-group">
                        <td>Tên dịch vụ:</td>
                        <td><input class="form-control" type="text" name="name" required></td>
                    </tr>
                    <tr class="form-group">
                        <td>Diện tích:</td>
                        <td><input class="form-control" type="number" name="area" required></td>
                    </tr>
                    <tr class="form-group">
                        <td>Giá:</td>
                        <td><input class="form-control" type="number" name="cost" required></td>
                    </tr>
                    <tr class="form-group">
                        <td>SL khách tối đa:</td>
                        <td><input class="form-control" type="number" name="maxPeople" required></td>
                    </tr>
                    <tr class="form-group">
                        <td>Kiểu thuê:</td>
                        <td>
                            <select name="rentType" class="form-control">
                                <c:forEach var="rentType" items="${rentTypeList}">
                                    <option value="${rentType.id}">${rentType.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr class="form-group">
                        <td>Loại dịch vụ:</td>
                        <td>
                            <select name="serviceType" class="form-control">
                                <c:forEach var="serviceType" items="${serviceTypeList}">
                                    <option value="${serviceType.id}">${serviceType.name}</option>
                                </c:forEach>
                            </select>
                        </td>
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
    <%--    footer--%>
    <%@include file="../container/footer.jsp" %>
</div>
</body>
</html>
