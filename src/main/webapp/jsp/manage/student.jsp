<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String userid = request.getParameter("userid");
String username = request.getParameter("username");
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
<title>在线考试系统</title>
<link href="${pageContext.request.contextPath}/jsp/manage/css/manage.css" type="text/css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/jsp/manage/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/jsp/manage/js/manage.js"></script>
</head>
<body style="overflow:scroll;"> 
<header>
<div id="header-top">
	<span>在线考试系统</span>
	<div id="logout">
		<i class="fa fa-sign-out"></i>
		<a onclick="exit()">退出</a>
	</div>
</div>
</header>
<div class="main">
<input type="hidden" id="userid" value="${onlineUser.id}"/>
<input type="hidden" id="username" value="${onlineUser.name}">
	<div class="mainleft leftF">
		<div class="bigperson">
			<div class="touxiang">
				<img id="mainphoto" src="${pageContext.request.contextPath}/img/touxiang/${onlineUser.account}.jpg" width="100" height="100">
			</div>
			<div class="personname">${onlineUser.name}</div>
	    </div>
		<div style="height:72px;"></div>
		<div class="funclist">
			<ul class="funclistul">
				<li id="student_ing.jsp">
					<a href="#">
						<ul class="funclistul">正在进行的考试</ul>
					</a>
		    	</li>
				<li class="line"></li>					
				<li id="student_be.jsp">
		    		<a href="#">
						<ul class="funclistul">即将到来的考试</ul>
					</a>
				</li>
				<li class="line"></li>										
				<li id="student_ed.jsp">
		    		<a href="#">
						<ul class="funclistul">已经结束的考试</ul>
					</a>
		    	</li>
			</ul>
		</div>
	</div>
	<div class="mainright rightF">
		<table id="divide_line"><tr><td valign="top"></td></tr></table>
		<iframe src="" name="frame_content" id="frame_content" frameborder="0" scrolling="no" width="100%"></iframe>
	</div>
	<div class="clear"></div>
</div>

<div class="foot">
	<span>Copyright © hutingcong, Franky Shy</span>
</div>
</body>

<script type="text/javascript">
	function exit() {
		if(confirm("确认退出吗？")){
		    location.href='/OES/exit.htm';
		}
    }
</script>
</html>