<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: p
  Date: 2017/5/29
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>仲恺外卖</title>
    <script type="text/javascript">
        function show(){
            document.getElementById("hide").style.display = "block";
        }
        function hide(){
            document.getElementById("hide").style.display = "none";
        }
    </script>
    <style type="text/css">
        *{padding: 0;margin:0;}
        html{
            overflow-x:hidden;
        }
        .mainbody{width: 1368px;background-color: #F6F6F1}
        .mid{
            width: 1200px;
            margin: 20px auto;
            border:1px solid #F0EFEF;
            background-color: #FFFFFF;
        }

        ul.nav{width: 1368px;height: 50px;background-color: #1e89e0;margin: 0 auto}
        ul.nav li{display: inline;height: 10px;}
        ul.nav li a{
            display:inline-block;
            padding:0 30px;
            height:20px;
            line-height:50px;
            color:#F6F3F3;
            text-decoration: none;
            font-size:17px
        }
        ul.nav .user{display:inline-block; float: right;margin-right: 30px}
        /*ul.nav .user a{font-size: 16px;padding-left: 10px}*/

        .nav li ul#hide{
            display:inline-block;
            position: relative;
            top: 15px;
            right: -20px;
            width: 120px;
            height: 80px;
            background-color: #1e89e0;
            display: none;
        }

        .nav li ul#hide li a{
            color:#F6F3F3;
            font-size: 15px;
            line-height: 10px
        }

        .store{
            display: inline-block;
            cursor: pointer;
            width: 295px;
            height: 110px;
        }
        .store img{border:1px solid #EDE4E4;}
        .store:hover{background-color: #F6F6F1}
        .image{float: left;}
        .name a{text-decoration: none;font-size: 17px;color:#313131}
        .tips span{font-size: 10px;color: #A29F9F}
        .content{
            display: inline-block;
            line-height: 48px;
            margin-left: 15px;
        }


        .foot .col{
            width: 300px;
            display: inline-block;
            float: left
        }
        .foot{
            width: 1200px;
            display: inline-block;
            background-color:#FFFFFF;
            position: relative;
            top:50px;
            left: 50px;
            padding: 30px
        }
        ul.nav2 li{list-style: none;color:#666;font-size: 13px;line-height: 20px}
        ul.nav2 li a{
            text-decoration: none;
            line-height: 30px;
            color:#666;
            font-size: 13px;
            margin-left:10px;
        }

    </style>

</head>
<body>
<div class="mainbody">
    <%@include file="shared/header.jsp"%> 

    <div class="mid">
        <c:if test="${not empty productors}">
            <c:forEach items="${productors}" var="productor">
                <div class="store">
                    <div class="image">
                        <a href="/productor?id=${productor.id}"><img src="/pic${productor.photo}" width="90px" height="90px"></a>
                    </div>
                    <div class="content">
                        <div class="name">
                            <a href="/productor?id=${productor.id}">${productor.name}</a>
                        </div>
                        <div class="tips">
                            <span>配送费￥9</span>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </c:if>
    </div>

    <div class="foot">
        <div class="col">
            <ul class="nav2">帮助
                <li><a href="">建议与反馈</a></li>
                <li><a href="">使用帮助</a></li>
                <li><a href="">常见问题</a></li>
                <li><a href="">用户协议</a></li>
                <li><a href="">权利声明</a></li>
            </ul>
        </div>
        <div class="col">
            <ul class="nav2">关于我们
                <li><a href="">官方论坛</a></li>
                <li><a href="">新浪微博</a></li>
                <li><a href="">关于我们</a></li>
                <li><a href="">微信平台</a></li>
                <li><a href="">平台制度</a></li>
            </ul>
        </div>
        <div class="col">
            <ul class="nav2">商务合作
                <li><a href="">商户入驻</a></li>
                <li><a href="">代理合作</a></li>
            </ul>
        </div>
        <div class="col">
            <ul class="nav2">客服热线
                <li>020-00000000</li>
                <li>周一至周日9：00-22:00</li>
            </ul>
        </div>
    </div>
</div>

</body>
</html>
