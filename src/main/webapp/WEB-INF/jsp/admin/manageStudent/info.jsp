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
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/layui/css/layui.css">
    <script src="${pageContext.request.contextPath }/static/layui/layui.js"></script>
</head>
<body align="center">
学生个人基本信息

<div style="width: 50%;height: 50%;position: absolute;left: 25%;right: 25%;top:20%">
    <div>
        学生信息
        <table class="layui-table">
            <colgroup>
                <col width="150">
                <col width="200">
                <col>
            </colgroup>
            <td>学号</td><td>姓名</td><td>性别</td><td>学院</td><td>专业</td>
            <tbody>
            <c:forEach var="info" items="${infoList}">
            <tr>
                <td>${info.account}</td>
                <td>${info.name}</td>
                <td>${info.sex}</td>
                <td>${info.college}</td>
                <td>${info.major}</td>


                </c:forEach>
            </tr>
            </tbody>
        </table>

    </div>

</div>

</body>
</html>
