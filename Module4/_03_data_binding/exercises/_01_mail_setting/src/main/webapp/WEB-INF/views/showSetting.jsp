<%--
  Created by IntelliJ IDEA.
  User: quocd
  Date: 3/2/2021
  Time: 11:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Setting</h2>
<h3>Language: ${setting.language}</h3>
<h3>Page size: ${setting.pageSize}</h3>
<h3>Spam Filter: ${setting.spamFilter}</h3>
<h3>Signature: ${setting.signature}</h3>
<a href="/setting">Change</a>
</body>
</html>
