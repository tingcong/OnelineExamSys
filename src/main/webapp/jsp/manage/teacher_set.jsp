
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="${pageContext.request.contextPath}/jsp/manage/js/jquery.min.js"></script>
    <script src="${basePath}/private/js/baseOperation.js"></script>
<link href="css/manage.css" type="text/css" rel="stylesheet">
</head>
<body>
	<div class="Wrapbody">
		<ul class="zla_m_tab" id="zla_title">
			<li class="zla_m_item zla_m_cur">
				<a href="#">等待设置的考试</a>
			</li>
		</ul>
		<div class="ulDiv">
			<ul id="exam_list">
			 	<%--<li>--%>
			 		<%--<a href="teacher_set_detail.jsp?id=">--%>
						<%--<div class="Mconright">--%>
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
		initExamList();
    });

	//初始化考试列表
	function initExamList() {
		var opt={
		  url:"${basePath}/ExamPlan/getAllExamNotSet.htm",
			callBack:initExamListCallBack
		};
		excuteOperation(opt);
    }
    function initExamListCallBack(result) {
		if(result.status==1){
		    var data=result.data;
		    var options="";
		    $(data).each(function () {
				options+='<li>'+
                            '<a href="teacher_set_detail.jsp?id='+$(this)[0].id+'">'+
                                '<div class="Mconright">'+
                                    '<h3 class="clearfix">'+$(this)[0].examName+'</h3><br><br>'+
                                    '<p>开始时间：'+$(this)[0].examStartDatetime+'</p>'+
                                    '<p>结束时间：'+$(this)[0].examEndDatetime+'</p>'+
                                '</div>'+
                            '</a>'+
                        '</li>'
            });
		    $("#exam_list").append(options);
		    $("#exam_list").val("").trigger("change");
		}
    }
</script>
</html>