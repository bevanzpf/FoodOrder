<%--
  Created by IntelliJ IDEA.
  User: p
  Date: 2017/5/3
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商户登录</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/login.css">
</head>
<body>
<c:if test="${not empty loginMessage}">
    <p> ${loginMessage}</p>
</c:if>
<!--
<form action="/productor/login.action" method="post">
    <label for="email">邮箱</label><br>
    <input name="email" id="email"><br>
    <label for="pwd">密码</label><br>
    <input name ="pwd" id="pwd" type="password"/><br>
    <input type="submit" value="提交">
</form>
-->
<div class="main">
    <div class="left">
        <img src="/resources/images/login.jpg" width="500px" height="500px">
    </div>
    <div class="right">
        <form method="post" action="/productor/login.action">
            <p>商户登录</p>
            <input type="text" name="email" placeholder="邮箱地址" style="width: 280px ;height:40px"><br>
            <input type="password" name="pwd" placeholder="密码"  style="width: 280px; height:40px"><br>
            <input type="submit" value="登录" style="width: 293px;height: 40px"><br>

        </form>
    </div>
</div>

</body>
</html>
