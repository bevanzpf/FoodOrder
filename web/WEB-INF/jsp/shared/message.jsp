<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: p
  Date: 2017/5/6
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<c:if test="${not empty message}">
    <p>${message}</p>
    <% session.removeAttribute("message"); %>
</c:if>
</body>
</html>
