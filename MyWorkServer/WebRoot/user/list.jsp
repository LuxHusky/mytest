
<%@ page language="java" pageEncoding="UTF-8"%>

<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		<script type="text/javascript" src="../js/cookie_util.js"></script>
		<script type="text/javascript" src="../js/jquery.min.js"></script>
		<script type="text/javascript" src="../js/jquery.cookie.js"></script>
	</HEAD>
	<style>
		.show {

				 position:absolute;
				
				 left:338px;
				
				 top:91px;
				
				
				
				 z-index:1;
				
				 border:solid #7A7A7A 4px; 
				 
				 background-color: #ccc;
				 padding: 20px;
				
				}
</style>
	<body>
		
		<br>
		
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>查 询 条 件</strong>
						</td>
					</tr>
					<tr>
						<td>
							<table cellpadding="0" cellspacing="0" border="0" width="100%">
								<tr>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
										用户姓名：
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<input id="myusername" type="text">
									</td>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
										所属部门：
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<input type="text" id="myuserDepartment">
									</td>
								</tr>
								<tr>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
										工号：
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<input id="myuserId" type="text">
									</td>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
										上传题目
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<button id="addAll" height="22" align="center">上传</button>
									</td>
								</tr>
								<tr>
									<td width="100" height="22" align="center" bgColor="#f5fafe"
										class="ta_01">
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<font face="宋体" color="red"> &nbsp;</font>
									</td>
									<td align="right" bgColor="#ffffff" class="ta_01"><br><br></td>
									<td align="right" bgColor="#ffffff" class="ta_01">
										<button type="submit" id="search" value="&#26597;&#35810;" class="button_view">查询</button>

										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="reset" value="&#37325;&#32622;" class="button_view"/>

									</td>
								</tr>
							</table>
						</td>

					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>用 户 列 表</strong>
						</TD>
					</tr>
					<tr>
						<td class="ta_01" align="right">
							<button type="button" id="add" name="add" value="添加" class="button_add">
&#28155;&#21152;
</button>

						</td>
					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr 
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td  align="center" width="18%">
										登录名
									</td>
									<td align="center" width="17%">
										用户姓名
									</td>
									<td align="center" width="8%">
										所属部门
									</td>
									<td align="center" width="23%">
										工号
									</td>
									<td width="11%" align="center">
										考试成绩
									</td>
									<td width="7%" align="center">
										编辑
									</td>
									<td width="7%" align="center">
										查看
									</td>
									<td width="7%" align="center">
										删除
									</td>
								</tr>
								<tbody id="mybody">
						
								</tbody>
							</table>
						</td>
					</tr>
				</TBODY>
			</table>
			<div id="xinxi3" class="show" style="display: none;">
    		<form id="fileUpload" enctype="multipart/form-data"  name="fileUpload">
		<input type="file" id="file" name="file">
		<input type="hidden" id="studentId">
		</form>
    		<div style="padding: 20px;"><button onclick="piliang()">提交</button><button onclick="back3();">取消</button></div>
    	</div>
			
		<script type="text/javascript">
			$(function() {
				$("#search").click(search);
				$("#add").click(add);
				$("#addAll").click(addAll);
				
			});
			//增加用户
			function add(){
			$("#DataGrid1").append('<tr><td align="center" width="18%">1</td></tr>');	
			}
			//查询用户
			function search(){
			var myusername =$("#myusername").val().trim();
			var myuserDepartment=$("#myuserDepartment").val().trim();
			var	myuserId=$("#myuserId").val().trim();
			$.ajax({

					url : "http://localhost:8080/MyWorkServer/admin.do",
					type : "post",
					data : {
						"myusername" : myusername,
						"myuserDepartment" : myuserDepartment,
						"myuserId":myuserId
					},
					dataType : "json",
					success : function(resulMap) {
						if(resulMap.flag == true){
							var tr="";
							var obj=resulMap.obj;
							$("#DataGrid1 #mybody").empty();
							for(var i= 0;i<obj.length;i++){
							tr+=("<tr>"
							+"<td align='center' width='18%'>"+obj[i].account+"</td>"
							+"<td align='center' width='17%'>"+obj[i].name+"</td>"
							+"<td align='center' width='8%'>"+obj[i].department+"</td>"
							+"<td align='center' width='23%'>"+obj[i].id+"</td>"
							+"<td align='center' width='11%'>"+obj[i].user_sorce+"</td>"
							+"<td align='center' width='7%'>"+obj[i].name+"</td>"
							+"<td align='center' width='7%'>"+obj[i].name+"</td>"
							+"<td align='center' width='7%'>"+obj[i].name+"</td>"							
							+"</tr>");
										
							}
							$("#DataGrid1 #mybody").append(tr);	
						}
					}
				});
			}
			//加入试题
			function addAll(){
    		$("#xinxi3").show();
    	}
    	function piliang(){
    		var fd = new FormData(document.getElementById("fileUpload"));
			$.ajax({
				type : "post",
				url : "http://localhost:8080/MyWorkServer/upChoice.do",
				dataType : "json",
				data : fd,
				processData: false,  // 告诉jQuery不要去处理发送的数据
				contentType: false,   // 告诉jQuery不要去设置Content-Type请求头

				success : function(resultMap) {
					
						if(resultMap.flag == true){
							alert(resultMap.Msg);
							$("#xinxi3").hide();
							initList();
						}else{
							alert(resultMap.Msg);
						}
					
					
				},
				error: function() {
					
					return false;
				}
			});
    	}
    	function back3(){
    		$("#xinxi3").hide();
    	}
	
	</script>
	</body>
	
	
</HTML>

