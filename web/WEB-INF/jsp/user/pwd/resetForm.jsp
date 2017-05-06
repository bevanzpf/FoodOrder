<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: p
  Date: 2017/5/6
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>重置密码</title>
</head>
<body>

<h1>密码重置</h1>
<%@include file="../../shared/message.jsp"%>
<form method="post" action="/pwd/reset.action">
    <input type="hidden" value="${email} " name="email">
    <input type="hidden" value="${token}" name="token">
    <label for="newPwd"></label>
    <input type="password" name="newPwd" id="newPwd">
    <label for="newPwdConfirm" >再次输入</label>
    <input type="password" id="newPwdConfirm" name="newPwdConfirm">
    <input type="submit" value="确定">
</form>
</body>
</html>
