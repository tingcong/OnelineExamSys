<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script src="${pageContext.request.contextPath}/jQuery/jquery.min.js"></script>
    <script src="${basePath}/private/js/baseOperation.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/manage.css" type="text/css" rel="stylesheet">
    <link href="css/jquery.selectlist.css" type="text/css" rel="stylesheet">
    <script src="js/jquery.min.js"></script>
    <script src="js/jquery.selectlist.js"></script>
    <script src="js/office_set.js"></script>
</head>
<body>

<div class="Wrapbody">
    <ul class="zla_m_tab" id="zla_title">
        <li class="zla_m_item zla_m_cur">
            <a href="#">设置临近的考试</a>
        </li>
    </ul>
    <div class="Div">
        <select id="subject" style="width: 298px; height: 40px;">
            <option value="none" selected="selected">请选择科目</option>
        </select>
        <%--<select id="course">--%>
        <%--<option value="none">请选择科目</option>--%>
        <%--<option value="none">语文</option>--%>
        <%--<option value="none">数学</option>--%>
        <%--<option value="none">英语</option>--%>
        <%--</select>--%>

        <select id="teacherInfo" style="width: 298px; height: 40px;">
            <option value="none" selected="selected">请选择出题教师</option>
        </select>
        <%--<select id="teacher">--%>
        <%--<option value="0">请选择出题教师</option>--%>
        <%--<option value="1001">欧阳丹丹</option>--%>
        <%--<option value="1002">刘梅</option>--%>
        <%--</select>--%>
        <div class="block">
            <div class="aline">
                <span class="normal_one">名称</span>
                <input type="text" class="one_line" id="exam_name"></input>
            </div>
            <div class="aline">
                <div class="specail_line_four">
                    <span class="normal_one">考试开始的时间</span>
                    <select id="beginyear" style="z-index: 11; width: 98px; height: 40px;">
                        <option value="null">年</option>
                        <option value="2017">2017</option>
                        <option value="2018">2018</option>
                        <option value="2019">2019</option>
                        <option value="2020">2020</option>
                        <option value="2021">2021</option>
                    </select>
                    <%--<select id="begin_month">--%>
                    <select id="beginmonth" style="z-index: 11; width: 98px; height: 40px;">
                        <option value="null">月</option>
                        <option value="01">01</option>
                        <option value="02">02</option>
                        <option value="03">03</option>
                        <option value="04">04</option>
                        <option value="05">05</option>
                        <option value="06">06</option>
                        <option value="07">07</option>
                        <option value="08">08</option>
                        <option value="09">09</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                    </select>
                    <%--<select id="begin_date">--%>
                    <select id="begindate" style="z-index: 11; width: 98px; height: 40px;">
                        <option value="null">日</option>
                        <option value="01">01</option>
                        <option value="02">02</option>
                        <option value="03">03</option>
                        <option value="04">04</option>
                        <option value="05">05</option>
                        <option value="06">06</option>
                        <option value="07">07</option>
                        <option value="08">08</option>
                        <option value="09">09</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                        <option value="13">13</option>
                        <option value="14">14</option>
                        <option value="15">15</option>
                        <option value="16">16</option>
                        <option value="17">17</option>
                        <option value="18">18</option>
                        <option value="19">19</option>
                        <option value="20">20</option>
                        <option value="21">21</option>
                        <option value="22">22</option>
                        <option value="23">23</option>
                        <option value="24">24</option>
                        <option value="25">25</option>
                        <option value="26">26</option>
                        <option value="27">27</option>
                        <option value="28">28</option>
                        <option value="29">29</option>
                        <option value="30">30</option>
                        <option value="31">31</option>
                    </select>
                    <%--<select id="begin_hour" >--%>
                    <select id="beginhour" style="z-index: 11; width: 98px; height: 40px;">
                        <option value="null">小时</option>
                        <option value="01">01</option>
                        <option value="02">02</option>
                        <option value="03">03</option>
                        <option value="04">04</option>
                        <option value="05">05</option>
                        <option value="06">06</option>
                        <option value="07">07</option>
                        <option value="08">08</option>
                        <option value="09">09</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                        <option value="13">13</option>
                        <option value="14">14</option>
                        <option value="15">15</option>
                        <option value="16">16</option>
                        <option value="17">17</option>
                        <option value="18">18</option>
                        <option value="19">19</option>
                        <option value="20">20</option>
                        <option value="21">21</option>
                        <option value="22">22</option>
                        <option value="23">23</option>
                        <option value="24">24</option>
                    </select>
                    <%--<select id="begin_minute">--%>
                    <select id="beginminute" style="z-index: 11; width: 98px; height: 40px;">
                        <option value="null">分钟</option>
                        <option value="00">00</option>
                        <option value="10">10</option>
                        <option value="15">15</option>
                        <option value="20">20</option>
                        <option value="30">30</option>
                        <option value="40">40</option>
                        <option value="45">45</option>
                        <option value="50">50</option>
                    </select>
                </div>
            </div>
            <div class="aline">
                <div class="specail_line_four">
                    <span class="normal_one">考试结束的时间</span>
                    <select id="endyear" style="z-index: 11; width: 98px; height: 40px;">
                        <%--<select id="end_year" >--%>
                        <option value="null">年</option>
                        <option value="2017">2017</option>
                        <option value="2018">2018</option>
                        <option value="2019">2019</option>
                        <option value="2020">2020</option>
                        <option value="2021">2021</option>
                    </select>
                    <%--<select id="end_month">--%>
                    <select id="endmonth" style="z-index: 11; width: 98px; height: 40px;">
                        <option value="null">月</option>
                        <option value="01">01</option>
                        <option value="02">02</option>
                        <option value="03">03</option>
                        <option value="04">04</option>
                        <option value="05">05</option>
                        <option value="06">06</option>
                        <option value="07">07</option>
                        <option value="08">08</option>
                        <option value="09">09</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                    </select>
                    <%--<select id="end_date">--%>
                    <select id="enddate" style="z-index: 11; width: 98px; height: 40px;">
                        <option value="null">日</option>
                        <option value="01">01</option>
                        <option value="02">02</option>
                        <option value="03">03</option>
                        <option value="04">04</option>
                        <option value="05">05</option>
                        <option value="06">06</option>
                        <option value="07">07</option>
                        <option value="08">08</option>
                        <option value="09">09</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                        <option value="13">13</option>
                        <option value="14">14</option>
                        <option value="15">15</option>
                        <option value="16">16</option>
                        <option value="17">17</option>
                        <option value="18">18</option>
                        <option value="19">19</option>
                        <option value="20">20</option>
                        <option value="21">21</option>
                        <option value="22">22</option>
                        <option value="23">23</option>
                        <option value="24">24</option>
                        <option value="25">25</option>
                        <option value="26">26</option>
                        <option value="27">27</option>
                        <option value="28">28</option>
                        <option value="29">29</option>
                        <option value="30">30</option>
                        <option value="31">31</option>
                    </select>
                    <%--<select id="end_hour">--%>
                    <select id="endhour" style="z-index: 11; width: 98px; height: 40px;">
                        <option value="null">小时</option>
                        <option value="01">01</option>
                        <option value="02">02</option>
                        <option value="03">03</option>
                        <option value="04">04</option>
                        <option value="05">05</option>
                        <option value="06">06</option>
                        <option value="07">07</option>
                        <option value="08">08</option>
                        <option value="09">09</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                        <option value="13">13</option>
                        <option value="14">14</option>
                        <option value="15">15</option>
                        <option value="16">16</option>
                        <option value="17">17</option>
                        <option value="18">18</option>
                        <option value="19">19</option>
                        <option value="20">20</option>
                        <option value="21">21</option>
                        <option value="22">22</option>
                        <option value="23">23</option>
                        <option value="24">24</option>
                    </select>
                    <%--<select id="end_minute">--%>
                    <select id="endminute" style="z-index: 11; width: 98px; height: 40px;">
                        <option value="null">分钟</option>
                        <option value="00">00</option>
                        <option value="10">10</option>
                        <option value="15">15</option>
                        <option value="20">20</option>
                        <option value="30">30</option>
                        <option value="40">40</option>
                        <option value="45">45</option>
                        <option value="50">50</option>
                    </select>
                </div>
            </div>
            <div class="aline">
                <button class="submit_button" id="submits">提交</button>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(function () {
        //初始化考试科目
        initSubject();
        //$("#course").children("div.select-list").children("ul").append('<li data-value="none" class="" style="height: 34px;">语文</li>');
        //初始化教师信息
        initTeacherInfo()

        $("#submits").click(function () {

            if ($("#subject option:selected").text() == "" || $("#subject option:selected").text() == null) {
                alert("请选择考试科目！");
                $("#subject").focus();
                return;
            }
            var subject = '"subject_ID":"' + $("#subject option:selected").val() + '"';

            if ($("#teacherInfo option:selected").text() == "" || $("#teacherInfo option:selected").text() == null) {
                alert("请选择出题老师！");
                $("#teacherInfo").focus();
                return;
            }
            var teacher = '"teacher":"' + $("#teacherInfo option:selected").val() + '"';

            if ($("#exam_name").val() == '' || $("#exam_name").val() == null) {
                alert("请填写考试名称");
                return;
            }
            var exam_name = '"exam_name":"' + $("#exam_name").val() + '"';

            if ($("#beginyear option:selected").text() == "" ||
                $("#beginyear option:selected").text() == null ||
                $("#beginmonth option:selected").text() == "" ||
                $("#beginmonth option:selected").text() == null ||
                $("#begindate option:selected").text() == "" ||
                $("#begindate option:selected").text() == null ||
                $("#beginhour option:selected").text() == "" ||
                $("#beginhour option:selected").text() == null ||
                $("#beginminute option:selected").text() == "" ||
                $("#beginminute option:selected").text() == null) {
                alert("请填写完整的考试开始时间！");
                return;
            }
            var startDt = '"StartDt":"' +
                $("#beginyear option:selected").val() +
                '-' +
                $("#beginmonth option:selected").val() +
                '-' +
                $("#begindate option:selected").val() +
                ' ' +
                $("#beginhour option:selected").val() +
                ':' +
                $("#beginminute option:selected").val() +
                ':00"';

            if ($("#endyear option:selected").text() == "" ||
                $("#endyear option:selected").text() == null ||
                $("#endmonth option:selected").text() == "" ||
                $("#endmonth option:selected").text() == null ||
                $("#enddate option:selected").text() == "" ||
                $("#enddate option:selected").text() == null ||
                $("#endhour option:selected").text() == "" ||
                $("#endhour option:selected").text() == null ||
                $("#endminute option:selected").text() == "" ||
                $("#endminute option:selected").text() == null) {
                alert("请填写完整的考试结束时间！");
                return;
            }
            var endDt = '"EndDt":"' +
                $("#endyear option:selected").val() +
                '-' +
                $("#endmonth option:selected").val() +
                '-' +
                $("#enddate option:selected").val() +
                ' ' +
                $("#endhour option:selected").val() +
                ':' +
                $("#endminute option:selected").val() +
                ':00"';

            data="{"+subject+","+teacher+","+exam_name+","+startDt+","+endDt+"}";
//            alert(data);

            $.ajax({
                url  : "${basePath}/ExamPlan/insertExamPlan.htm",
                data : data,
                type :"post",
                success:function(data){
                    if(data.status == '1'){
                        alert(data.msg);
                        window.location.reload();
                    }else{
                        alert(data.msg);
                    }
                }
            });

        });
    });

    //初始化考试科目
    function initSubject() {
        var opt = {
            url: "${basePath}/course/getCourseInfoForSelect.htm",
            callBack: initSubjectCallBack
        };
        excuteOperation(opt);
    }
    //初始化考试科目回调函数
    function initSubjectCallBack(result) {
        if (result.status == 1) {
            var data = result.data;
            var options = "";
            $(data).each(function () {
                options += '<option class="" style="height: 34px;" value="' + $(this)[0].courseId + '">' + $(this)[0].courseName + '</option>';
            });
            $("#subject").append(options);
            $("#subject").val("").trigger("change");
        }
    }

    //初始化教师信息
    function initTeacherInfo() {
        var opt = {
            url: "${basePath}/teacher/getTeacherInfoForSelect.htm",
            callBack: initTeacherInfoCallBack
        };
        excuteOperation(opt);
    }
    //初始化教师信息回调函数
    function initTeacherInfoCallBack(result) {
        if (result.status == 1) {
            var data = result.data;
            var options = "";
            $(data).each(function () {
                options += '<option class="" style="height: 34px;" value="' + $(this)[0].teacherId + '">' + $(this)[0].teacherName + '</option>';
            });
            $("#teacherInfo").append(options);
            $("#teacherInfo").val("").trigger("change");
        }
    }
</script>
</html>