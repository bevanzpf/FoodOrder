<%--
  Created by IntelliJ IDEA.
  User: p
  Date: 2017/5/3
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${admin.name}</title>
</head>

<body>

<h1>管理员 ${admin.name}, 欢迎您！</h1>
<a href="/man/login">管理员登录</a><br>
<a href="/man/logout">管理员登出</a><br>
<a href="/admin/productors/add">管理员添加商铺</a><br>
<a href="/admin/productors/index">管理员查看所以商品</a><br>

</body>
</html>
