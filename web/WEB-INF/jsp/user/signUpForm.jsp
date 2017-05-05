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
</head>
<body>
<form method="post" action="/singUp.action">
    <label for="email">邮箱：</label>
    <input name="email" id="email"><br>
    <label for="pwd">密码：</label>
    <input name="pwd" id="pwd"><br>

    <input type="submit" value="提交">
</form>

</body>
</html>
