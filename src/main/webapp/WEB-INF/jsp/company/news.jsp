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
招聘信息

<%--<div id="main" align="center" >--%>
<%--    <form action="/company/donews" method="post" >--%>
<%--        &lt;%&ndash;        学号：<input type="text" name="amount">&ndash;%&gt;--%>
<%--        企业名称：<input type="text" name="name">--%>
<%--            公司地点：<input type="text" name="location">--%>
<%--        招聘工作:<input type="text" name="job">--%>
<%--        工作类型:<input type="text" name="job_type">--%>
<%--        工作薪水:<input type="text" name="job_salary">--%>
<%--        工作地点:<input type="text" name="job_location">--%>
<%--        <input type="submit" value="提交">--%>

<%--    </form>--%>


<%--</div>--%>

<div style="width: 50%;height: 50%;position: absolute;left: 25%;right: 25%;top:20%">
    <form class="layui-form" action="/user/doinfo">
        <div class="layui-form-item">
            <label class="layui-form-label">公司名称</label>
            <div class="layui-input-block">
                <input type="text" name="name" required  lay-verify="required" placeholder="请输入公司名称" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">公司地点</label>
            <div class="layui-input-block">
                <input type="text" name="location" required  lay-verify="required" placeholder="公司地点" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">招聘工作</label>
            <div class="layui-input-block">
                <input type="text" name="job" required  lay-verify="required" placeholder="招聘工作" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">工作类型</label>
            <div class="layui-input-block">
                <input type="text" name="job_type" required  lay-verify="required" placeholder="工作类型" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">薪资</label>
            <div class="layui-input-block">
                <input type="text" name="job_salary" required  lay-verify="required" placeholder="薪资" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">工作地点</label>
            <div class="layui-input-block">
                <input type="text" name="job_location" required  lay-verify="required" placeholder="工作地点" autocomplete="off" class="layui-input">
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
