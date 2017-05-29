<%--
  Created by IntelliJ IDEA.
  User: p
  Date: 2017/5/3
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商户登录</title>
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
<c:if test="${not empty loginMessage}">
    <p> ${loginMessage}</p>
</c:if>
<!--
<form action="/productor/login.action" method="post">
    <label for="email">邮箱</label><br>
    <input name="email" id="email"><br>
    <label for="pwd">密码</label><br>
    <input name ="pwd" id="pwd" type="password"/><br>
    <input type="submit" value="提交">
</form>
-->
<div class="main">
    <div class="left">
        <img src="/resources/images/login.jpg" width="500px" height="500px">
    </div>
    <div class="right">
        <form method="post" action="/productor/login.action">
            <p>商户登录</p>
            <input type="text" name="email" placeholder="邮箱地址" style="width: 280px ;height:40px"><br>
            <input type="password" name="pwd" placeholder="密码"  style="width: 280px; height:40px"><br>
            <input type="submit" value="登录" style="width: 293px;height: 40px"><br>

        </form>
    </div>
</div>

</body>
</html>
