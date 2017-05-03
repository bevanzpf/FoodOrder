<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%--
  Created by IntelliJ IDEA.
  User: p
  Date: 2017/5/3
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有商铺</title>
</head>
<body>
<table border="3px">
    <th>店铺名</th>
    <th>Email</th>
    <th>删除?</th>
    <c:if test="${not empty productors}">
        <c:forEach var="pro" items="${productors}">
            <tr><td>${pro.name}</td><td>${pro.email}</td><td><a href="/admin/productors/delete?id=${pro.id}">删除</a></td></tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>
