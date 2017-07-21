<%--
  Created by IntelliJ IDEA.
  User: Prashant
  Date: 16-Jul-17
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>${msg}</h3>
<form action="/email" method="post">
    <input type="text" name="emailid"/>
    <input type="submit" value="Send mail">
</form>
</body>
</html>
