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
    <style type="text/css">
        form{
            width: 400px;
            margin:20 400;
            line-height: 40px;
            border:1px solid #EDE4E4;
            padding-left: 50px;
            padding-top: 20px;
            padding-bottom: 20px
        }
        input{
            width: 250px;
            height: 30px;
            border-radius: 3px;
        }
        label{width: 40px;display: inline-block;}
        #btn{width:60px;}
        </style>
</head>
<body>
<%@include file="../shared/header.jsp"%>
<a href="/productor/m/dishes/index?id=${productor.id}">返回所以菜肴</a>
<form method="post" action="/productor/dishes/edit.action?id=${dish.id}" enctype="multipart/form-data">

    <img src="/pic${dish.photoUrl}" width="200" height="300"/>
    <input type="file" name="photo_file" ><br>
    <label for="name">名字:</label>
    <input name="name" id="name" value="${dish.name}"><br>
    <label for="price">价格:</label>
    <input name="price" id="price" value="${dish.price}">元<br>
    <label for="ingredients">主材:</label>
    <input name="ingredients" id="ingredients" value="${dish.ingredients}"><br>
    <input type="hidden" name="photoUrl" value="${dish.photoUrl}"> <!-- 保证controller中的dish有绑定到原本的url -->

    <input type="submit" value="确定" id="btn">

</form>
</html>
