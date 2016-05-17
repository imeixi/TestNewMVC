<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="cn.imeixi.mvcapp.domain.Customer" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form	action="query.do" method="post">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" value=""><br></td>
			</tr>
			
			<tr>
				<td>Address:</td>
				<td><input type="text" name="address" value=""><br></td>
			</tr>
			
			<tr>
				<td>Phone:</td>
				<td><input type="text" name="phone" value=""><br></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Query"></td>
				<td><a href="update.do">add New Customer</a><br></td>
			</tr>
		</table>
	</form>	
	
	<hr>
	
	<%
		List<Customer> customers = (List<Customer>)request.getAttribute("customers");
		if(customers != null && customers.size() > 0){
	%>
	<table border="1" cellpadding="10" cellspacing="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Address</th>
			<th>phone</th>
			<th>UPDATE\DELETE</th>
		</tr>
		
		<%
			for(Customer customer:customers){
		%>
		<tr>
			<td><%= customer.getId() %></td>
			<td><%= customer.getName() %></td>
			<td><%= customer.getAddress() %></td>
			<td><%= customer.getPhone() %></td>
			<td>
				<a href="">UPDATE</a>
				<a href="delete.do">DELETE</a>
			</td>
		</tr>
		<%
			}
		%>
	
	</table>
	<%
		}
	%>

</body>
</html>