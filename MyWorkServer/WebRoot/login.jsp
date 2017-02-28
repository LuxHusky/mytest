<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>山船考试系统登录界面</title>
<link rel="stylesheet" href="css/lrtk.css">
<script type="text/javascript" src="js/cookie_util.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<style type="text/css">
h1 {
	text-align: center;
}
</style>
</head>
<body>
	<!-- 代码 开始 -->
	<h1>山船考试系统</h1>

	<div id="login">
		<div class="wrapper">
			<div class="login">
				<form action="" method="post" class="container offset1 loginform">
					<div id="owl-login">
						<div class="hand"></div>
						<div class="hand hand-r"></div>
						<div class="arms">
							<div class="arm"></div>
							<div class="arm arm-r"></div>
						</div>
					</div>
					<div class="pad">
						<input type="hidden" name="_csrf"
							value="9IAtUxV2CatyxHiK2LxzOsT6wtBE6h8BpzOmk=">
						<div class="control-group">
							<div class="controls">
								<label for="email" class="control-label fa fa-envelope"></label>
								<input id="email" type="email" name="email" placeholder="Email"
									tabindex="1" autofocus="autofocus"
									class="form-control input-medium">

							</div>
						</div>
						<div class="control-group">
							<div class="controls">
								<label for="password" class="control-label fa fa-asterisk"></label>
								<input id="password" type="password" name="password"
									placeholder="Password" tabindex="2"
									class="form-control input-medium">
							</div>
						</div>
					</div>
					<div class="form-actions">
						<a href="" tabindex="5" class="btn pull-left btn-link text-muted">忘记密码</a><a
							href="register.jsp" tabindex="6" class="btn btn-link text-muted">注册</a>
						<button type="button" tabindex="4" class="btn btn-primary"
							id="mylogin">登录</button>
					</div>

				</form>

			</div>
		</div>

		<script>
			$(function() {

				$('#login #password').focus(function() {
					$('#owl-login').addClass('password');
				}).blur(function() {
					$('#owl-login').removeClass('password');
				});
			});
			//按钮点击事件
			$(function() {
				$("#mylogin").click(login);
			})
			//登录
			function login() {
				var name = $("#email").val().trim();
				var pwd = $("#password").val().trim();
				if (name == "") {
					alert("用户名不能为空");
					return;
				}
				if (pwd == "") {
					alert("密码不能为空");
					return;
				}
				$.ajax({

					url : "http://localhost:8080/MyWorkServer/myUserLogin.do",
					type : "post",
					data : {
						"username" : name,
						"password" : pwd
					},
					dataType : "json",
					success : function(resultMap) {

						if (!resultMap.flag == true) {
							alert(resultMap.Msg);
						} else {
							if (resultMap.loginType == "考生") {
							$.cookie('name', resultMap.userInfo.name);
							$.cookie('userid', resultMap.userInfo.id);
							$.cookie('total',resultMap.total);
							
								window.location.href = "test.jsp";
							} else {
								window.location.href = "index.jsp";
							}

						}
					}
				});
			}
		</script>
	</div>
</body>
</html>