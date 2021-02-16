<%--
  Created by IntelliJ IDEA.
  User: Hi_XV
  Date: 2/8/2021
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
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
        <c:if test="${signInUser == null}">
            <a class="btn" href="login">Log in</a>
        </c:if>
        <c:if test="${signInUser != null}">
            <div><a>Tài khoản: ${signInUser}</a></div>
            <div><a href="logout">Đăng xuất</a></div>
        </c:if>
    </div>
</div>
</body>
</html>
