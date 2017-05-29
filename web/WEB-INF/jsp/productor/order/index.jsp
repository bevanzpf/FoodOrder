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
    <style type="text/css">
        #order{
            width:800px;
            border:1px solid #EDE4E4;
            margin:20 auto;
            padding-left: 60px;
            padding-top:10px;
            padding-bottom: 40px;
        }
        #order h1{
            font-size: 18px;
        }
        table{border-collapse: collapse;}
        table th{
            background-color: #eee;
            width: 140px;
            height: 35px;
        }
        table td{
            width: 140px;
            height: 70px;
            padding: 2px;
            text-align:center;
            border-bottom:1px dashed #ccc;
        }
        table td button a{text-decoration: none;color: #000}
    </style>
</head>
<body>
<%@include file="../../shared/header.jsp"%>
<c:if test="${empty orderCustoms}">
    <p> 您还没有订单</p>
</c:if>
<div id="order">
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
</div>

</body>
</html>
