<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020/9/8
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>应聘信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/layui/css/layui.css">
    <script src="${pageContext.request.contextPath }/static/layui/layui.js"></script>
</head>
<body align="center">
投递简历学生信息

<div id="main" align="center" >
    <div>
        学生信息
        <table class="layui-table">
            <colgroup>
                <col width="150">
                <col width="200">
                <col>
            </colgroup>
            <thead>
            <tr>
            <td>学号</td><td>姓名</td><td>性别</td><td>学院</td><td>专业</td><td>签约</td><td>确认招聘</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="info" items="${searchList}">
            <tr>
                <td>${info.account}</td>
                <td>${info.name}</td>
                <td>${info.sex}</td>
                <td>${info.college}</td>
                <td>${info.major}</td>
                <td>
                    <form action="/company/sign" method="post">
                        <input type="hidden" name="account" value="${info.account}">
                        <input type="submit" value="签约">

                    </form>

                </td>
                <td>
                    <form action="/company/zhaopin" method="post">
                        <input type="hidden" name="account" value="${info.account}">
                        <input type="submit" value="招聘">

                    </form>

                </td>
            </tr>
                </c:forEach>
            </tbody>
        </table>

    </div>

</div>

</body>
</html>
