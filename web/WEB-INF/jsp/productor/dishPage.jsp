<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: p
  Date: 2017/6/12
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script type="text/javascript">
    var getByAjax = function(urll){
        $.get({
            url: urll,
            success: function(data){
                var num = $(".num").children("span").text();
                var num1 = Number(num)+1;
                $(".num").fadeOut(300);
                $(".num").children("span").text(num1);
                $(".num").fadeIn(300);
            }
        });
    }


    $(document).ready(function(){
        $('#dish').find('.add').click(function () {
            var url = $(this).find("#link").attr("href");
            getByAjax(url);
        });
    });
</script>
<body>
<c:forEach items="${dishes}" var="dish">
    <div class="dish">
        <spap style= "display:none" id="maxId">${dish.id}</spap>

        <div class="above">
            <div class="image"><img  src="/pic${dish.photoUrl}"/></div><!-- end image -->
            <div class="info">
                <div class="name">${dish.name}</div>
                <div class="otherInfo"><span class="key">主材：</span><span class="value"> ${dish.ingredients}</span></div>
                <div class="otherInfo"><span class="key">价格：</span><span class="value">${dish.price} 元</span></div>
                <div class="otherInfo"><span class="key">销量：</span><span class="value">${dish.sales}</span></div>
            </div><!-- end info -->
        </div> <!-- end above -->
        <div class="operation">
            <span class="add"><a id="link" href="/addDish2Car.action?id=${dish.id}" ></a>下单</span>
            <span><a href="#">评论</a></span>
            <span><a href="#">收藏</a> </span>
        </div><!-- end operation -->
    </div><!-- end dish -->
</c:forEach>

</body>
</html>
