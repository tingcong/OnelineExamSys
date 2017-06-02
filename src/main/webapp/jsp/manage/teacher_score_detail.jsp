<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/manage.css" type="text/css" rel="stylesheet">
<script src="js/jquery.min.js"></script>
<script src="js/teacher_score_detail.js"></script>
</head>
<body>
<input type="hidden" id="examid" value="">
	<div class="Wrapbody">
		<ul class="zla_m_tab" id="zla_title">
			<li class="zla_m_item zla_m_cur">
				<a href="#">等待批改的试卷</a>
			</li>
		</ul>
		<div class="Div">
			<div class="normal_one"></div>
			<div class="block">
				<div class="four_in_one">
					<div class="normal_one">总成绩</div>
				</div>
				<div class="four_in_one">
					<div class="normal_one">客观题成绩</div>
				</div>
				<div class="four_in_one">
					<div class="normal_one">姓名</div>
				</div>
				<div class="four_in_one">
					<div class="normal_one">序号</div>
				</div>
				<input type="hidden" id="havent" value="">
				<a href="teacher_score_detail_detail.jsp?examid=">
					<div class="four_in_one">
						<div class="normal_one"></div>
					</div>
					<div class="four_in_one">
						<div class="normal_one"></div>
					</div>
					<div class="four_in_one">
						<div class="normal_one"></div>
					</div>
					<div class="four_in_one">
						<div class="normal_one"></div>
					</div>
				</a>

			</div>
		</div>
	</div>
</body>
</html>