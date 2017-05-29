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
    <style type="text/css">
        form{
            width: 900px;
            height: 380px;
            margin: 20px auto;
            border: 1px solid #EDE4E4;
            padding-left: 50px;
            padding-top: 30px;
        }
        #left{
            width: 430px;
            height: 500px;
            float: left;
        }
        #right{
            width: 450px;
            height: 500px;
            float: left;
            line-height: 55px
        }
        #right label{
            width: 100px;
            display: inline-block;
            text-align: right;
            margin-right: 10px
        }
        input{
            width: 300px;
            height: 40px;
            padding: 3px;
            border-radius: 3px;
        }
        #btn{
            width: 70px;
            height: 40px
        }
    </style>
</head>
<body>
<%@include file="../shared/header.jsp"%>
<a href="/u/show"><button>返回我的主页</button></a>
<form method="post" action="/u/edit.action" enctype="multipart/form-data">
    <div id="left">
    <img src="/pic${user.photoUrl}" width="200" height="200"/><br>
    <label for="photo_file" >改变头像</label><input id="photo_file" type="file" name="photo_file"><br>
    </div>

    <div id="right">
    <label for="name" >昵称</label>
    <input name="name" value="${user.name}"id="name"><br>

    <label for="email">邮箱</label>
    <input name="email" value="${user.email}"id="email"><br>

    <label for="phone">联系电话</label>
    <input name="phone" value="${user.phone}" id="phone"><br>

    <label for="address">收货地址</label>
    <input name="address" value="${user.address}" id="address"><br>

    <label><input name="photoUrl" value="${user.photoUrl}" id="photoUrl" type="hidden"><br></label>

    <input id="btn" type="submit" value="提交">
    </div>
</form>
</body>
</html>
