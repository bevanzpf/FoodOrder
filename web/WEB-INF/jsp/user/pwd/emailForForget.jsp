<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: p
  Date: 2017/5/6
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>忘记密码</title>
</head>
<body>
<c:if test="${not empty message}">
    <p>${message}</p>
    <% session.removeAttribute("message");%>
</c:if>
<h1>输入登录邮箱后我们会发送重置信息</h1>
<form method="post" action="/pwd/forget.action">
    <label for="email">邮箱</label>
    <input name = "email" id="email">
    <input type="submit" value="确定">
</form>
</body>
</html>
