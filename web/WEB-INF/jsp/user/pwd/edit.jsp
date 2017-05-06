<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: p
  Date: 2017/5/6
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
</head>
<body>
<c:if test="${not empty message}">
    <p>${message}</p>
    <% session.removeAttribute("message");%>
</c:if>
<form method="post" action="/u/pwd/edit.action">
    <label for="oldPwd">旧密码</label>
    <input name="oldPwd" id="oldPwd"/><br>
    <label for="newPwd">新密码</label>
    <input name="newPwd" id="newPwd"/>

    <input type="submit" value="提交"/>
</form>
</body>
</html>
