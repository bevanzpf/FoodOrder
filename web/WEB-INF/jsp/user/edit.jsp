<%--
  Created by IntelliJ IDEA.
  User: p
  Date: 2017/5/6
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>跟新资料</title>
</head>
<body>
<a href="/u/show"><button>返回我的主页</button></a>
<form method="post" action="/u/edit.action" enctype="multipart/form-data">

    <img src="/${user.photoUrl}" width="200" height="200"/><br>
    <label for="photo_file" >改变头像</label><input id="photo_file" type="file" name="photo_file"><br>

    <label for="name" >昵称</label>
    <input name="name" value="${user.name}"id="name"><br>

    <label for="email">邮箱</label>
    <input name="email" value="${user.email}"id="email"><br>

    <label for="phone">联系电话</label>
    <input name="phone" value="${user.phone}" id="phone"><br>

    <label for="address">收货地址</label>
    <input name="address" value="${user.address}" id="address"><br>

    <input name="photoUrl" value="${user.photoUrl}" id="photoUrl" type="hidden"><br>

    <input type="submit" value="提交">
</form>
</body>
</html>
