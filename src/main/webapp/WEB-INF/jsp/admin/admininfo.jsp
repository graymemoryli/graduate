<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/7
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理员详细信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/student.css">
    <script src="${pageContext.request.contextPath }/static/js/jquery-1.9.1.min.js"></script>
</head>
<body align="center">
<div>管理员${admin.account}你好</div>
<a href="/admin/logout.ad">注销</a>
<%--<div id="main" align="center" >--%>
<%--    <form action="/admin/doEdit" method="post">--%>
<%--&lt;%&ndash;        头像: <img src="${admin.src}"><br>&ndash;%&gt;--%>
<%--        头像：--%>

<%--    <img style="width: 50px;height: 50px" src="${pageContext.request.contextPath}${admin.src}"><br>--%>

<%--        用户名： <input type="text" name="name" value="${admin.account}"><br>--%>
<%--        密码： <input type="text" name="name" value="${admin.password}"><br>--%>

<%--&lt;%&ndash;        地址： <input type="text" name="name" value="${admin.adress.place}"><br>&ndash;%&gt;--%>

<%--&lt;%&ndash;        <fmt:formatDate value="${admin.da}" pattern="yyyy-MM-dd"></fmt:formatDate>&ndash;%&gt;--%>
<%--        <input type="submit" value="提交">--%>
<%--    </form>--%>

<%--<hr>--%>
<%--</div>--%>


<%--<div><a href="/admin/managework.ad">办公管理</a>   </div><br>--%>
<%--<div><a href="/admin/managestudent.ad">毕业生管理</a>   </div><br>--%>
<%--<div><a href="/admin/analysis.ad">数据统计</a>    </div><br>--%>
<%--<div><a href="/admin/leftSchool.ad">离校管理</a>    </div><br>--%>


<div class="container">
    <div class="content" style="height: 50%">


        <div id="main" style="float: left;margin-top: 100px" >


            <span><p>头像</p>
            <img style="width: 50px;height: 50px" src="${pageContext.request.contextPath}${admin.src}"><br>

            用户名： <input type="text" name="name" value="${admin.account}"><br>
            密码： <input type="text" name="name" value="${admin.password}"><br>
            </span>
        </div>
        <div style="float: left;margin-left: 350px;margin-top: 80px" >
            <div><a href="/admin/managework.ad">办公管理</a>   </div><br>
            <div><a href="/admin/managestudent.ad">毕业生管理</a>   </div><br>
            <div><a href="/admin/analysis.ad">数据统计</a>    </div><br>
            <div><a href="/admin/leftSchool.ad">离校管理</a>    </div><br>
        </div>

    </div>
</div>
</body>
</html>
