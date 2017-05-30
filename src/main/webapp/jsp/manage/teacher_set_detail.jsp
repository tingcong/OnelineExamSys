<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<c:set var="examid" value='<%=request.getParameter("id")%>'></c:set>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/manage.css" type="text/css" rel="stylesheet">
    <link href="css/jquery.selectlist.css" type="text/css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/jsp/manage/js/jquery.min.js"></script>
    <script src="${basePath}/private/js/baseOperation.js"></script>
    <script src="js/jquery.min.js"></script>
    <script src="js/jquery.selectlist.js"></script>
    <script src="js/teacher_set.js"></script>
</head>
<body>
<input type="hidden" id="examid" value="${examid}">
<div class="Wrapbody">
    <ul class="zla_m_tab" id="zla_title">
        <li class="zla_m_item zla_m_cur">
            <a href="#">等待设置的考试</a>
        </li>
    </ul>
    <div class="Div">
        <div class="normal_one" id="exam_name">马概2015年上学期期末考试</div>
        <div class="block">
            <%--<select id="time">--%>
            <%--<option value="0">请选择考试限时</option>--%>
            <%--<option value="45">45分钟</option>--%>
            <%--<option value="60">60分钟</option>--%>
            <%--<option value="90">90分钟</option>--%>
            <%--<option value="120">120分钟</option>--%>
            <%--</select>--%>
            <%--<select id="level">--%>
            <%--<option value="0">请选择试卷难度</option>--%>
            <%--<option value="1">简单</option>--%>
            <%--<option value="2">普通</option>--%>
            <%--<option value="3">困难</option>--%>
            <%--</select>--%>
        </div>
        <div class="four_in_one">
            <div class="normal_one">总分</div>
        </div>
        <div class="four_in_one">
            <div class="normal_one">每题分数</div>
        </div>
        <div class="four_in_one">
            <div class="normal_one">题目个数</div>
        </div>
        <div class="four_in_one">
            <div class="normal_one">题目类型</div>
        </div>
        <div class="four_in_one">
            <div class="normal_one" id="single_total">0</div>
        </div>
        <div class="four_in_one">
            <input type="text" class="one_block" id="single_po"></input>
        </div>
        <div class="four_in_one">
            <input type="text" class="one_block" id="single_no"></input>
        </div>
        <div class="four_in_one">
            <div class="normal_one">单项选则</div>
        </div>
        <div class="four_in_one">
            <div class="normal_one" id="multi_total">0</div>
        </div>
        <div class="four_in_one">
            <input type="text" class="one_block" id="multi_po"></input>
        </div>
        <div class="four_in_one">
            <input type="text" class="one_block" id="multi_no"></input>
        </div>
        <div class="four_in_one">
            <div class="normal_one">多项选则</div>
        </div>
        <div class="four_in_one">
            <div class="normal_one" id="judge_total">0</div>
        </div>
        <div class="four_in_one">
            <input type="text" class="one_block" id="judge_po"></input>
        </div>
        <div class="four_in_one">
            <input type="text" class="one_block" id="judge_no"></input>
        </div>
        <div class="four_in_one">
            <div class="normal_one">判断正误</div>
        </div>
        <div class="four_in_one">
            <div class="normal_one" id="essay_total">0</div>
        </div>
        <div class="four_in_one">
            <input type="text" class="one_block" id="essay_po"></input>
        </div>
        <div class="four_in_one">
            <input type="text" class="one_block" id="essay_no"></input>
        </div>
        <div class="four_in_one">
            <div class="normal_one">简答辨析</div>
        </div>
        <div class="four_in_one">
            <div class="normal_one red" id="total">0</div>
        </div>
        <div class="four_in_one">
            <div class="normal_one">该试卷的总分</div>
        </div>
        <div class="clear"></div>
        <div class="aline">
            <button class="submit_button rightF" id="setsubmit">提交</button>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(function () {
        initPage();

        $("#setsubmit").click(function () {
            /*单项选择*/
            var single='"singleNum":"'+$("#single_no").val()+'","singleScope":"'+$("#single_po").val()+'"';

            /*  多选题 */
            var multi='"multiNum":"'+$("#multi_no").val()+'","multiScope":"'+$("#multi_po").val()+'"';

            /* 判断正误 */
            var judgment='"judgmentNum":"'+$("#judge_no").val()+'","judgmentScope":"'+$("#judge_po").val()+'"';

            /*  问答 */
            var essay='"essayNum":"'+$("#essay_no").val()+'","essayScope":"'+$("#essay_po").val()+'"';

            /*  总分  */
            var total='"totalScope":"'+$("#total").text()+'"';

            var data='{"id":"'+examid+'",'+single+','+multi+','+judgment+','+essay+','+total+'}';

//            alert(data);
            $.ajax({
                url:"${basePath}/ExamPlan/updatePaperById.htm",
                async:false,
                data:data,
                type:"POST",
                success:function (result) {
                    var data=result.data;
                    alert(data.msg);
                }
            });

        });
    });
    function initPage() {
//        alert(examid);

        $.ajax({
            url: "${basePath}/ExamPlan/getExamInfoById.htm",
            async: false,
            data: {"examid": examid},
            type: "POST",
            success:function (result) {
                var data=result.data;
                $(data).each(function () {
                    $("#exam_name").text($(this)[0].examName);
                });
            }
        });
    }
</script>
</html>