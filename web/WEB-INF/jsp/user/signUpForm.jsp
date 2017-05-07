<%--
  Created by IntelliJ IDEA.
  User: p
  Date: 2017/5/5
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/register.css">
</head>
<body>
<!--
<form method="post" action="/singUp.action">
    <label for="email">邮箱：</label>
    <input name="email" id="email"><br>
    <label for="pwd">密码：</label>
    <input name="pwd" id="pwd"><br>

    <input type="submit" value="提交">
</form>
-->
<div class="main">
    <div class="left">
        <img src="/resources/images/login.jpg" width="500px" height="500px">
    </div>
    <div class="right">
        <form method="post" action="/singUp.action">
            <p>注册</p>
            <input type="text" name="email" placeholder="邮箱地址" style="width: 280px ;height:40px"><br>
            <input type="password" name="pwd"placeholder="密码"  style="width: 280px; height:40px"><br>
            <input type="password" placeholder="再次输入密码"  style="width: 280px; height:40px"><br>
            <input type="submit" value="登录" style="width: 293px;height: 40px"><br>
            <span><a href="/login">已有账户，请登录</a> </span>
        </form>
    </div>
</div>
</body>
</html>
