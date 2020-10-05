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
企业招聘信息

<div id="main" align="center" >
    <div>
        招聘信息
        <table class="layui-table">
            <colgroup>
                <col width="150">
                <col width="200">
                <col>
            </colgroup>
            <thead>
            <tr>
                <th><td>公司名称</td><td>公司地点</td><td>工作</td><td>工作类型</td><td>薪资</td><td>工作地点</td></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="info" items="${newsList}">
            <tr>

                <td>${info.name}</td>
                <td>${info.location}</td>
                <td>${info.job}</td>
                <td>${info.job_type}</td>
                <td>${info.job_salary}</td>
                <td>${info.job_location}</td>
                <td>
                    <form action="/user/sendResume" method="post">
                        <input type="hidden" name="account" value="${info.account}">
                        <input type="submit" value="投递简历">

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
