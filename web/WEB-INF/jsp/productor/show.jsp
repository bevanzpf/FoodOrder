<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: p
  Date: 2017/5/3
  Time: 23:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${productor.name}</title>
    <script style="text/javascript" src="/resources/js/jquery-3.2.1.min.js"></script>
    <!--<script style="text/javascript" src="/resources/js/add2car.js"></script>
    -->
    <link rel="stylesheet" type="text/css" href="/resources/css/productorshow.css">
    <style type="text/css">
        #load{
            clear: both;
        }
        #load li{
            margin: 0 auto;
        }
        #load li a{
            text-decoration: none;
        }
        .dishes #title{
            width: auto;
            float: left;
        }
        .dishes #search{
            width: auto;
            float:right;
            line-height: 40px;
        }
    </style>
    <!--
     -->
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
<script type="text/javascript">
var stop=false;//触发开关，防止多次调用事件
<c:if test="${not empty dishes}">
var url = "/productor/getpage?productorId=${productor.id}&maxId=${dishes.get(dishes.size()-1).id}";
</c:if>
$(window).scroll( function(event){
if ($(this).scrollTop() + $(window).height() + 1 >= $(document).height() && $(this).scrollTop() > 10 && stop == false) {
    stop = true;
    $("#load").append("<li class='ajaxtips'><div style='font-size:2em'>Loding…..</div>");
    setTimeout(function () {
        $.get(url, function (data) {
            if (data == "0") {
                $("#load").find("li").html('已全部加载完');
                return;
            }
            $("#load").remove();
            $("#dishes").find("#dish").append(data);
            var maxId = $("#dish").children(":last-child").find("#maxId").html();
            $("#dishes").append("<div></div>");
            $("#dishes").children(":last-child").attr("id", "load");
            $("#dishes").children(":last-child").attr("style", "clear:both");
            var productorId = $("#productorId").html();
            url = "/productor/getpage?productorId=" + productorId + "&maxId=" + maxId;
            stop = false;

        });
    }, 2000);

}
});

</script>
<script type="text/javascript">
$(document).ready(function(){
        $('#search').find('button').click(function(){
            var searchKey = $('#searchKey').val();
            var url = "/productor/dish/search?productorId=${productor.id}&searchKey="+searchKey;
            url = encodeURI(url);
            url = encodeURI(url);
            $('#dish').load(url);
        });
    });
</script>
</head>
<body>

<%@include file="../shared/header.jsp"%>


<span id="productorId" style="display: none">${productor.id}</span>
<div class="container">
    <div class="productor">
        <div class="image"><img src="/pic${productor.photo}"></div><!-- end image -->
        <div class="Logo">
            <div class="logos">
                <span class="cn_logo">${productor.name}</span>
                <span class="En_logo">${productor.enName}</span>
            </div><!-- end logos -->
        </div><!-- end logo -->
        <div class="right">
            <div class="sellInfo"><span class="key">经营时间：</span><span class="value">${productor.openTime}</span></div><!--end sellInfo -->
            <div class="quote">"${productor.info}"</div><!-- end quote -->
        </div><!-- end right -->

    </div><!-- end productor -->


    <div class="menus">
        <div class="dishes" id="dishes">
            <div class="category">
                <div class="bar"></div>
                <div id="title"><span>招牌美食</span></div>
                <div id="search">
                    <input id="searchKey" name="searchKey">
                    <button id="sbtn">搜索</button>
                </div>
            </div><!--end category -->
            <c:if test="${empty dishes}">
                <p>小店初来乍到，还没有来得及添加菜肴敬请期待!</p>
            </c:if>
<c:if test="${not empty dishes}">
    <div id="dish">
    <c:forEach items="${dishes}" var="dish">
            <div class="dish" >
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
                    <span class="add"><a id="link" href="/addDish2Car.action?id=${dish.id}"></a>下单</span>
                    <span><a href="#">评论</a></span>
                    <span><a href="#">收藏</a> </span>
                </div><!-- end operation -->
            </div><!-- end dish -->
    </c:forEach>
    </div> <!-- end id dish -->

    <div id="load" style="clear: both;"></div>
</c:if>
        </div><!-- end dishes -->
     </div><!-- end menus -->

    <div class="car">
        <div class="num"><span><a href="/order/edit">${itemTotal}</a></span></div>
        <div class="image"><a href="/order/edit"><img src="/resources/images/car.jpg"></a></div>
    </div><!--end car -->

    </div>
</body>
</html>
