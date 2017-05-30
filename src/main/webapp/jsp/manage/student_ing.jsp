<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>
    <link href="css/manage.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="Wrapbody">
    <ul class="zla_m_tab" id="zla_title">
        <li class="zla_m_item zla_m_cur">
            <a href="#">正在进行的考试</a>
        </li>
    </ul>
    <div class="ulDiv">
        <ul id="resultList">

            <%--<li>--%>
                <%--<a href=""--%>
                   <%--target="_top">--%>
                    <%--<div class="Mconright">--%>
                        <%--<h3 class="clearfix">2015上学年智商期末测试</h3>--%>
                        <%--<p>任课教师：胡廷聪--%>
                        <%--</p>--%>
                        <%--<p>考试限时：120分钟</p>--%>
                        <%--<p>开始时间：--%>
                        <%--</p>--%>
                        <%--<p>结束时间：--%>
                        <%--</p>--%>
                    <%--</div>--%>
                <%--</a>--%>
            <%--</li>--%>

        </ul>
    </div>
</div>
</body>
<script type="text/javascript">
    $(function () {
        $.ajax({
            url:"${pageContext.request.contextPath}/student/getExamIng.htm",
            type:"post",
            success:function (result) {
                var data=result.data;
                var options="";
                $(data).each(function () {
                    options+='<li>' +
                        '<div class="Mconright">' +
                        '<a href="${pageContext.request.contextPath}/jsp/manage/exam.jsp?examId='+$(this)[0].id+'" target="_top">'+
                        '<h3 class="clearfix">'+$(this)[0].examName+'</h3>' +
                        '<p>开始时间：'+$(this)[0].examStartDatetime+'</p>'+
                        '<p>结束时间：'+$(this)[0].examEndDatetime+'</p>';
                });
                $("#resultList").append(options);
                $("#resultList").val("").trigger("change")
            }
        });
    })
</script>
</html>
