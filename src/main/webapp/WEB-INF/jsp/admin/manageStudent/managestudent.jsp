
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/layui/css/layui.css">
    <script src="${pageContext.request.contextPath }/static/layui/layui.js"></script>
</head>
<body align="center">
毕业生管理

<%--<div id="main" align="center" >--%>

<%--    <a href="/admin/doinfo"> 毕业生基本信息  </a>--%>
<%--    <a href="">  档案管理</a>--%>
<%--    --%>
<%--</div>--%>

<div style="width: 50%;height: 50%;position: absolute;left: 25%;right: 25%;top:20%">

<span class="layui-breadcrumb" style="color: #009688;">
    <a style="font-size: 20px" href="/admin/doinfo"> 毕业生基本信息  </a>
    <a style="font-size: 20px" href=""> 档案管理  </a>


        <script>
//注意：导航 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
    var element = layui.element;

    //…
});
</script>
</span>
</div>

</body>
</html>
