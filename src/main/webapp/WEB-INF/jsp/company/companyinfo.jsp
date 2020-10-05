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
    <title>学生详细信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/student.css">
    <script src="${pageContext.request.contextPath }/static/js/jquery-1.9.1.min.js"></script>
</head>
<body align="center">
<div>学生${company.name}你好</div>
<a href="/admin/logout.ad">注销</a>
<%--<div id="main" align="center" >--%>
<%--    <form action="/admin/doEdit" method="post">--%>

<%--        头像：--%>

<%--        <img style="width: 50px;height: 50px" src="${pageContext.request.contextPath}${company.src}"><br>--%>

<%--        用户名： <input type="text" name="name" value="${company.name}"><br>--%>


<%--        <input type="submit" value="提交">--%>
<%--    </form>--%>

<%--    <hr>--%>
<%--</div>--%>

<%--<a href="/company/news.ad">招聘信息发布</a>--%>
<%--<a href="/company/college">院系介绍</a>--%>
<%--<a href="/company/search">人才搜索</a>--%>

<div class="container">
    <div class="content" style="height: 50%">


        <div id="main" style="float: left;margin-top: 100px" >


            <span><p>头像</p>
            <img style="width: 50px;height: 50px" src="${pageContext.request.contextPath}${company.src}"><br>

            用户名： <input type="text" name="name" value="${company.name}"><br>

        </div>
        <div style="float: left;margin-left: 350px;margin-top: 80px" >
            <a href="/company/news.ad">招聘信息发布</a><br><br>
            <a href="/company/college">院系介绍</a><br><br>
            <a href="/company/search">人才搜索</a><br><br>
        </div>

    </div>
</div>



</body>
</html>
