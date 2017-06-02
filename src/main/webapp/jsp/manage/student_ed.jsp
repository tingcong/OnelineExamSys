<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
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
				<a href="#">已经结束的考试</a>
			</li>
		</ul>
		<div class="ulDiv">
			<ul id="resultUl">

			 	<%--<li>--%>
					<%--<div class="Mconright">							--%>
						<%--<h3 class="clearfix"></h3>--%>
					   	<%--<p>开始时间：</p>--%>
					   	<%--<p>结束时间：</p>--%>
					   	<%--<p>考试成绩：</p>--%>
						<%--<p>特殊说明：</p>--%>
					<%--</div>--%>
				<%--</li>--%>

			</ul>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function () {
		$.ajax({
			url:"${basePath}/ExamResult/getExamResult.htm",
			type:"POST",
			success:function (result) {
				if(result.status==1){
				    var data=result.data;
				    var options="";
				    $(data).each(function (data) {
						options+='<li>'+
                            		'<div class="Mconright">'+
                            			'<h3 class="clearfix">'+$(this)[0].examName+'</h3>'+
                        					'<p>考试成绩：'+$(this)[0].totalScore+'</p>'+
									'</div>'+
								 '</li>';
                    });
				    $("#resultUl").append(options);
				    $("#resultUl").val("").trigger("change");
                }
            }
		});
    });
</script>
</html>