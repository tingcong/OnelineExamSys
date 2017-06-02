<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="basePath"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/manage.css" type="text/css" rel="stylesheet">
	<script src="${pageContext.request.contextPath}/jsp/manage/js/jquery.min.js"></script>
</head>
<body>
	<div class="Wrapbody">
		<ul class="zla_m_tab" id="zla_title">
			<li class="zla_m_item zla_m_cur">
				<a href="#">等待批改的试卷</a>
			</li>
		</ul>
		<div class="ulDiv">
			<ul id="resultList">
			 	<%--<li>--%>
			 		<%--<a href="teacher_score_detail.jsp">--%>
						<%--<div class="Mconright">							--%>
							<%--<h3 class="clearfix"></h3>--%>
							<%--<br><br>--%>
						   	<%--<p>开始时间：</p>--%>
						   	<%--<p>结束时间：</p>--%>
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
			url:"${basePath}/ExamResult/getNotCorrectionByTeacherId.htm",
			type:"POST",
			success:function (result) {
				if(result.status==1){
				    var data=result.data;
				    var options="";
				    $(data).each(function () {
						options+='<li><a href="teacher_score_detail_detail.jsp?examId='+$(this)[0].id+'&subject='+$(this)[0].subjectId+'"><div class="Mconright"><h3 class="clearfix">'+$(this)[0].examName+'</h3></div></a></li>';
                    });
				    $("#resultList").append(options);
				    $("#resultList").val("").trigger("change");
                }
            }
		});
    })
</script>
</html>