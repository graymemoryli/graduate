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
    <title>就业率</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/layui/css/layui.css">
    <script src="${pageContext.request.contextPath }/static/layui/layui.js"></script>
</head>
<body align="center">


<hr>

<div>
    <span>本年未就业人数${rate.unemploy}</span>
    <span>本年就业人数${rate.employ}</span>
    <span>本年就业率${rate.rare}</span>
</div>

</body>
</html>
