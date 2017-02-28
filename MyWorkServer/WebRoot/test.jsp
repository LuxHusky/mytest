<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>考试</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script type="text/javascript" src="js/cookie_util.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<style type="text/css">
.content {
	width: 90%;
	margin: 30px auto;
}

.login-from {
	padding-right: 10%;
}

.show-grid [class ^=col-] {
	padding-top: 10px;
	padding-bottom: 10px;
	background-color: #eee;
	background-color: rgba(86, 61, 124, .15);
	border: 1px solid #ddd;
	border: 1px solid rgba(86, 61, 124, .2);
}

h1 {
	text-align: center;
}

.mine {
	height: 500px;
}

.mine-con {
	width: 48%;
}

.test-con {
	height: 455px;
}

.number {
	min-height: 100px;
}

.red {
	color: red;
	font-size: 16px;
}
</style>
</head>
<body>
	<!-- 内容开始 -->
	<div class="content">
		<h1>山船考试</h1>
		<div class="row show-grid">
			<!-- 个人信息开始 -->
			<div class="col-md-3">
				<h4>个人信息</h4>
				<div class="mine">
					<div style="height:160px;">
						<div class="pull-left">
							<img src="..." alt="..." class="img-thumbnail"
								style="width:140px;height:140px;" />
						</div>
						<div class="pull-right mine-con">
							姓名:
							<p id="testname"></p>
							工号:
							<p id="userid"></p>
							
						</div>
					</div>
					<div>
						考试倒计时：
  	<strong id="hour_show">0时</strong>
    <strong id="minute_show">0分</strong>
    <strong id="second_show">0秒</strong>
					</div>
				</div>

			</div>
			<!-- 个人信息结束 -->
			<!-- 答题开始 -->
			<div class="col-md-9">
				<h4>第几题</h4>
				<!-- 问题信息 -->
				<div class="test-con">
					<p id="context">问题内容</p>
					<div class="radio">
						<label> <input type="radio" name="optionsRadios"
							id="optionsRadios1" value="option1"> <span id="answerA">请点击开始答题</span>
						</label>
					</div>
					<div class="radio">
						<label> <input type="radio" name="optionsRadios"
							id="optionsRadios2" value="option2"> <span id="answerB">点击下一题开始显示第一题</span>
						</label>
					</div>
					<div class="radio">
						<label> <input type="radio" name="optionsRadios"
							id="optionsRadios3" value="option3"> <span id="answerC"></span>
						</label>
					</div>
					<div class="radio">
						<label> <input type="radio" name="optionsRadios"
							id="optionsRadios4" value="option4"> <span id="answerD"></span>
						</label>
					</div>
					<div class="radio disabled">
						<label> <input type="radio" name="optionsRadios"
							id="optionsRadios3" value="option3" disabled> Option
							three is disabled </label>
					</div>
					<div class="text-right">
						<button type="button" class="btn btn-primary" id="mybegin">开始答题</button>
						<button type="button" class="btn btn-primary" id="myback"
							style="display: none;">上一题</button>
						<button type="button" class="btn btn-primary" id="mynext"
							style="display: none;">下一题</button>
						<button type="button" class="btn btn-primary" id="mysubmit">交卷</button>
					</div>
					<!-- 可做答区域结束 -->
					<!-- 题量显示 -->
					<div class="number">
						<h4>题号</h4>
						<button type="button" class="btn btn-success">作答了的</button>
						<button type="button" class="btn btn-success">2</button>
						<button type="button" class="btn btn-default">还没答的</button>
					</div>
					<!-- 交卷按钮 -->
				</div>
				<div class="text-right">
					请最后确认答题完成.
					<button type="button" class="btn btn-primary btn-lg">交卷</button>
				</div>
			</div>
			<!-- 答题结束 -->
		</div>
	</div>
</body>
<script type="text/javascript">
	//获取登录信息
	var name = $.cookie('name');
	var userid =$.cookie('userid');
	var f=$.cookie('total');
	$("#testname").html(name);
	$("#userid").html(userid);
	

	$(function() {
		$("#myback").click(back);
		$("#mynext").click(next);
		$("#mybegin").click(mybegin);
		$("#mysubmit").click(submit);
		startTime();

	})
	//计时器待写

	//开始按钮
	function mybegin() {
		$("#mynext").show();
		$("#myback").show();
		$("#mybegin").hide();
		//var time_run=setInterval("getTime()",1000);
		var flag = 1;

		$.ajax({

			url : "http://localhost:8080/MyWorkServer/getChoice.do",
			type : "post",
			data : {
				"flag" : flag
			},
			dataType : "json",
			success : function(resultMap) {
				var qcontext = resultMap.question.qcontext;
				var answerA = resultMap.question.answerA;
				var answerB = resultMap.question.answerB;
				var answerC = resultMap.question.answerC;
				var answerD = resultMap.question.answerD;

				$("#context").html(qcontext);
				$("#answerA").html(answerA);
				$("#answerB").html(answerB);
				$("#answerC").html(answerC);
				$("#answerD").html(answerD);

			}
		});
	}
	//倒计时
	var intDiff = parseInt(60*30);//倒计时总秒数量
function timer(intDiff){
    window.setInterval(function(){
    var day=0,
        hour=0,
        minute=0,
        second=0;//时间默认值        
    if(intDiff > 0){
        day = Math.floor(intDiff / (60 * 60 * 24));
        hour = Math.floor(intDiff / (60 * 60)) - (day * 24);
        minute = Math.floor(intDiff / 60) - (day * 24 * 60) - (hour * 60);
        second = Math.floor(intDiff) - (day * 24 * 60 * 60) - (hour * 60 * 60) - (minute * 60);
    }
    if (minute <= 9) minute = '0' + minute;
    if (second <= 9) second = '0' + second;
    $('#day_show').html(day+"天");
    $('#hour_show').html('<s id="h"></s>'+hour+'时');
    $('#minute_show').html('<s></s>'+minute+'分');
    $('#second_show').html('<s></s>'+second+'秒');
    intDiff--;
    }, 1000);
} 
$(function(){
    timer(intDiff);
}); 
	//获取当前时间

	function startTime() {
		$("#time").text(new Date().toLocaleString());
		setTimeout('startTime()', 1000);
	}
	//提交试卷
	function submit() {
		window.location.href = "finish.html";
	}

	function getTime() {
		var start_time = new Date().getTime();
		$.ajax({
			url : "http://localhost:8080/shanChuanTest/time.te",
			type : "post",
			data : {
				"start_time" : start_time
			},
			dataType : "json",
			success : function(result) {
				msg = result[0].time;
				if (msg <= 0) {
					window.location.href = "finish.html";
					window.clearInterval(time_run);
				} else {
					$("#time").html(msg);
				}

			}

		});
	}

	//上一题
	var num=2;

	function back() {
		
		if(num<1){
			alert("已经是第一题了");
			$("#myback").hide();
			
		}else{
			$("#mynext").show();
			num--;
		$.ajax({

			url : "http://localhost:8080/MyWorkServer/getChoice.do",
			type : "post",
			data : {
				"flag" : num
			},
			dataType : "json",
			success : function(resultMap) {
				var qcontext = resultMap.question.qcontext;
				var answerA = resultMap.question.answerA;
				var answerB = resultMap.question.answerB;
				var answerC = resultMap.question.answerC;
				var answerD = resultMap.question.answerD;
					
				$("#context").html(qcontext);
				$("#answerA").html(answerA);
				$("#answerB").html(answerB);
				$("#answerC").html(answerC);
				$("#answerD").html(answerD);

			}
		});
		}
	}
	//下一题
	function next() {
		
		if(num>f){
			alert("已经是最后一道题了");
			$("#mynext").hide();
		}else
		{	
			$("#myback").show();
			++num;
		//var option = $("input[name='optionsRadios']:checked").val();
		$.ajax({

			url : "http://localhost:8080/MyWorkServer/getChoice.do",
			type : "post",
			data : {
				"flag" : num
			},
			dataType : "json",
			success : function(resultMap) {
			if(resultMap.flag == true){
				var qcontext = resultMap.question.qcontext;
				var answerA = resultMap.question.answerA;
				var answerB = resultMap.question.answerB;
				var answerC = resultMap.question.answerC;
				var answerD = resultMap.question.answerD;
			
				$("#context").html(qcontext);
				$("#answerA").html(answerA);
				$("#answerB").html(answerB);
				$("#answerC").html(answerC);
				$("#answerD").html(answerD);
				}
			}
		});
		}
	}
</script>
</html>