<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Page</title>
</head>
<body>
	<center>
		<h2>Welcome to Edit page</h2>
		<form action="editPage" method="post">

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
					<td><input name="id"
						value=" <%=session.getAttribute("id")%>" readonly="readonly">
					</td>
				</tr>
				<tr>
					<td>Name</td>
					<td>:</td>
					<td><input name="name"
						value=" <%=session.getAttribute("name")%>"></td>
				</tr>
				<tr>
					<td>Email</td>
					<td>:</td>
					<td><input name="mail"
						value="<%=session.getAttribute("email")%>"></td>
				</tr>
				<tr>
					<td>Phone number</td>
					<td>:</td>
					<td><input name="phone"
						value="<%=session.getAttribute("phone")%>"></td>
				</tr>

				<tr>
					<td colspan="3"><center>
							<input type="submit" value="Submit" class="btn btn-primary">
						</center></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>