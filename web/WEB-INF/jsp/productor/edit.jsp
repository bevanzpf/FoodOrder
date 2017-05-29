<%--
  Created by IntelliJ IDEA.
  User: p
  Date: 2017/5/4
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新商户资料</title>
    <style type="text/css">
        form{
            width: 950px;
            height: 430px;
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
            width: 500px;
            height: 500px;
            float: left;
            line-height: 55px
        }
        #right label{
            width: 130px;
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

<form method="post" action="/productor/m/edit.action?id=${productor.id}" enctype="multipart/form-data" >
    <div id="left">
    <img src="/pic${productor.photo}" height="300" width="400" /><br>
    <input type="file" name="photo_file"><br>
    </div>

    <div id="right">
    <label for="name">店铺名称</label>
    <input name="name" id="name" value="${productor.name}"><br>
    <label for="enName">英文名</label>
    <input name="enName" id="enName" value="${productor.enName}"><br>
    <label for="email">店铺登录Email</label>
    <input name="email" id="email" value="${productor.email}"><br>
    <label for="phone">电话</label>
    <input name="phone" id="phone" value="${productor.phone}"><br>
    <label for="openTime">经营时间</label>
    <input name="openTime"id="openTime" placeholder="13:00~00:00" value="${productor.openTime}">
    <label for="info">商铺介绍</label>
    <input name="info" id="info" value="${productor.info}" type="text"><br>
    <label></label>
    <input type="submit" value="提交" id="btn">
    </div>


</form>

</body>
</html>
