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
    <title>学生登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/main.css" type="text/css" />
</head>
<body align="center">
学生登录页面

<div id="login">
    <div class="cover">
    </div>
    <!-- 登陆框 -->
    <div class="login-form">

    </div>
    <div class="logo">
        <h1>学生登录</h1>
        <form action="/user/dologin.ad">
            <div class="forms">
                <h3 class="login-head">登陆</h3>
                <div class="forms-group">

                    <p>学生账号</p>
                    <input class="form-controls userPhone" type="text" placeholder="请输入学号！" name="account">
                    <p class="text-error text-error-phe"></p>
                </div>
                <div class="forms-group">
                    <p>密码</p>
                    <input class="form-controls getPassWord" type="password" placeholder="请输入密码" name="password">
                    <p class="text-error text-error-pas"></p>
                </div>
                <div class="forms-group">
                    <button style="background: #009688" class="forms-btn">登陆</button>


                </div>
            </div>
        </form>
    </div>
</div>




</body>
</html>
