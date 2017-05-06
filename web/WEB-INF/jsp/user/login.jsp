<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: p
  Date: 2017/5/5
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>

<c:if test="${not empty message}">
    <h3>${message}</h3>
    <% session.removeAttribute("message"); %>
    </c:if>

<form method="post" action="/login.action">
    <label for="email">邮箱</label>
    <input id="email" name="email"><br>
    <label for="pwd">密码</label>
    <input id="pwd" name="pwd"><br>

    <input type="submit" value="确定">
</form>
</body>
</html>
