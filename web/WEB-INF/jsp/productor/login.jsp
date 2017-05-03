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
</head>
<body>
<c:if test="${not empty loginMessage}">
    <p> ${loginMessage}</p>
</c:if>
<form action="/productor/login.action" method="post">
    <label for="email">邮箱</label><br>
    <input name="email" id="email"><br>
    <label for="pwd">密码</label><br>
    <input name ="pwd" id="pwd" type="password"/><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
