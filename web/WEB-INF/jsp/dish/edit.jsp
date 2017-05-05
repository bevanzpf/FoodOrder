<%--
  Created by IntelliJ IDEA.
  User: p
  Date: 2017/5/5
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改菜肴</title>
</head>
<body>
<a href="/productor/m/dishes/index?id=${productor.id}">返回所以菜肴</a>
<form method="post" action="/productor/dishes/edit.action?id=${dish.id}" enctype="multipart/form-data">

    <img src="/${dish.photoUrl}" width="200" height="300"/>
    <input type="file" name="photo_file" ><br>
    <label for="name">名字:</label>
    <input name="name" id="name" value="${dish.name}"><br>
    <label for="price">价格:</label>
    <input name="price" id="price" value="${dish.price}">元<br>
    <label for="ingredients">主材:</label>
    <input name="ingredients" id="ingredients" value="${dish.ingredients}"><br>
    <input type="hidden" name="photoUrl" value="${dish.photoUrl}"> <!-- 保证controller中的dish有绑定到原本的url -->

    <input type="submit" value="确定">

</form>
</html>
