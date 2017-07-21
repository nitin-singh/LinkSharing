<%--
  Created by IntelliJ IDEA.
  User: Prashant
  Date: 16-Jul-17
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/changePassword" method="get">
    <input type="hidden" name="id" value="${msg}"/>

    New Password:<input type="password" name="pass"/>
    Confirm Password:<input type="password" name="cnfrmPass"/>
    <input type="submit" value="Click to Change" onclick="check()">
</form>
</body>
</html>
