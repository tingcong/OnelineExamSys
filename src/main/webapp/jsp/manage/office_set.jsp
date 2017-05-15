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
        <select id="course">
            <option value="none">请选择科目</option>
            <option value="none">语文</option>
            <option value="none">数学</option>
            <option value="none">英语</option>
        </select>

        <select id="teacher">
            <option value="0">请选择出题教师</option>
            <option value="1001">欧阳丹丹</option>
            <option value="1002">刘梅</option>
        </select>
        <div class="block">
            <div class="aline">
                <span class="normal_one">名称</span>
                <input type="text" class="one_line" id="exam_name"></input>
            </div>
            <div class="aline">
                <div class="specail_line_four">
                    <span class="normal_one">考试开始的时间</span>
                    <select id="begin_year">
                        <option value="0">年</option>
                        <option value="2015">2015</option>
                        <option value="2016">2016</option>
                        <option value="2017">2017</option>
                    </select>
                    <select id="begin_month">
                        <option value="0">月</option>
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
                    <select id="begin_date">
                        <option value="0">日</option>
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
                    <select id="begin_hour">
                        <option value="0">小时</option>
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
                    <select id="begin_minute">
                        <option value="0">分钟</option>
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
                    <select id="end_year">
                        <option value="0">年</option>
                        <option value="2015">2015</option>
                        <option value="2016">2016</option>
                        <option value="2017">2017</option>
                    </select>
                    <select id="end_month">
                        <option value="0">月</option>
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
                    <select id="end_date">
                        <option value="0">日</option>
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
                    <select id="end_hour">
                        <option value="0">小时</option>
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
                    <select id="end_minute">
                        <option value="0">分钟</option>
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
                <button class="submit_button" id="submit">提交</button>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(function () {
        //初始化考试科目
        //initSubject();
        //$("#course").children("div.select-list").children("ul").append('<li data-value="none" class="" style="height: 34px;">语文</li>');
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
            var data=result.data;
            var options="";
            $(data).each(function () {
                options+='<option value="'+$(this)[0].courseId+'">'+$(this)[0].courseName+'</option>';
            });
            $(options).appendTo($("#course"));
            $("#course").val("").trigger("change");
        }
    }
</script>
</html>