<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: quocd
  Date: 3/2/2021
  Time: 10:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Setting</title>
</head>
<body>
 <h2>Setting</h2>
<form:form action="/showSetting" method="post" modelAttribute="setting">
    <table>
        <tr>
            <td>
                <form:label path="language">Language:</form:label>
            </td>
            <td>
                <form:select path="language">
                    <form:options items="${language}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="pageSize">Page size:</form:label>
            </td>
            <td>
                <span>Show </span>
                <form:select path="pageSize">
                    <form:options items="${pageSize}"/>
                </form:select>
                <span> emails per page</span>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="spamFilter">Spam filter:</form:label>
            </td>
            <td>
                <form:checkbox path="spamFilter"/>
                <span>enable spam filter</span>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="signature">Signature</form:label>
            </td>
            <td>
                <form:textarea path="signature"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="Update">
                <a href="/showSetting">Cancel</a>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
