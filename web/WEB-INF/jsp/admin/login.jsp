<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: p
  Date: 2017/5/7
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录</title>
</head>
<body>
<c:if test="${not empty loginMessage}">
    <p> ${loginMessage}</p>
    <% session.removeAttribute("loginMessage"); %>
</c:if>
<form action="/man/login.action" method="post">
    <label for="email">邮箱</label><br>
    <input name="email" id="email"><br>
    <label for="pwd">密码</label><br>
    <input name ="pwd" id="pwd" type="password"/><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
