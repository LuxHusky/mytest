<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="css/restyle.css" type="text/css"
	media="screen" />
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/sliding.form.js"></script>
</head>
<style>
span.reference {
	position: fixed;
	left: 5px;
	top: 5px;
	font-size: 10px;
	text-shadow: 1px 1px 1px #fff;
}

span.reference a {
	color: #555;
	text-decoration: none;
	text-transform: uppercase;
}

span.reference a:hover {
	color: #000;
}

h1 {
	color: #ccc;
	font-size: 36px;
	text-shadow: 1px 1px 1px #fff;
	padding: 20px;
}
</style>
<body>
	<div id="content">
		<h1>山船考试系统注册界面</h1>
		<div id="wrapper">
			<div id="steps">
				<form id="formElem" name="formElem" action="" method="post">
					<fieldset class="step">
						<legend>账户信息</legend>
						<p>
							<label for="username">用户名</label> <input id="username"
								name="username" />
						</p>
						<!--    <p>
                                <label for="email">Email</label>
                                <input id="email" name="email" placeholder="info@htmleaf.com" type="email" AUTOCOMPLETE=OFF />
                            </p>   -->
						<p>
							<label for="password">密码</label> <input id="password"
								name="password" type="password" AUTOCOMPLETE=OFF />
						</p>
					</fieldset>
					<fieldset class="step">
						<legend>个人信息</legend>
						<p>
							<label for="name">姓名</label> <input id="name" name="name"
								type="text" AUTOCOMPLETE=OFF />
						</p>
						<!--  <p>
                                <label for="country">Country</label>
                                <input id="country" name="country" type="text" AUTOCOMPLETE=OFF />
                            </p>
                            -->
						<p>
							<label for="id">工号</label> <input id="id" name="id"
								placeholder="请输入8位工号" type="text" AUTOCOMPLETE=OFF />
						</p>
						<p>
							<label for="department">所属部门</label> <select id="department"
								name="department">
								<option>信息中心</option>
								<option>生产管理部</option>
								<option>舾装部</option>
							</select>
						</p>
						<!--  <p>
                                <label for="website">Website</label>
                                <input id="website" name="website" placeholder="e.g. http://www.htmleaf.com" type="tel" AUTOCOMPLETE=OFF />
                            </p>
                            -->
					</fieldset>

					<!--    <fieldset class="step">
                            <legend>Payment</legend>
                            <p>
                                <label for="cardtype">Card</label>
                                <select id="cardtype" name="cardtype">
                                    <option>Visa</option>
                                    <option>Mastercard</option>
                                    <option>American Express</option>
                                </select>
                            </p>
                            <p>
                                <label for="cardnumber">Card number</label>
                                <input id="cardnumber" name="cardnumber" type="number" AUTOCOMPLETE=OFF />
                            </p>
                            <p>
                                <label for="secure">Security code</label>
                                <input id="secure" name="secure" type="number" AUTOCOMPLETE=OFF />
                            </p>
                            <p>
                                <label for="namecard">Name on Card</label>
                                <input id="namecard" name="namecard" type="text" AUTOCOMPLETE=OFF />
                            </p>
                        </fieldset>
                        <fieldset class="step">
                            <legend>Settings</legend>
                            <p>
                                <label for="newsletter">Newsletter</label>
                                <select id="newsletter" name="newsletter">
                                    <option value="Daily" selected>Daily</option>
                                    <option value="Weekly">Weekly</option>
                                    <option value="Monthly">Monthly</option>
                                    <option value="Never">Never</option>
                                </select>
                            </p>
                            <p>
                                <label for="updates">Updates</label>
                                <select id="updates" name="updates">
                                    <option value="1" selected>Package 1</option>
                                    <option value="2">Package 2</option>
                                    <option value="0">Don't send updates</option>
                                </select>
                            </p>
							<p>
                                <label for="tagname">Newsletter Tag</label>
                                <input id="tagname" name="tagname" type="text" AUTOCOMPLETE=OFF />
                            </p>
                        </fieldset>
                        -->
					<fieldset class="step">
						<legend>注册</legend>
						<p>请仔细检查之前提交内容是否有误，全部正确可以点击注册按钮进行注册</p>
						<p class="submit">
							<button id="register" type="submit">注册</button>
						</p>
					</fieldset>
				</form>
			</div>
			<div id="navigation" style="display:none;">
				<ul>
					<li class="selected"><a href="#">账户</a>
					</li>
					<li><a href="#">个人信息</a>
					</li>
					<!--  <li>
                            <a href="#">Payment</a>
                        </li>
                        <li>
                            <a href="#">Settings</a>
                        </li>
                        -->
					<li><a href="#">注册</a>
					</li>
				</ul>
			</div>
		</div>
	</div>

</body>
<script type="text/javascript">
	$(function() {

		$("#register").click(register);
	})
	function register() {
		var username = $("#username").val().trim();
		var password = $("#password").val().trim();
		var name = $("#name").val().trim();
		var id = $("#id").val().trim();
		var department = $("#department").val();
		$.ajax({

			url : "http://localhost:8080/MyWorkServer/myUserRegister.do",
			type : "post",
			data : {
				"username" : username,
				"password" : password,
				"name" : name,
				"id" : id,
				"department" : department
			},
			dataType : "json",
			success : function(resultMap) {
				
				if (!resultMap.flag == true){
					alert(resultMap.Msg);
				} 
				else{
					window.location.href = "login.jsp";
				}
			}
		});
	}
</script>
</html>







