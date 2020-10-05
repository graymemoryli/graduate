<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020/9/8
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/student.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/layui/css/layui.css">
    <script src="${pageContext.request.contextPath }/static/layui/layui.js"></script>
    <script src="${pageContext.request.contextPath }/static/layui/css/layui.css"></script>
</head>
<body>
<%--<div class="container">--%>
<%--    <div class="content">--%>

<%--        <div class="main">--%>
<%--            <!--基础信息-->--%>
<%--            <div class="BasicInformation">--%>
<%--                <div class="title">--%>
<%--                    基础信息--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="content clearfix">--%>

<%--                <form action="/user/doinfo" method="post">--%>
<%--                    <div class="left fl">--%>
<%--                        <div>--%>
<%--                            <label >姓名：</label>--%>
<%--                            <input id="stu_name" type="text" name="name">--%>
<%--                        </div>--%>
<%--                        <div>--%>
<%--                            <label >性别：</label>--%>
<%--                            <input id="birthday" type="text" name="sex">--%>
<%--                        </div>--%>
<%--                        <div>--%>
<%--                            <label >学院：</label>--%>
<%--                            <input id="college" type="text" name="college">--%>
<%--                        </div>--%>
<%--                        <div>--%>
<%--                            <label >专业：</label>--%>
<%--                            <input id="idNumber" class="id oInp" type="text" name="major">--%>
<%--                        </div>--%>
<%--                        <div>--%>
<%--                            就业状态:  0:未就业  1：签约   2:就业--%>
<%--                            <label >就业状态：</label>--%>
<%--                            <input id="xstu_id" type="text" name="sta" >--%>
<%--                        </div>--%>

<%--                        <input style="width: 50px;height: 50px"  type="submit" value="提交">--%>

<%--                        <a style="width: 50px;height: 50px" href="/user/update.ad">修改</a>--%>


<%--                    </div>--%>

<%--                </form>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<div style="width: 50%;height: 50%;position: absolute;left: 25%;right: 25%;top:20%">
<form class="layui-form" action="/user/doinfo">

    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-block">
            <input type="text" name="name" required  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
        </div>
    </div>



    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
            <input type="text" name="sex" required  lay-verify="required" placeholder="请输入性别" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">学院</label>
        <div class="layui-input-block">
            <input type="text" name="college" required  lay-verify="required" placeholder="请输入学院" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">专业</label>
        <div class="layui-input-block">
            <input type="text" name="major" required  lay-verify="required" placeholder="请输入专业" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">就业状态：</label>
        <div class="layui-input-block">
            <input type="text" name="sta" required  lay-verify="required" placeholder="就业状态：0:未就业 1:签约  2:就业" autocomplete="off" class="layui-input">
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-input-block">
            <input type="submit"class="layui-btn" lay-filter="formDemo" value="提交">
        </div>
    </div>
</form>
<div class="layui-form-item">
    <div class="layui-input-block">
        <a  class="layui-btn" lay-filter="formDemo" href="/user/update.ad">修改</a>
    </div>
</div>
</div>
</body>
</html>