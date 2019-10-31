<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	
	<form action="<%=request.getContextPath()%>/check-login" method="post">
		<%
			String msg = request.getParameter("msg");
			if("loginError".equals(msg)){
		%>
		<p style="color: red">Sai username hoặc password</p> <br>
		<%
			}
		%>
		<label>Username:</label>
		<input type="text" name="username"> <br><br>
		<label>Password:</label>
		<input type="password" name="password"> <br><br>
		<input type="submit" value="submit"/>
		<input type="reset" value="reset"/>
	</form>
</body>
</html>