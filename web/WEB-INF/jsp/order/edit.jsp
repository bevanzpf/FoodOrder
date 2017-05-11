<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: p
  Date: 2017/5/10
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑订单</title>
</head>
<body>
<%@include file="../shared/header.jsp"%>


<c:if test="${empty orderVo|| empty orderVo.orderCustoms}">
    <p>购物车空空如也！</p>
</c:if>
<c:if test="${not empty orderVo.orderCustoms}">
<form method="post" action="/u/order/edit.action">
   <table>
       <c:forEach var="orderCustom" items="${orderVo.orderCustoms}">
           <tr>
               <td>店家：${orderCustom.productor.name}</td>
               <td>商品：${orderCustom.dish.name}</td>
               <td>数量：<button class="plus"><a href="/car/item/plus?dishId=${orderCustom.dish.id}">+</a></button><input name="acount" value="${orderCustom.acount}"><button class="minus"><a href="/car/item/minus?dishId=${orderCustom.dish.id}">-</a></button></td>
               <input type="hidden" name="productorId" value="${orderCustom.productor.id}">
               <input type="hidden" name="dishId" value="${orderCustom.dish.id}">
           </tr>
       </c:forEach>
       <tr><td>收货地址：<input name="address" value="${user.address}"></td></tr>
       <tr><td>价格：${orderVo.money} 元</td></tr>
   </table>
   <input type="submit" value="提交">
</form>
</c:if>
</body>
</html>
