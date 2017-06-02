<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/manage.css" type="text/css" rel="stylesheet">
    <script src="js/jquery.min.js"></script>
    <script src="js/teacher_check.js"></script>
</head>
<body>
<div class="Wrapbody">
    <ul class="zla_m_tab" id="zla_title">
        <li class="zla_m_item zla_m_cur">
            <a href="#">查看学生的成绩</a>
        </li>
    </ul>
    <div class="Div">
        <div class="normal_one"></div>
        <div class="block">
            <div class="four_in_one">
                <div class="normal_one">成绩</div>
            </div>
            <div class="four_in_one">
                <div class="normal_one">姓名</div>
            </div>
            <div class="four_in_one">
                <div class="normal_one">学号</div>
            </div>
            <div class="four_in_one">
                <div class="normal_one">考试名称</div>
            </div>
            <%--<div class="four_in_one">--%>
            <%--<div class="normal_one force_green">0</div>--%>
            <%--</div>--%>

            <div id="resultList">
                <div class="four_in_one">
                    <div class="normal_one">0</div>
                </div>
                <div class="four_in_one">
                    <div class="normal_one">1</div>
                </div>
                <div class="four_in_one">
                    <div class="normal_one">2</div>
                </div>
                <div class="four_in_one">
                    <div class="normal_one">3</div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(function () {
        $.ajax({
            url: "${pageContext.request.contextPath}/ExamResult/getResultList.htm",
            type: "POST",
            success: function (result) {
                var data = result.data;
                var options = '';
                $(data).each(function () {
                    options += '<div class="four_in_one">' +
                        '<div class="normal_one">'+$(this)[0].totalScore+'</div></div>' +
                        '<div class="four_in_one">' +
                        '<div class="normal_one">'+$(this)[0].studentName+'</div></div>' +
                        '<div class="four_in_one">' +
                        '<div class="normal_one">'+$(this)[0].studentId+'</div></div>' +
                        '<div class="four_in_one">' +
                        '<div class="normal_one">'+$(this)[0].examName+'</div></div>';

                });
                $("#resultList").append(options);
                $("#resultList").val("").trigger("change");
            }
        });
    })
</script>
</html>