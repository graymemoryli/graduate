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
    <title>管理员注册</title>
    <script src="/src/main/resources/static/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<div id = "main" align="center">
    <form action="/admin/doregist" method="post" enctype="multipart/form-data">
        管理员账号：<input type="text" name="account"><br><br>
        密码：<input type="text" name="password"><br><br>


        <div>

            用户图像：<input id="userface" name="uploadFile" type="file" onchange="preview(this)" ><br>
            <div id="preview" style="width: 5%;height: 5%"></div>
            <input type="button" id="btnClick" value="上传">
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

        <input type="submit" value="提交">
    </form>



</div>


</body>
</html>
