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
    <title>离校管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/layui/css/layui.css">
    <script src="${pageContext.request.contextPath }/static/layui/layui.js"></script>
</head>
<body align="center">


<hr>

<div style="width: 50%;height: 50%;position: absolute;left: 25%;right: 25%;top:20%">
    申请离校学生表
    <table class="layui-table">
        <colgroup>
            <col width="150">
            <col width="200">
            <col>
        </colgroup>
        <td>学号</td><td>姓名</td><td>性别</td><td>学院</td><td>专业</td><th>操作</th>
        <tbody>
        <c:forEach var="info" items="${leftList}">
        <tr>
            <td>${info.amount}</td>
            <td>${info.name}</td>
            <td>${info.employment}</td>
            <td>${info.census}</td>
            <td><a href="">同意离校</a> </td>

            </c:forEach>
        </tr>
        </tbody>
    </table>

</div>

</body>
</html>
