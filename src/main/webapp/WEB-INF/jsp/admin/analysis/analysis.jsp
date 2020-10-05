
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/layui/css/layui.css">
    <script src="${pageContext.request.contextPath }/static/layui/layui.js"></script>
</head>
<body align="center">
数据统计

<%--<div id="main" align="center" >--%>

<%--    <a href="/admin/sign.ad"> 签约情况  </a>--%>
<%--    <a href="/admin/employment.ad"> 就业情况  </a>--%>
<%--    <a href="/admin/employ_rate.ad"> 就业率  </a>--%>
<%--</div>--%>
<div style="width: 50%;height: 50%;position: absolute;left: 25%;right: 25%;top:20%">

<span class="layui-breadcrumb" style="color: #009688;">
    <a style="font-size: 20px" href="/admin/sign.ad"> 签约情况  </a>
    <a style="font-size: 20px" href="/admin/employment.ad"> 就业情况  </a>
    <a style="font-size: 20px" href="/admin/employ_rate.ad"> 就业率  </a>

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
