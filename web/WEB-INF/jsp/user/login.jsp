<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: p
  Date: 2017/5/5
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style>
        .main{
            width: 950px;
            height: 500px;
            margin:0 auto;
        }
        .left{width: 500px;height: 500px; float: left}
        .right p{font-size: 27px; text-align: center}
        .right form input{
            width: 280px ;height:40px;
            margin-left: 30px;
            margin-top: 15px;
            border-radius: 4px;
            box-shadow: 0 1px 1px 0 #ECF1F2;
            padding: 2px 5px;
        }
        #btn{width: 293px;}
        .right form input:hover{background-color: #F0E5E5;cursor: pointer;}
        .right span a{text-decoration: none;color: #666;margin-left: 35px}
        .right span a:hover{text-decoration: underline;}
        .right form{
            width: 350px;
            height: 500px;
            float: left;
            border:1px solid #EDE4E4;
            margin-top: 40px;
            margin-left: 50px;
            background-color: #fafcfe
        }
        .right form label{
            padding-left: 30px;
        }
        .right form #chb{
            width: 30px;
        }
    </style>
</head>
<body>

<c:if test="${not empty message}">
    <h3>${message}</h3>
    <% session.removeAttribute("message"); %>
 </c:if>
<!--
<form method="post" action="/login.action">
    <label for="email">邮箱</label>
    <input id="email" name="email"><br>
    <label for="pwd">密码</label>
    <input id="pwd" name="pwd"><br>

    <input type="submit" value="确定">
</form>
-->
<div class="main">
    <div class="left">
        <img src="/resources/images/login.jpg" width="500px" height="500px">
    </div>
    <div class="right">
        <form method="post" action="/login.action">
            <p>登录</p>
            <input type="text" name="email" placeholder="邮箱地址" style="width: 280px ;height:40px"><br>
            <input type="password" id="btn" name="pwd" placeholder="密码"  style="width: 280px; height:40px"><br>
            <input type="submit" value="登录" style="width: 293px;height: 40px"><br>
            <label for="chb">记住我</label>
            <input type="checkbox" id="chb" value="1" name="checked" style="width: 30px; height:20px; display: inline;">
            <span><a href="/signUp">新用户注册</a> </span>
        </form>
    </div>
</div>
</body>
</html>
