<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hi_XV
  Date: 1/25/2021
  Time: 11:26 PM
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
        <div class="col-sm-10 d-flex justify-content-center">
            <form method="post" action="${urlPattern}" class="col-sm-6">
                <h1 class="text-center">Thông tin khách hàng</h1>
                <br>
                <table class="table table-striped">

                    <tr class="form-group">
                        <td>Hạng khách:</td>
                        <td>
                            <select name="customerType" class="form-control">
                                <c:forEach var="customerType" items="${customerTypeList}">
                                    <c:choose>
                                        <c:when test="${customerType.id == customer.customerTypeId}">
                                            <option value="${customerType.id}" selected>${customerType.name}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${customerType.id}">${customerType.name}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <td>Tên khách:</td>
                    <td><input class="form-control" type="text" name="name" value="${customer.name}" required></td>
                    </tr>
                    <tr class="form-group">
                        <td>Ngày sinh:</td>
                        <td><input class="form-control" type="date" name="birthday" value="${customer.birthday}"
                                   required></td>
                    </tr>
                    <tr class="form-group">
                        <td>Giới tính:</td>
                        <td>
                            <select name="gender" class="form-control">
                                <c:forEach var="gender" items="${genderList}">
                                    <c:choose>
                                        <c:when test="${customer.gender == gender}">
                                            <option selected>${gender}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option>${gender}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr class="form-group">
                        <td>Số CMND:</td>
                        <td><input class="form-control" type="text" name="idCard" value="${customer.idCard}" required>
                        </td>
                    </tr>
                    <c:if test="${idCardFlag != null}">
                        <tr>
                            <td></td>
                            <td style="color: red">${idCardFlag}</td>
                        </tr>
                    </c:if>
                    <tr class="form-group">
                        <td>Số điện thoại:</td>
                        <td><input class="form-control" type="text" name="phone" value="${customer.phone}" required>
                        </td>
                    </tr>
                    <c:if test="${phoneFlag != null}">
                        <tr>
                            <td></td>
                            <td style="color: red">${phoneFlag}</td>
                        </tr>
                    </c:if>
                    <tr class="form-group">
                        <td>Email:</td>
                        <td><input class="form-control" type="email" name="email" value="${customer.email}" required>
                        </td>
                    </tr>
                    <c:if test="${emailFlag != null}">
                        <tr>
                            <td></td>
                            <td style="color: red">${emailFlag}</td>
                        </tr>
                    </c:if>
                    <tr class="form-group">
                        <td>Địa chỉ:</td>
                        <td><input class="form-control" type="text" name="address" value="${customer.address}" required>
                        </td>
                    </tr>
                    <tr class="form-group">
                        <td></td>
                        <td><input type="submit" value="Submit" class="btn btn-primary">
                            <input type="reset" value="Reset" class="btn btn-secondary">
                        </td>
                    </tr>
                </table>
                <input type="text" name="id" value="${customer.id}" hidden>
            </form>
        </div>
    </div>
    <%--    footer--%>
    <%@include file="../container/footer.jsp" %>
</div>
</body>
</html>
