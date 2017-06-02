<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/manage.css" type="text/css" rel="stylesheet">
<script src="js/jquery.min.js"></script>
<%--<script src="js/teacher_score.js"></script>--%>
</head>
<body>
<input type="hidden" id="examid" value="">
<input type="hidden" id="paperid" value="">
	<div class="Wrapbody">
		<ul class="zla_m_tab" id="zla_title">
			<li class="zla_m_item zla_m_cur">
				<a href="#">等待批改的试卷</a>
			</li>
		</ul>
		<div class="Div">
			<div class="normal_one">主观题批改</div>
			<div class="score" id="essayList">
				<%--<div class="rightF">--%>
					<%--<span class="normal_one">评分</span>--%>
					<%--<input type="text" class="one_block" id=""></input>--%>
				<%--</div>--%>
				<%--<div class="score_title">题目</div>--%>
				<%--<div class="content_box">--%>
					<%--<div class="content"></div>--%>
				<%--</div>--%>
				<%--<div class="score_title">参考答案</div>--%>
				<%--<div class="content_box">--%>
					<%--<div class="content">本题暂无参考答案</div>--%>
				<%--</div>--%>
				<%--<div class="score_title">学生答案</div>--%>
				<%--<div class="content_box">--%>
					<%--<div class="content"></div>--%>
				<%--</div>--%>

			</div>
			<div class="button_block">
				<button class="submit_button" id="submitResult">提交</button>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
    var examId =<%=request.getParameter("examId")%>
    var subject =<%=request.getParameter("subject")%>

    $(function () {
        var titleNo=0;
//        alert(examId);
		$.ajax({
			url:"${basePath}/ExamResult/getNotCorrection.htm",
			type:"POST",
			data:{"examId":examId,"subject":subject},
			success:function (result) {
				var data=result.data;
//				alert(data);
				var options="";
				$(data).each(function (result) {
				    titleNo=titleNo+1;
//					$("#essayList").append(options);
                    options+= '<hr style="border-top: 1px dashed #bbb;"><br><div class="rightF">'+
                        '<span class="normal_one">评分</span>'+
                        '   <input style="margin-top: -5px" type="text" class="one_block" studentId="'+$(this)[0].studentId+'" questionId="'+$(this)[0].questionId+'"></input>'+
                        '   </div>'+
                        '   <div class="score_title">题目</div>'+
                        '   <div class="content_box">'+
                        '   <div class="content" style="background-color: #65cc99">'+titleNo+'、 '+$(this)[0].title+'</div>'+
                        '   </div>'+
                        '   <div class="score_title">学生答案</div>'+
                        '   <div class="content_box">'+
                        '	<div class="content" style="background-color: #49afcd">'+$(this)[0].studentAnswer+'</div>'+
                        '   </div>';

                });
                $("#essayList").append(options);
                $("#essayList").val("").trigger("change");
            }
		});
    });

    $("#submitResult").click(function () {
		var resultJson="";
        //遍历id为essayList下的所有input
        $("#essayList :input").each(function () {
//			alert($(this).val());
            var result="";
            result='{"score":"'+$(this).val()+'","studentId":"'+$(this).attr("studentId")+'","examId":"'+examId+'","questionId":"'+$(this).attr("questionId")+'"}';
//			alert(result);
			if($(this).val().trim().length!=0){
                resultJson=resultJson+result+',';
			}
        });
        resultJson=resultJson.substr(0,resultJson.length-1);
//        alert(resultJson);
		$.ajax({
			url:"${basePath}/ExamResult/commitEssayResult.htm",
			type:"POST",
			data:resultJson,
			success:function (result) {
				if(result.status==1){
				    window.location.href="${basePath}/jsp/manage/teacher_score.jsp"
//                    location.reload();
                }
            }
		});
    })
</script>
</html>