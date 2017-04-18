<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>TC Online Exam System</title>
		<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
		<link href="css/login.css" rel="stylesheet" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/jQuery/jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
		<script src="js/login.js"></script>
	</head>
<body>
	<div class="login-wrap">
		<form action="${pageContext.request.contextPath}/user/checkUserPwd.htm" method="post">
			<h2>TC在线考试系统</h2>
			<div class="tab">
				<ul class="tabs">
					<li id="student"><a href="#">学生登录</a></li>
					<li id="teacher"><a href="#">教师登录</a></li>
				</ul>
			</div>
			<div class="input-wrap input-msg">
				<input type="text" id="userid" name="account" placeholder="用户名" autofocus required />
			</div>
			<div class="input-wrap input-msg">
				<input type="password" id="password" name="pwd" placeholder="密码" required />
			</div>
			<div class="input-wrap input-msg" id="checkCode-wrap">
				<input type="text" id="checkCode-input" name="checkCode-check" placeholder="验证码" />
				<span class="input-check" id="checkCode-check">×</span>
				<div id="checkCode"></div>
			</div>
			<div class="input-wrap">
				<input type="submit" value="登录" />
			</div>
		</form>
	</div>
</body>
</html>