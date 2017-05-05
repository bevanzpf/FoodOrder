<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: p
  Date: 2017/5/5
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<c:if test="${empty dishes}">
    <p>小店初来乍到，还没有来得及添加菜肴敬请期待!</p>
</c:if>
<c:if test="${not empty dishes}">
    <c:forEach items="${dishes}" var="dish">
        <div class="dish">
            <img src="/${dish.photoUrl}"/><br>
            <div>
                <span>${dish.name}</span>
                <span>价格:${dish.price}</span>
                <span>主材:${dish.ingredients}</span>
                <span>销量:${dish.sales}</span>
            </div>
        </div>
    </c:forEach>
</c:if>
</body>
