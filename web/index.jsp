<%--
  Created by IntelliJ IDEA.
  User: p
  Date: 2017/5/2
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>管理员链接</h1>

  <a href="/admin/login">管理员登录</a><br>
  <a href="/admin/logout">管理员登出</a><br>
  <a href="/admin/productors/add">管理员添加商铺</a><br>
  <a href="/admin/productors/index">管理员查看所以商品</a><br>

  <hr>

  <h1>商户链接</h1>

  <a href="/productor?id=2">商铺的公共页面</a><br>
  <br>
  <a href="/productor/login">商户登录</a><br>
  <a href="/productor/logout">商户登出</a><br>
  <a href="/productor/m/edit?id=2">商户修改自己资料页面(只有登录才可以）</a><br>
  <a href="/productor/m/dishes/add?id=2">登录后添加菜肴</a><br>
  <a href="/productor/m/dishes/index?id=2">登录后查看所以已加菜肴</a><br>

  <h1>普通用户</h1>
  <a href="/singUp">注册</a>
  <a href="/login">登录</a>
  <a href="/logout">登出</a>
  <a href="/u/show">用户主页</a>
  <a href="/u/pwd/edit">重置密码</a>
  <a href="/pwd/forget">忘记密码</a>
  <a href="/u/edit">跟新资料</a>

  <h1>站内目录访问图片</h1>
  <img src="/resources/upload/pic/a.jpg">
  <h1>设置虚拟目录访问图片</h1>
  <img src="/pic/a.jpg">

  </body>
</html>
