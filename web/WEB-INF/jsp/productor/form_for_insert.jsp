<%--
  Created by IntelliJ IDEA.
  User: p
  Date: 2017/5/3
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商户</title>
</head>
<body>

<form method="post" action="/admin/productors/add.action">
    <label for="name">餐厅名</label>
    <input name="name" id="name"><br>
    <label for="email">商户邮箱</label>
    <input name="email" id="email"><br>
    <label for="pwd">初始密码</label>
    <input name="pwd" id="pwd"><br>
    <input type="submit" value="提交">
</form>

</body>
</html>
