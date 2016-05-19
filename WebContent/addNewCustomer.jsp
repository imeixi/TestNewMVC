<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="cn.imeixi.mvcapp.domain.Customer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		Object msg = request.getAttribute("message");
		if(msg != null){
	%>

		<font color = "red" ><%= msg %></font>
		<br>
	<%
	}
	%>

	<form action="addCustomer.do" method="post">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name"
					value="<%=request.getParameter("name") == null ? "" : request.getParameter("name")%>"><br></td>
			</tr>

			<tr>
				<td>Address:</td>
				<td><input type="text" name="address"
					value="<%=request.getParameter("address") == null ? "" : request.getParameter("address")%>"><br></td>
			</tr>

			<tr>
				<td>Phone:</td>
				<td><input type="text" name="phone"
					value="<%=request.getParameter("phone") == null ? "" : request.getParameter("phone")%>"><br></td>
			</tr>

			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>

</body>
</html>