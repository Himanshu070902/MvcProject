<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h2>Welcome to Home page</h2>
		<form method="post" action="LoginPage">
			<input type="hidden" name="logout" value="yes">
			<button type="submit">Logout</button>
		</form>

		<%
		if (request.getAttribute("message") != null) {
		%>

		<%=request.getAttribute("message")%>
		<%
		}
		%>
		<table>
			<tr>
				<td>ID</td>
				<td>:</td>
				<td><%=session.getAttribute("id")%></td>
			</tr>
			<tr>
				<td>Name</td>
				<td>:</td>
				<td><%=session.getAttribute("name")%></td>
			</tr>
			<tr>
				<td>Email</td>
				<td>:</td>
				<td><%=session.getAttribute("email")%></td>
			</tr>
			<tr>
				<td>Phone number</td>
				<td>:</td>
				<td><%=session.getAttribute("phone")%></td>
			</tr>

			<tr>
				<td colspan="3"><li class="nav-item"><a class="nav-link"
						href="Edit.jsp">Need to Edit ?</a></li></td>
			</tr>
		</table>
	</center>
</body>
</html>