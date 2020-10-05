<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020/9/7
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生注册</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/main.css" type="text/css" />
    <script src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<%--<div id = "main" align="center">--%>
<%--    <form action="/user/doregist" method="post" enctype="multipart/form-data">--%>
<%--        账号：<input type="text" name="user"><br><br>--%>
<%--        姓名:<input type="text" name="name"><br><br>--%>
<%--        密码：<input type="text" name="pwd"><br><br>--%>
<%--        头像：<input type="file" name="uploadFile"><br><br>--%>

        <div id="login">
            <div class="cover">
            </div>
            <!-- 注册框 -->
            <div class="login-form">

            </div>
            <div class="logo">
                <h1>学生注册</h1>
                <form action="/user/doregist" method="post" enctype="multipart/form-data">
                    <div class="forms">
                        <div class="forms-group">

                            <p>学生账号</p>
                            <input class="form-controls userPhone" type="text" placeholder="请输入账号！" name="user">
                            <p class="text-error text-error-phe"></p>
                        </div>

                        <div class="forms-group">
                            <p>姓名</p>
                            <input class="form-controls getPassWord" type="text" placeholder="请输入姓名" name="name">
                            <p class="text-error text-error-pas"></p>
                        </div>

                        <div class="forms-group">
                            <p>密码</p>
                            <input class="form-controls getPassWord" type="password" placeholder="请输入密码" name="pwd">
                            <p class="text-error text-error-pas"></p>
                        </div>
                            <div>
                                用户图像：<input id="userface" name="uploadFile" type="file" onchange="preview(this)" >
                                <div id="preview" style="width: 5%;height: 5%"></div>
                                <%--            <input type="button" id="btnClick" value="上传">--%>
                                <script>
                                    $("#btnClick").click(function () {
                                        var formData = new FormData();
                                        formData.append("username", $("#username").val());
                                        formData.append("file", $("#userface")[0].files[0]);
                                        $.ajax({
                                            url: '/fileupload',
                                            type: 'post',
                                            data: formData,
                                            processData: false,
                                            contentType: false,
                                            success: function (msg) {
                                                alert(msg);
                                            }
                                        });
                                    });
                                    function preview(file) {
                                        var prevDiv = document.getElementById('preview');
                                        if (file.files && file.files[0]) {
                                            var reader = new FileReader();
                                            reader.onload = function (evt) {
                                                prevDiv.innerHTML = '<img style="width: 50px;height: 50px" src="' + evt.target.result + '" />';
                                            }
                                            reader.readAsDataURL(file.files[0]);
                                        } else {
                                            prevDiv.innerHTML = '<div class="img" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\' "></div>';
                                        }
                                    }
                                </script>

                            </div>
                        <br>
                        <br>

                        <div class="forms-group">

                            <input style="background: #009688" class="forms-btn" type="submit" value="注册">
                        </div>
                    </div>
                </form>
            </div>
        </div>







<%--        <input type="submit" value="提交">--%>
<%--    </form>--%>

<%--</div>--%>
</body>
</html>
