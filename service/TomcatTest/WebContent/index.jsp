<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>菜鸟教程 </title>
	</head>
	<body>
			<%
			request.setCharacterEncoding("utf-8");
			String content=request.getParameter("content");
			out.print("<h1>你搜索的是"+content+"</h1>");
			%>
	</body>
</html>