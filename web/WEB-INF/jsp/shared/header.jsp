<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: p
  Date: 2017/5/11
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/resources/css/header.css">
</head>
<div class="header">
    <div class="container">
        <span class="main"><a href="/">首页</a></span>
        <c:if test="${empty sessionScope.user}">
            <span class="right"><a href="/signUp">注册</a></span>
            <span class="right"><a href="/login">登录</a></span>
        </c:if>
        <c:if test="${not empty sessionScope.user}">
            <span class="right"><a href="/logout">注销</a></span>
            <span class="right"><a href="/u/show">我的主页</a></span>
        </c:if>
        <c:if test="${not empty sessionScope.productor}">
            <span class="right"><a href="/productor/logout">注销</a></span>
            <span class="right" ><a href="/productor/m">商户主界面</a></span>
        </c:if>
    </div>
</div><!-- end header -->
</html>
