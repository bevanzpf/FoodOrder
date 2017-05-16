<%--
  Created by IntelliJ IDEA.
  User: p
  Date: 2017/5/5
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商户管理页面</title>
</head>
<body>

<h1>${productor.name}的管理页面</h1>
<a href="/productor/logout">商户登出</a><br>
<a href="/productor/m/edit?id=${productor.id}">商户修改自己资料页面(只有登录才可以）</a><br>
<a href="/productor/m/dishes/add?id=${productor.id}">登录后添加菜肴</a><br>
<a href="/productor/m/dishes/index?id=${productor.id}">登录后查看所以已加菜肴</a><br>
<a href="/productor/order/index">处理订单</a>
</body>
</html>
