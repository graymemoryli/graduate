<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head >
    <meta charset="UTF-8" >
    <title>智慧校园门户</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/school_index.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/school_index.js"></script>
    <script type="text/javascript">

        var imgs =["one.jpg", "two.jpg", "three.jpg"];    //（设定想要显示的图片）
        var x = 0;
        function time1(){
            x++;
            x=x%3;         //         超过2则取余数，保证循环在0、1、2之间
            document.getElementById("img").src ="${pageContext.request.contextPath }/static/image/"+imgs[x];
        }setInterval("time1()",5000);


    </script>
    <script type="text/javascript">
        function show(){
            var date = new Date();
            var year =date.getFullYear();
            var month = date.getMonth()+1;
            var day = date.getDay()+20;
            var days = new Array("日","一","二","三","四","五","六");
            var date1 = year+"年"+month+"月"+day+"日";
            var weekday = "星期"+ days[day];
            var P_date = document.getElementById("date");
            // var P_weekday =document.getElementById("weekday");

            P_date.innerHTML=date1;
            // P_weekday.innerHTML = weekday;
        }setTimeout("show()",10);

    </script>
    <style type="text/css">
        .bg{
            background-color: #2C3E50;
        }

    </style>
    <script type="text/javascript">

    </script>

</head>
<body>
<div id="main">
    <header id="header">
        <img id="sign" src="${pageContext.request.contextPath }/static/image/sign.png">
        <div id="div"></div>

        <div class="date">
            <span id="date"></span> <br>
<%--            <p id="weekday"></p>--%>

        </div>
    </header>
    <script type="text/javascript">
        //标题显示
        var str ="毕业生就业管理系统!";
        var i=0;
        function write(){
            var div = document.getElementById('div');
            // if (i <= str.length) {
            //     div.innerHTML = str.slice(0, i++) ;
            //     if (i==str.length) {
            //         i=0;
            //
            //     }
            //     setTimeout('write()', 200);//递归调用
            // }
            div.innerHTML = str;
        }
        write();
    </script>

    <!-- 	<div id="photo"><img src="./image/three.jpg" id="img"></div> -->

    <div id="student" align="center">
        <a class="a" href="student_login" style="background-color:#AEDD81"><img class="image" src="${pageContext.request.contextPath }/static/image/student.png" style="width: 30px;height: 30px; ">学生门户登录</a>
        <br>
        <a class="a" href="admin_login" style="background-color:#00CCFF"><img class="image" src="${pageContext.request.contextPath }/static/image/teacher.png" style="width: 30px;height: 30px;" >管理门户登录</a>
        <br>
        <a class="a" href="company_login" style="background-color:	#EB7347"><img class="image" src="${pageContext.request.contextPath }/static/image/teacher.png" style="width: 30px;height: 30px">企业门户登录</a>

    </div>

</div>
</body>
</html>
