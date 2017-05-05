<%--
  Created by IntelliJ IDEA.
  User: p
  Date: 2017/5/3
  Time: 23:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${productor.name}</title>
</head>
<body>
<h1>商户:${productor.name} 的公共页面</h1>

<div class="profile" width="100%" hight="300px">
    <div>${productor.name}</div>
    <img src="/${productor.photo}"/>
    <div>${productor.info}</div>
    <div>${productor.isOn}</div>
</div>

<div class="dishes">
<%@include file="../shared/dishes.jsp"%>
</div>
</body>
</html>
