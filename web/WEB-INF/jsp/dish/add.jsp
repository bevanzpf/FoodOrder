<%--
  Created by IntelliJ IDEA.
  User: p
  Date: 2017/5/5
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加菜肴</title>
</head>
<body>
<h1>${productor.name},欢迎您添加菜肴</h1><br>
<a href="/productor/m?id=${productor.id}">返回管理主页</a>   ||   <a href="/productor/m/dishes/index?id=${productor.id}">查看已经有菜肴</a><br>
<form method="post" action="/productor/m/dishes/add.action?id=${productor.id}" enctype="multipart/form-data">
    <label for="photo">图片:</label>
    <input type="file" name="photo_file" id="photo"><br>
    <label for="name">名字:</label>
    <input name="name" id="name"><br>
    <label for="price">价格:</label>
    <input name="price" id="price" placeholder="￥">元<br>
    <label for="ingredients">主材:</label>
    <input name="ingredients" id="ingredients"><br>

    <input type="submit" value="确定">

</form>

</body>
</html>
