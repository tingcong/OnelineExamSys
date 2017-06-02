<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<%
    String userid = request.getParameter("userid");
    String username = request.getParameter("username");
%>
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
            <a href="#" onclick="exit()">退出</a>
        </div>
    </div>
</header>
<div class="main">
    <input type="hidden" id="userid" value="<%=userid%>">
    <input type="hidden" id="username" value="<%=username%>">
    <div class="mainleft leftF">
        <div class="bigperson">
            <div class="touxiang">
                <img id="mainphoto" src="${pageContext.request.contextPath}/img/touxiang/${onlineUser.account}.jpg"
                     width="100" height="100">
            </div>
            <div class="personname">${onlineUser.name}</div>
        </div>
        <div style="height:72px;"></div>
        <div class="funclist">
            <ul class="funclistul">
                <li id="office_set.jsp">
                    <a href="#">
                        <ul class="funclistul">设置临近的考试</ul>
                    </a>
                </li>
                <li id="teacher_set.jsp">
                    <a href="#">
                        <ul class="funclistul">等待设置的考试</ul>
                    </a>
                </li>
                <li class="line"></li>
                <li id="teacher_score.jsp">
                    <a href="#">
                        <ul class="funclistul">等待批改的试卷</ul>
                    </a>
                </li>
                <li class="line"></li>
                <li id="teacher_check_detail.jsp">
                    <a href="#">
                        <ul class="funclistul">查看学生的成绩</ul>
                    </a>
                </li>
                <li class="line"></li>
                <li id="teacher_add.jsp">
                    <a href="#">
                        <ul class="funclistul">添加题目到题库</ul>
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <div class="mainright rightF">
        <table id="divide_line">
            <tr>
                <td valign="top"></td>
            </tr>
        </table>
        <iframe src="" name="frame_content" id="frame_content" frameborder="0" scrolling="no" width="100%"></iframe>
    </div>
    <div class="clear"></div>
</div>
<div class="foot">
    <span>Copyright © Jackeriss, Franky Shy</span>
</div>
</body>
<script type="text/javascript">
    function exit() {
        if (confirm("确认退出吗？")) {
            location.href = '/OES/exit.htm';
        }
    }
</script>
</html>