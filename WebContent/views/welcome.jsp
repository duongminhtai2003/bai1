<%@page import="model.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		User user = (User)session.getAttribute("user");
		String address = (String) request.getAttribute("address");
	%>
	<p>Welcome<%=user.getUsername()%>!</p><br>
	<p>you are living at <%=address%></p><br>
	
</body>
</html>