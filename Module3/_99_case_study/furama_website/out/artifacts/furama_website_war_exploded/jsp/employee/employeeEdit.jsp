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
            <form method="post" action="employee-edit" class="col-sm-6">
                <h1 class="text-center">Thông tin nhân viên</h1>
                <br>
                <table class="table table-striped">
                    <tr class="form-group">
                        <td>Họ tên:</td>
                        <td><input class="form-control" type="text" name="name" value="${employee.name}" required></td>
                    </tr>
                    <tr class="form-group">
                        <td>Ngày sinh:</td>
                        <td><input class="form-control" type="date" name="birthday" value="${employee.birthday}"
                                   required></td>
                    </tr>
                    <tr class="form-group">
                        <td>Số CMND:</td>
                        <td><input class="form-control" type="text" name="idCard" value="${employee.idCard}" required>
                        </td>
                    </tr>
                    <c:if test="${idCardFlag != null}">
                        <tr>
                            <td></td>
                            <td style="color: red">${idCardFlag}</td>
                        </tr>
                    </c:if>
                    <tr class="form-group">
                        <td>Lương:</td>
                        <td><input class="form-control" type="text" name="salary" value="${employee.salary}" required>
                        </td>
                    </tr>
                    <c:if test="${salaryFlag != null}">
                        <tr>
                            <td></td>
                            <td style="color: red">${salaryFlag}</td>
                        </tr>
                    </c:if>
                    <tr class="form-group">
                        <td>Số điện thoại:</td>
                        <td><input class="form-control" type="text" name="phone" value="${employee.phone}" required>
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
                        <td><input class="form-control" type="email" name="email" value="${employee.email}" required>
                        </td>
                    </tr>
                    <c:if test="${emailFlag != null}">
                        <tr>
                            <td></td>
                            <td style="color:red;">${emailFlag}</td>
                        </tr>
                    </c:if>
                    <tr class="form-group">
                        <td>Địa chỉ:</td>
                        <td><input class="form-control" type="text" name="address" value="${employee.address}" required>
                        </td>
                    </tr>
                    <tr class="form-group">
                        <td>Vị trí:</td>
                        <td>
                            <select name="position" class="form-control">
                                <c:forEach var="position" items="${positionList}">
                                    <c:choose>
                                        <c:when test="${position.id == employee.positionId}">
                                            <option value="${position.id}" selected>${position.name}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${position.id}">${position.name}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr class="form-group">
                        <td>Trình độ:</td>
                        <td>
                            <select name="educationDegree" class="form-control">
                                <c:forEach var="educationDegree" items="${educationDegreeList}">
                                    <c:choose>
                                        <c:when test="${educationDegree.id == employee.educationDegreeId}">
                                            <option value="${educationDegree.id}"
                                                    selected>${educationDegree.name}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${educationDegree.id}">${educationDegree.name}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr class="form-group">
                        <td>Bộ phận:</td>
                        <td>
                            <select name="department" class="form-control">
                                <c:forEach var="department" items="${departmentList}">
                                    <c:choose>
                                        <c:when test="${department.id == employee.departmentId}">
                                            <option value="${department.id}" selected>${department.name}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${department.id}">${department.name}</option>
                                        </c:otherwise>
                                    </c:choose>
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
                <input class="form-control" type="text" name="id" value="${employee.id}" required hidden>
                <input class="form-control" type="text" name="username" value="${employee.username}" required hidden>
            </form>
        </div>
    </div>
    <%--    footer--%>
    <%@include file="../container/footer.jsp" %>
</div>
</body>
</html>
