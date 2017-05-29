<%--
  Created by IntelliJ IDEA.
  User: p
  Date: 2017/5/5
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
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
    </style>
</head>
<body>

<!--
<form method="post" action="/singUp.action">
    <label for="email">邮箱：</label>
    <input name="email" id="email"><br>
    <label for="pwd">密码：</label>
    <input name="pwd" id="pwd"><br>

    <input type="submit" value="提交">
</form>
-->
<c:if test="${not empty message}">
    <h3>${message}</h3>
    <% session.removeAttribute("message"); %>
</c:if>

<div class="main">
    <div class="left">
        <img src="/resources/images/login.jpg" width="500px" height="500px">
    </div>
    <div class="right">
        <form method="post" action="/singUp.action">
            <p>注册</p>
            <input type="text" name="email" placeholder="邮箱地址" style="width: 280px ;height:40px"><br>
            <input type="password" name="pwd"placeholder="密码"  style="width: 280px; height:40px"><br>
            <input type="password" placeholder="再次输入密码"  style="width: 280px; height:40px"><br>
            <input type="submit" value="注册" style="width: 293px;height: 40px"><br>
            <span><a href="/login">已有账户，请登录</a> </span>
        </form>
    </div>
</div>
</body>
</html>
