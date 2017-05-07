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
    <link rel="stylesheet" type="text/css" href="/resources/css/login.css">
</head>
<body>

<c:if test="${not empty message}">
    <h3>${message}</h3>
    <% session.removeAttribute("message"); %>
    </c:if>
<!--
<form method="post" action="/login.action">
    <label for="email">邮箱</label>
    <input id="email" name="email"><br>
    <label for="pwd">密码</label>
    <input id="pwd" name="pwd"><br>

    <input type="submit" value="确定">
</form>
-->
<div class="main">
    <div class="left">
        <img src="/resources/images/login.jpg" width="500px" height="500px">
    </div>
    <div class="right">
        <form method="post" action="/login.action">
            <p>登录</p>
            <input type="text" name="email" placeholder="邮箱地址" style="width: 280px ;height:40px"><br>
            <input type="password" name="pwd" placeholder="密码"  style="width: 280px; height:40px"><br>
            <input type="submit" value="登录" style="width: 293px;height: 40px"><br>
            <span><a href="/signUp">新用户注册</a> </span>
        </form>
    </div>
</div>
</body>
</html>
