<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: p
  Date: 2017/5/5
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所以菜肴</title>
    <style type="text/css">
        #main{width: 700px;margin:0 auto;}
        .dish{
            width: 350px;
            height: 350px;
            float: left;

        }
    </style>
</head>
<body>
<%@include file="../shared/header.jsp"%>

<a href="/productor/m?id=${productor.id}">返回管理主页</a>   ||
<a href="/productor/m/dishes/add?id=${productor.id}">继续添加</a><br>
<div id="main">
<c:if test="${empty dishes}">
    <p>您还没有添加任何菜肴</p><a href="/productor/m/dishes/add?id=${productor.id}">现在添加？</a>
</c:if>
<c:if test="${not empty dishes}">
<c:forEach items="${dishes}" var="dish">
   <div class="dish">
       <img src="/pic${dish.photoUrl}"/><br>
       <div>
           <span>${dish.name}</span>
           <span>价格:${dish.price}</span>
           <span>主材:${dish.ingredients}</span>
           <span>销量:${dish.sales}</span>
       </div>
       <br>
       <a href="/productor/dishes/edit?id=${dish.id}"><button>编辑</button></a>
       <a href="/productor/dishes/delete?id=${dish.id}"><button>删除</button></a>
   </div>
</c:forEach>
</c:if>
</div>
</body>
</html>
