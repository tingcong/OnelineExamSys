<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

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
    <script src="js/exam.js"></script>
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
            <span class="exam_head">学号：</span>
            <span class="exam_head">姓名：</span>
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
                <a href="#" class="mark" id="submit">
                    <ul>提交试卷</ul>
                </a>
            </div>
        </ul>
    </div>
    <div class="blocker"></div>
    <div class="examright leftF">
        <div class="block" id="single_block">

            <div class="title" id="single_title">一、单项选择</div>

            <div class="content_box">
                <select class="single_choice rightF">
                    <option value="0">请选择正确答案</option>
                    <option value="1">A</option>
                    <option value="2">B</option>
                    <option value="3">C</option>
                    <option value="4">D</option>
                </select>
                <div class="content"></div>
                <div class="choice_box">
                    <div class="content">A.</div>
                    <div class="content">B.</div>
                    <div class="content">C.</div>
                    <div class="content">D.</div>
                </div>
            </div>

        </div>
        <div class="block" id="multi_block">

            <div class="title" id="multi_title">二、多项选择</div>

            <div class="content_box">
                <div class="content">
            </div>
            <div class="choice_box">
                <div class="content">
                    <input type="checkbox" class="check"><span>A.</span></input>
                </div>
                <div class="content">
                    <input type="checkbox" class="check"><span>B.</span></input>
                </div>
                <div class="content">
                    <input type="checkbox" class="check"><span>C.</span></input>
                </div>
                <div class="content">
                    <input type="checkbox" class="check" id=><span>D.</span></input>
                </div>
            </div>
        </div>

    </div>
    <div class="block" id="judge_block">

        <div class="title" id="judge_title">三、判断正误</div>

        <div class="content_box">
            <select class="judge_choice rightF">
                <option value="0">请选择正确答案</option>
                <option value="1">T</option>
                <option value="2">F</option>
            </select>
            <div class="content"></div>
        </div>

    </div>
    <div class="block" id="essay_block">

        <div class="title" id="essay_title">四、简答辨析</div>

        <div class="content_box">
            <div class="content"></div>
            <textarea type="text" class="exam_many_lines"></textarea>
        </div>

    </div>
</div>
</div>
<div class="clear"></div>
<div class="exam_foot">
    <span>Copyright © Jackeriss, Franky Shy</span>
</div>
<div class="alert_screen">
    <div class="alert_block">
        <div class="alert_msg">注意：考试过程中请不要退出全屏，更不能切换，否则按作弊处理！</div>
        <button class="alert_btn submit_button">开始考试</button>
        <a href="../index.jsp">
            <button class="quit_btn submit_button">退出考试</button>
        </a>
    </div>
</div>
</body>
</html>