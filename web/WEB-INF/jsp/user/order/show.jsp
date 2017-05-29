<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: p
  Date: 2017/5/11
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的订单</title>
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

<div id="order">
    <h1>全部订单</h1>
    <table>
      <tbody><tr><th>商家</th><th>菜肴</th><th>状态</th><th>商家电话</th><th>退单</th>
      <c:if test="${not empty orderCustoms}">
            <c:forEach items="${orderCustoms}" var="orderCustom">
                <tr>
                <td>${orderCustom.productor.name}</td>
                <td>${orderCustom.dish.name}</td>
                <td>${orderCustom.state}</td>
                <td>${orderCustom.productor.phone}</td>
                <td><button><a href="/u/order/cancel?id=${orderCustom.id}">退订</a> </button></td>
                </tr>
            </c:forEach>
      </c:if>
    </tbody>
    </table>
</div>
</body>
</html>
