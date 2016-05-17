<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h4>使用 method 方法参数</h4>
	<a href = "customerServlet?method=addCustomer">AddCustomer</a>
	<br><br>
	<a href = "customerServlet?method=query">Query</a>
	<br><br>
	<a href = "customerServlet?method=delete">DeleteCustomer</a>
	<br><br>

	<h4>使用 *.do 映射</h4>
	<a href = "addCustomer.do">AddCustomer</a>
	<br><br>
	<a href = "query.do">Query</a>
	<br><br>
	<a href = "delete.do">DeleteCustomer</a>
	<br><br>
</body>
</html>