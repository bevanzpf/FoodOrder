<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: p
  Date: 2017/5/16
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>待处理订单</title>
</head>
<body>
<c:if test="${empty orderCustoms}">
    <p> 您还没有订单</p>
</c:if>
<table>
    <th>菜肴</th><th>配送地址</th><th>顾客昵称</th><th>顾客电话</th><th></th><th></th>
    <c:forEach items="${orderCustoms}" var="orderCustom">
        <tr>
            <td>${orderCustom.dish.name}</td>
            <td>${orderCustom.address}</td>
            <td>${orderCustom.user.name}</td>
            <td>${orderCustom.user.phone}</td>
            <td><button><a href="/productor/order/finish?id=${orderCustom.id}">接单</a></button></td>
            <td><button><a href="/productor/order/reject?id=${orderCustom.id}">回拒</a></button></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
