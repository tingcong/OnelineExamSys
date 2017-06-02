<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>在线考试系统</title>
    <script src="${pageContext.request.contextPath}/jsp/manage/js/jquery.min.js"></script>
    <link href="css/manage.css" type="text/css" rel="stylesheet">
    <link href="css/jquery.selectlist.css" type="text/css" rel="stylesheet">
    <%--<script src="js/jquery.min.js"></script>--%>
    <script src="js/jquery.selectlist.js"></script>
    <%--<script src="${pageContext.request.contextPath}/jsp/manage/js/exam.js"></script>--%>
</head>
<body>
<header>
    <input type="hidden" id="examid" value="">
    <input type="hidden" id="paperid" value="">
    <input type="hidden" id="used_time" value="">
    <div id="exam_top">
        <div class="leftF">
            <span class="exam_head"></span>
        </div>
        <div class="rightF">
            <span class="exam_head">学号：${onlineUser.account}</span>
            <span class="exam_head">姓名：${onlineUser.name}</span>
        </div>
        <div class="center">
            <span class="exam_head" id="hole_time">考试限时：分钟</span>
            <span class="exam_head">剩余时间：<span class="green" id="time"></span>分钟</span>
        </div>
    </div>
</header>
<div class="main">
    <div class="marklist rightF">
        <ul class="single_mark_list">

            <div class="mark_title" id="single_mark">
                <a href="#single_title" class="mark">
                    <ul>单项选择</ul>
                </a>
            </div>

            <li>
                <a href="" class="mark">
                    <ul></ul>
                </a>
            </li>

        </ul>
        <ul class="multi_mark_list">

            <div class="mark_title" id="multi_mark">
                <a href="#multi_title" class="mark">
                    <ul>多项选择</ul>
                </a>
            </div>

            <li>
                <a href="" class="mark">
                    <ul></ul>
                </a>
            </li>

        </ul>
        <ul class="judge_mark_list">

            <div class="mark_title" id="judge_mark">
                <a href="#judge_title" class="mark">
                    <ul>判断正误</ul>
                </a>
            </div>

            <li>
                <a href="" class="mark">
                    <ul></ul>
                </a>
            </li>

        </ul>
        <ul class="essay_mark_list">

            <div class="mark_title" id="essay_mark">
                <a href="#essay_title" class="mark">
                    <ul>问答辨析</ul>
                </a>
            </div>

            <li>
                <a href="" class="mark">
                    <ul></ul>
                </a>
            </li>

            <div class="submit_paper">
                <a href="#" class="mark" id="submit" onclick="examOver()">
                    <ul>提交试卷</ul>
                </a>
            </div>
        </ul>
    </div>
    <div class="blocker"></div>
    <div class="examright leftF">
        <div class="block" id="single_block">

            <div class="title" id="single_title">一、单项选择</div>

            <div class="content_box" id="single">
                <%--<select class="single_choice rightF">--%>
                <%--<option value="0">请选择正确答案</option>--%>
                <%--<option value="1">A</option>--%>
                <%--<option value="2">B</option>--%>
                <%--<option value="3">C</option>--%>
                <%--<option value="4">D</option>--%>
                <%--</select>--%>
                <%--<div class="content">能否对粉丝爱疯hiof你</div>--%>
                <%--<div class="choice_box">--%>
                <%--<div class="content">A.范德萨发生的发生</div>--%>
                <%--<div class="content">B.第三方士大夫</div>--%>
                <%--<div class="content">C.辅导辅导辅导</div>--%>
                <%--<div class="content">D.佛挡杀佛斯蒂芬</div>--%>
                <%--</div>--%>
            </div>

        </div>
        <div class="block" id="multi_block">

            <div class="title" id="multi_title">二、多项选择</div>

            <div class="content_box" id="double">
                <div class="content">

                </div>
                <div class="choice_box">
                    <%--<div class="content">--%>
                    <%--<input type="checkbox" class="check"><span>A.</span></input>--%>
                    <%--</div>--%>
                    <%--<div class="content">--%>
                    <%--<input type="checkbox" class="check"><span>B.</span></input>--%>
                    <%--</div>--%>
                    <%--<div class="content">--%>
                    <%--<input type="checkbox" class="check"><span>C.</span></input>--%>
                    <%--</div>--%>
                    <%--<div class="content">--%>
                    <%--<input type="checkbox" class="check" id=><span>D.</span></input>--%>
                    <%--</div>--%>
                </div>
            </div>

        </div>
        <div class="block" id="judge_block">

            <div class="title" id="judge_title">三、判断正误</div>

            <div class="content_box" id="judgeMent">
                <%--<select class="judge_choice rightF" id="judge_answer">--%>
                <%--<option value="0">请选择正确答案</option>--%>
                <%--<option value="1">T</option>--%>
                <%--<option value="2">F</option>--%>
                <%--</select>--%>
                <%--<div class="content"></div>--%>
            </div>

        </div>
        <div class="block" id="essay_block">

            <div class="title" id="essay_title">四、简答辨析</div>

            <div class="content_box" id="essay">
                <%--<div class="content"></div>--%>
                <%--<textarea type="text" class="exam_many_lines"></textarea>--%>
            </div>

        </div>
    </div>
</div>
<div class="clear"></div>
<div class="exam_foot">
    <span>Copyright © Jackeriss, Franky Shy</span>
</div>
<div class="alert_screen" id="tip">
    <div class="alert_block">
        <div class="alert_msg">注意：考试过程中请不要退出全屏，更不能切换，否则按作弊处理！</div>
        <button class="alert_btn submit_button" id="startButton">开始考试</button>
        <%--<button class="alert_btn submit_button" id="startButton">开始考试</button>--%>
        <a href="../index.jsp">
            <button class="quit_btn submit_button">退出考试</button>
        </a>
    </div>
</div>
</body>
<script type="text/javascript">
    //    题号初始化
    var singleNo = 1;
    var doubleNo = 1;
    var judgeNo = 1;
    var essayNo = 1;
    var examId =<%=request.getParameter("examId")%>;

    $(function () {
        //初始化样式
        $('.single_answer').selectlist({
            zIndex: 100,
            width: 150,
            height: 40,
        });
        $('.judge_answer').selectlist({
            zIndex: 100,
            width: 150,
            height: 40,
        });
//        $("#startButton").attr("disabled", true);
        $("#startButton").click(function () {
            $("#tip").css("display", "none");
        });


        //添加考试记录
        $.ajax({
            url: "${basePath}/ExamPlan/insertExamRecord.htm",
            data: {
                "examId": examId
            },
            type: "POST",
            success: function (result) {
                var data = result.data;
                if (result.status==0) {
//                    alert(result.status);
                    //如果记录存在，如果存在则不能再进行考试
//                    $("#startButton").attr("disabled", true);
                }
            }
        });


        //初始化试卷
        $.ajax({
            url: "${basePath}/ExamPlan/getPaper.htm",
            data: {
                "examId": examId
            },
            type: "POST",
            success: function (result) {
                var data = result.data;
                $(data).each(function () {
                    //考试编号

                    //单选题
                    if ($(this)[0].A != undefined && $(this)[0].answer.length == 1) {
                        // alert($(this)[0].A);

                        var options = "";
                        options += '<select class="single_choice rightF" id="single_' + singleNo + '" filePath="' + $(this)[0].filePath + '" questionId="' + $(this)[0].questionId + '">' +
                            '<option value="0">请选择正确答案</option>' +
                            '<option value="1">A</option>' +
                            '<option value="2">B</option>' +
                            '<option value="3">C</option>' +
                            '<option value="4">D</option></select>' +
                            '<div class="content">' + singleNo + '、 ' + $(this)[0].title + '</div>' +
                            '<div class="choice_box">' +
                            '<div class="content">A.' + $(this)[0].A + '</div>' +
                            '<div class="content">B.' + $(this)[0].B + '</div>' +
                            '<div class="content">C.' + $(this)[0].C + '</div>' +
                            '<div class="content">D.' + $(this)[0].D + '</div>' +
                            '</div>';
                        $("#single").append(options);
                        $("#single").val("").trigger("change");
                        singleNo = singleNo + 1;
                    } else if ($(this)[0].A != undefined && $(this)[0].answer.length != 1) {
                        var options = "";
                        options += '<div class="content">' + doubleNo + '、 ' + $(this)[0].title + '</div>' +
                            '<div class="choice_box">' +
                            '<div class="content">' +
                            '<input value="1" type="checkbox" class="check" name="double_' + doubleNo + '" filePath="' + $(this)[0].filePath + '" questionId="' + $(this)[0].questionId + '"><span>A.' + $(this)[0].A + '</span></input>' +
                            '</div>' +
                            '<div class="content">' +
                            '<input value="2" type="checkbox" class="check" name="double_' + doubleNo + '" filePath="' + $(this)[0].filePath + '" questionId="' + $(this)[0].questionId + '"><span>B.' + $(this)[0].B + '</span></input>' +
                            ' </div>' +
                            ' <div class="content">' +
                            '<input value="3" type="checkbox" class="check" name="double_' + doubleNo + '" filePath="' + $(this)[0].filePath + '" questionId="' + $(this)[0].questionId + '"><span>C.' + $(this)[0].C + '</span></input>' +
                            '</div>' +
                            '<div class="content">' +
                            ' <input value="4" type="checkbox" class="check" name="double_' + doubleNo + '" filePath="' + $(this)[0].filePath + '" questionId="' + $(this)[0].questionId + '"><span>D.' + $(this)[0].D + '</span></input>'
                        ' </div>' +
                        ' </div>';
                        $("#double").append(options);
                        $("#double").val("").trigger("change");
                        doubleNo = doubleNo + 1;
                    } else if ($(this)[0].type == "Judgment") {
                        var options = "";
                        options += '<select class="judge_choice rightF" id="judgeMent_' + judgeNo + '" filePath="' + $(this)[0].filePath + '" questionId="' + $(this)[0].questionId + '">' +
                            '<option value="0">请选择正确答案</option>' +
                            '<option value="1">T</option>' +
                            '<option value="2">F</option>' +
                            '</select>' +
                            '<div class="content">' + judgeNo + '、 ' + $(this)[0].title + '</div>';
                        $("#judgeMent").append(options);
                        $("#judgeMent").val("").trigger("change");
                        judgeNo = judgeNo + 1;
                    } else if ($(this)[0].type == "Essay") {
                        var options = "";
//                        alert($(this)[0].filePath);
                        options += '<div class="content">' + essayNo + '、 ' + $(this)[0].title + '</div>' +
                            '<textarea type="text" class="exam_many_lines" id="essay_' + essayNo + '" filePath="' + $(this)[0].filePath + '" questionId="' + $(this)[0].questionId + '"></textarea>';
                        $("#essay").append(options);
                        $("#essay").val("").trigger("change");
                        essayNo = essayNo + 1;
                    }
                });
//                alert(data);
            }
        });


    });
    function examOver() {
        //alert('singleNo:'+singleIsBe+','+'answer:'+$("#single_"+singleIsBe+" option:selected").val()+',filePath:'+$("#single_"+singleIsBe).attr("questionId"));
//        var singleIsBe=1;
        var paperResult = "";
        //单选
        var singleResult = "";
        for (singleIsBe = 1; singleIsBe < 21; singleIsBe++) {
            if ($("#single_" + singleIsBe).attr("questionId") != undefined) {
                var filePath = $("#single_" + singleIsBe).attr("filePath");
                subject = filePath.substring(filePath.length - 9, filePath.length - 8);
                questionType = filePath.substring(filePath.length - 7, filePath.length - 6);
//                alert(subject);
                singleResult = '{"singleNo":"' + singleIsBe + '","answer":"' + $("#single_" + singleIsBe + " option:selected").val() + '","subject":"' + subject + '","questionId":"' + $("#single_" + singleIsBe).attr("questionId") + '","questionType":"' + questionType + '","examId":"' + examId + '"},' + singleResult;
            }
        }
        singleResult = singleResult.substr(0, singleResult.length - 1)
//        alert(singleResult);

        //多选
        var doubleResult = "";
        for (doubleIsBe = 1; doubleIsBe < 21; doubleIsBe++) {
            if ($('input:checkbox[name="double_' + doubleIsBe + '"]').attr("filePath") != undefined) {
                var filePath = $('input:checkbox[name="double_' + doubleIsBe + '"]').attr("filePath");
                subject = filePath.substring(filePath.length - 9, filePath.length - 8);
                questionType = filePath.substring(filePath.length - 7, filePath.length - 6);

                var doubleResult_array = new Array();
                $('input:checkbox[name="double_' + doubleIsBe + '"]:checked').each(function () {
                    doubleResult_array.push($(this).val());
                });
                var tmp = doubleResult_array.join(' || ');
                doubleResult = '{"doubleNo":"' + doubleIsBe + '","answer":"' + tmp + '","subject":"' + subject + '","questionId":"' + $('input:checkbox[name="double_' + doubleIsBe + '"]').attr("questionId") + '","questionType":"' + questionType + '","examId":"' + examId + '"},' + doubleResult;
            }
        }
        doubleResult = doubleResult.substr(0, doubleResult.length - 1);
//        alert(doubleResult);

        //判断题
        var judgmentResult = "";
        for (judgmentIsBe = 1; judgmentIsBe < 21; judgmentIsBe++) {
            if ($("#judgeMent_" + judgmentIsBe).attr("questionId") != undefined) {
                var filePath = $("#judgeMent_" + judgmentIsBe).attr("filePath");
                subject = filePath.substring(filePath.length - 9, filePath.length - 8);
                questionType = filePath.substring(filePath.length - 7, filePath.length - 6);

                judgmentResult = '{"judgeNo":"' + judgmentIsBe + '","answer":"' + $("#judgeMent_" + judgmentIsBe + " option:selected").val() + '","subject":"' + subject + '","questionId":"' + $("#judgeMent_" + judgmentIsBe).attr("questionId") + '","questionType":"' + questionType + '","examId":"' + examId + '"},' + judgmentResult;
            }
        }
        judgmentResult = judgmentResult.substr(0, judgmentResult.length - 1);
//        alert(judgmentResult);

        //问答题
        var essayResult = "";
        for (essayIsNe = 1; essayIsNe < 21; essayIsNe++) {
            if ($("#essay_" + essayIsNe).attr("questionId") != undefined) {
                var filePath = $("#essay_" + essayIsNe).attr("filePath");
                subject = filePath.substring(filePath.length - 9, filePath.length - 8);
                questionType = filePath.substring(filePath.length - 7, filePath.length - 6);

                essayResult = '{"essayNo":"' + essayIsNe + '","answer":"' + $("#essay_" + essayIsNe).val() + '","subject":"' + subject + '","questionId":"' + $("#essay_" + essayIsNe).attr("questionId") + '","questionType":"' + questionType + '","examId":"' + examId + '"},' + essayResult;
            }
        }
        essayResult = essayResult.substr(0, essayResult.length - 1);
//        alert(essayResult);

        paperResult = singleResult + ',' + doubleResult + ',' + judgmentResult + ',' + essayResult;
//        alert(paperResult);
        //上传试卷信息
        $.ajax({
            url: "${basePath}/ExamPlan/putPaper.htm",
            data: paperResult,
            type: "POST",
            success: function (result) {
                var data = result.data;
            }
        });

        alert("考试结束");
        window.location.href="${basePath}/jsp/manage/student.jsp";
    }

</script>
</html>