<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CocPlatform</title>
	<script type="text/javascript">
		var url = location.search;
		if(url.indexOf("?")!=-1){
			alert("账号或密码输入错误");
		}
	</script>
</head>
<body>
<div style="width:500px;height:500px;margin:auto;">
	<form method="post" action="LoginController">
		<table>
			<tr>
				<td>
					<font size="7">COC</font><br><font size="4">Platform</font>
				</td>
				<td>
					<image src="images/login_background.jpg"></image>
				</td>
			</tr>
			<tr>
				<td>
					请输入您的账号：
				</td>
				<td>
					<input type="text" name="account" id="account" />
				</td>
			</tr>
			<tr>
				<td>
					请输入您的密码：
				</td>
				<td>
					<input type="password" name="password" id="password" />
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="登录">
				</td>
				<td>
					<input type="reset" value="重置">
				</td>
			</tr>
			<tr>
				<td>
					<a href="">忘记密码？</a>
				</td>
				<td>
					<a href="register.jsp">注册</a>
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>