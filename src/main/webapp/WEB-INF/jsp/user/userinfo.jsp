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
<div>学生${user.name}</div>
<a href="/admin/logout.ad">注销</a>
<div class="container">
    <div class="content" style="height: 50%">


        <div id="main" style="float: left;margin-top: 100px" >


        <span><p>头像</p><img style="width: 100px;height: 100px" src="${pageContext.request.contextPath}${user.src}"></span><br>

        <span>用户名： <input type="hidden" name="name" value="${user.name}"></span><br>

        </div>
        <div style="float: left;margin-left: 350px;margin-top: 80px" >
            <a href="/user/info.ad">个人基本信息</a><br><br>
            <a href="/user/resume.ad">个人简介</a><br><br>
            <a href="/user/donews">招聘信息</a><br><br>
            <a href="/user/apply.ad">离校申请</a><br><br>
        </div>

    </div>
</div>




</body>
</html>
