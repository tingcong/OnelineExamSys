<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/manage.css" type="text/css" rel="stylesheet">
    <link href="css/jquery.selectlist.css" type="text/css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/jsp/manage/js/jquery.min.js"></script>
    <script src="${basePath}/private/js/baseOperation.js"></script>
    <script src="js/jquery.min.js"></script>
    <script src="js/jquery.selectlist.js"></script>
    <script src="js/teacher_add.js"></script>
</head>
<body>
<input type="hidden" id="teacherid" value="">
<div class="Wrapbody">
    <ul class="zla_m_tab" id="zla_title">
        <li class="zla_m_item zla_m_cur">
            <a href="#">添加题目到题库</a>
        </li>
    </ul>
    <div class="Div">
        <%--<select id="course">--%>
        <select id="subject" style="z-index: 11; width: 298px; height: 40px;">
            <option value="0">请选择试题科目</option>
        </select>
        <select id="question_type">
            <option value="0">请选择题目类型</option>
            <option value="1">单项选择</option>
            <option value="2">多项选择</option>
            <option value="3">判断正误</option>
            <option value="4">问答辨析</option>
        </select>
        <div class="block" id="single">
            <div class="aline">
                <span class="normal_one">题目</span>
                <input type="text" class="one_line" id="single_title"></input>
            </div>
            <div class="aline">
                <span class="normal_one">A</span>
                <input type="text" class="one_line" id="single_A"></input>
            </div>
            <div class="aline">
                <span class="normal_one">B</span>
                <input type="text" class="one_line" id="single_B"></input>
            </div>
            <div class="aline">
                <span class="normal_one">C</span>
                <input type="text" class="one_line" id="single_C"></input>
            </div>
            <div class="aline">
                <span class="normal_one">D</span>
                <input type="text" class="one_line" id="single_D"></input>
            </div>
            <div class="aline">
					<span class="specail_line_one">
						<select id="single_right">
							<option value="0">请选择正确答案</option>
							<option value="1">A</option>
							<option value="2">B</option>
							<option value="3">C</option>
							<option value="4">D</option>
						</select>
						<select id="single_level">
							<option value="0">请选择该题难度</option>
							<option value="1">简单</option>
							<option value="2">普通</option>
							<option value="3">困难</option>
						</select>
					</span>
                <button class="submit_button" id="singlesubmit"  onclick="clicks(this)">提交</button>
            </div>
        </div>
        <div class="block" id="multi">
            <div class="aline">
                <span class="normal_one">题目</span>
                <input type="text" class="one_line" id="multi_title"></input>
            </div>
            <div class="aline">
                <span class="normal_one">A</span>
                <input type="text" class="one_line" id="multi_A"></input>
            </div>
            <div class="aline">
                <span class="normal_one">B</span>
                <input type="text" class="one_line" id="multi_B"></input>
            </div>
            <div class="aline">
                <span class="normal_one">C</span>
                <input type="text" class="one_line" id="multi_C"></input>
            </div>
            <div class="aline">
                <span class="normal_one">D</span>
                <input type="text" class="one_line" id="multi_D"></input>
            </div>
            <div class="aline">
					<span class="specail_line_two">
						<span class="normal_two">请选择正确答案</span>
						<input type="checkbox" class="check" id="multi_right_A" name="multi_answer" value="1"><span
                            class="normal_two">A</span></input>
                        <input type="checkbox" class="check" id="multi_right_B" name="multi_answer" value="2"><span
                            class="normal_two">B</span></input>
                        <input type="checkbox" class="check" id="multi_right_C" name="multi_answer" value="3"><span
                            class="normal_two">C</span></input>
                        <input type="checkbox" class="check" id="multi_right_D" name="multi_answer" value="4"><span
                            class="normal_two">D</span></input>
                        <select id="multi_level">
							<option value="0">请选择该题难度</option>
							<option value="1">简单</option>
							<option value="2">普通</option>
							<option value="3">困难</option>
						</select>
					</span>
                <button class="submit_button" id="multisubmit"  onclick="clicks(this)">提交</button>
            </div>
        </div>
        <div class="block" id="judge">
            <div class="aline">
                <span class="normal_one">题目</span>
                <input type="text" class="one_line" id="judge_title"></input>
            </div>
            <div class="aline">
					<span class="specail_line_one">
						<select id="judge_right">
							<option value="0">请选择正确答案</option>
							<option value="1">T</option>
							<option value="2">F</option>
						</select>
						<select id="judge_level">
							<option value="0">请选择该题难度</option>
							<option value="1">简单</option>
							<option value="2">普通</option>
							<option value="3">困难</option>
						</select>
					</span>
                <button class="submit_button" id="judgesubmit"  onclick="clicks(this)">提交</button>
            </div>
        </div>
        <div class="block" id="essay">
            <div class="aline">
                <div class="normal_three">题目</div>
                <textarea type="text" class="many_lines" id="essay_title"></textarea>
            </div>
            <div class="aline">
                <div class="normal_three">答案</div>
                <textarea type="text" class="many_lines" id="essay_right"></textarea>
            </div>
            <div class="aline">
					<span class="specail_line_three">
						<select id="essay_level">
							<option value="0">请选择该题难度</option>
							<option value="1">简单</option>
							<option value="2">普通</option>
							<option value="3">困难</option>
						</select>
					</span>
                <button class="submit_button" id="essaysubmit" onclick="clicks(this)">提交</button>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(function () {
        initPage();
//        $("#subject").click(function () {
//            alert($("#question_type").find("input[name=question_type]").val());
//        });
        $('#singlesubmit').attr("disabled",false);
        $('#multisubmit').attr("disabled",false);
        $('#judgesubmit').attr("disabled",false);
        $('#essaysubmit').attr("disabled",false);
    });
    function initPage(){
        var opt={
            url:"${basePath}/course/getCourseInfoForSelect.htm",
            callBack:initPageCallBack
        };
        excuteOperation(opt);
    }
    function initPageCallBack(result) {
        if(result.status==1){
            var data=result.data;
            options="";
            $(data).each(function () {
                options+='<option value="'+$(this)[0].courseId+'">'+$(this)[0].courseName+'</option>';
            });
            $("#subject").append(options);
            $("#subject").val("").trigger("change");
        }
    }
    function clicks() {
        var data="";
        //考题所属科目
        var subject='"subject":"'+$("#subject option:selected").val()+'"';
        //题型
        var questionType='"questionType":"'+$("#question_type").find("input[name=question_type]").val()+'"';
        data=subject+","+questionType;
        //w问答题
        if($("#question_type").find("input[name=question_type]").val()==4){
            var essay='"title":"'+$("#essay_title").val()+'","answer":"'+$("#essay_right").val()+'","level":"'+$("#essay_level").find("input[name='essay_level']").val()+'"' ;
            data='{'+data+","+essay+'}';
            //判断题
        }else if($("#question_type").find("input[name=question_type]").val()==3){
            var judge='"title":"'+$("#judge_title").val()+'","answer":"'+$("#judge_right").find("input[name='judge_right']").val()+'","level":"'+$("#judge_level").find("input[name='judge_level']").val()+'"';
            data='{'+data+","+judge+'}';
            //多选题
        }else if($("#question_type").find("input[name=question_type]").val()==2){
            //获取答案
            var multi_answer_array=new Array();
            $('input:checkbox[name="multi_answer"]:checked').each(function () {
                multi_answer_array.push($(this).val());
            });
            var multi='"title":"'+$("#multi_title").val()+'","A":"'+$("#multi_A").val()+'","B":"'+$("#multi_B").val()+'","C":"'+$("#multi_C").val()+'","D":"'+$("#multi_D").val()+'","answer":"'+multi_answer_array.join("")+'","level":"'+$("#multi_level").find("input[name='multi_level']").val()+'"' ;
            data='{'+data+","+multi+'}';
            //单选题
        }else if($("#question_type").find("input[name=question_type]").val()==1){
            var single='"title":"'+$("#single_title").val()+'","A":"'+$("#single_A").val()+'","B":"'+$("#single_B").val()+'","C":"'+$("#single_C").val()+'","D":"'+$("#single_D").val()+'","answer":"'+$("#single_right").find("input[name='single_right']").val()+'","level":"'+$("#single_level").find("input[name='single_level']").val()+'"' ;
            data='{'+data+","+single+'}';
        }
        alert(data);
        $.ajax({
            url:"${basePath}/teacher/addQuestion.htm",
            data:data,
            dataType:"json",
            success:function (result) {

            }
        })
    }
</script>
</html>