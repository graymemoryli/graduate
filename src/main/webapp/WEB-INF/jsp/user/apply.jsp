<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020/9/8
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/layui/css/layui.css">
    <script src="${pageContext.request.contextPath }/static/layui/layui.js"></script>
</head>
<body align="center">
离校申请表

<%--<div id="main" align="center" >--%>
<%--    <form action="/user/doapply" method="post" >--%>
<%--&lt;%&ndash;        学号：<input type="text" name="amount">&ndash;%&gt;--%>
<%--        姓名：<input type="text" name="name">--%>
<%--        是否就业：<input type="text" name="employment">--%>
<%--        迁出户籍:<input type="text" name="census">--%>

<%--        <input type="submit" value="提交">--%>

<%--    </form>--%>


<%--</div>--%>

<div style="width: 50%;height: 50%;position: absolute;left: 25%;right: 25%;top:20%">
    <form class="layui-form" action="/user/doapply">
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-block">
                <input type="text" name="name" required  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-block">
                <input type="text" name="employment" required  lay-verify="required" placeholder="是否就业 0：未就业 1：就业" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">迁出户籍</label>
            <div class="layui-input-block">
                <input type="text" name="census" required  lay-verify="required" placeholder="迁出户籍地" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <input type="submit"class="layui-btn" lay-filter="formDemo" value="提交">
            </div>
        </div>
    </form>
</div>

</body>
</html>
