<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="css/manage.css" type="text/css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/jsp/manage/css/manage.css" type="text/css" rel="stylesheet">
	<script src="${pageContext.request.contextPath}/jsp/manage/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/jsp/manage/js/manage.js"></script>
</head>
<body>
	<div class="Wrapbody">
		<ul class="zla_m_tab" id="zla_title">
			<li class="zla_m_item zla_m_cur">
				<a href="#">即将到来的考试</a>
			</li>
		</ul>
		<div class="ulDiv">
			<ul id="resultList">
				<%--<c:forEach items="examBeList" var="item" varStatus="status">--%>
					<%--<li>--%>
						<%--<div class="Mconright">--%>
							<%--<h3 class="clearfix"></h3>--%>
							<%--<p>任课教师：${onlineUser.name}</p>--%>
							<%--<p>考试限时：${item}</p>--%>
							<%--<p>开始时间：${item}</p>--%>
							<%--<p>结束时间：${item}</p>--%>
						<%--</div>--%>
					<%--</li>--%>
				<%--</c:forEach>--%>
			</ul>
		</div>
	</div>
<script type="text/javascript">
	<%--$(function () {--%>
		<%--$.get("${pageContext.request.contextPath}/student/getExamBe.htm",function (data) {--%>
			<%--var list=eval(data);--%>
			<%--for(i=0;i<list.length;i++){--%>
                <%--$("#resultList").append(--%>
                    <%--"<li><div class='Mconright'>" +--%>
					<%--"<h3 class='clearfix'>"+"2015上学年智商期末测试"+"</h3>"+--%>
                    <%--"<p>试卷编号:"+list[i].paperId+"</p>"+--%>
                    <%--"<p>考试限时:"+(list[i].examEndDatetime-list[i].examStartDatetime)+"</p>"+--%>
                    <%--"<p>开始时间:"+list[i].examStartDatetime+"</p>"+--%>
                    <%--"<p>结束时间:"+list[i].examEndDatetime+"</p>"+--%>
                    <%--"</li>");--%>
			<%--}--%>
        <%--});--%>
    <%--})--%>
	$(function () {
		$.ajax({
			url:"${pageContext.request.contextPath}/student/getExamBe.htm",
            type:"post",
			success:function (result) {
				var data=result.data;
				var options="";
				$(data).each(function () {
					options+='<li>' +
								'<div class="Mconright">' +
									'<h3 class="clearfix">'+$(this)[0].examName+'</h3>' +
									'<p>开始时间：'+$(this)[0].examStartDatetime+'</p>'+
									'<p>结束时间：'+$(this)[0].examEndDatetime+'</p>';
                });
				$("#resultList").append(options);
                $("#resultList").val("").trigger("change");
            }
		});
    })
</script>
</body>
</html>