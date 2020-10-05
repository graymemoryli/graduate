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
简历预览

<%--<div id="main" align="center" >--%>
<%--    <form action="/user/delet_resume" method="post" >--%>
<%--        姓名：<input type="text" name="name" value="${resume.name}">--%>
<%--        求职意向：<input type="text" name="job" value="${resume.job}">--%>
<%--        个人简介:<input type="text" name="self" value="${resume.self}">--%>


<%--        <input type="submit" value="重写填写">--%>

<%--    </form>--%>
<%--    <a href="/user/exit">返回</a>--%>
<%--    <a href="/user/delet_resume">重写填写</a>--%>

<%--</div>--%>

<div style="width: 50%;height: 50%;position: absolute;left: 25%;right: 25%;top:20%">
    <form class="layui-form" action="/user/delet_resume">
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-block">
                <input type="text" name="name" value="${resume.name}" required  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">求职意向</label>
            <div class="layui-input-block">
                <input type="text" name="job" value="${resume.job}" required  lay-verify="required" placeholder="请输入意向" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">个人简历</label>
            <div class="layui-input-block">
                <input type="text" name="self" value="${resume.self}" required  lay-verify="required" placeholder="请输入简历" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <input type="submit"class="layui-btn" lay-filter="formDemo" value="重新填写">
            </div>
        </div>

    </form>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <a  class="layui-btn" lay-filter="formDemo" href="/user/exit">修改</a>
        </div>
    </div>
</div>

</body>
</html>
