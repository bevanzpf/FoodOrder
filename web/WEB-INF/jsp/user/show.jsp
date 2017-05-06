<%--
  Created by IntelliJ IDEA.
  User: p
  Date: 2017/5/6
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${user.name}</title>
</head>
<body>
<%@include file="../shared/message.jsp"%>
<h1>用户${user.name}的主页</h1>
<a href="/login">登录</a>
<a href="/logout">登出</a>
<a href="/u/pwd/edit">重置密码</a>
<a href="/u/edit">跟新资料</a>
</body>
</html>
