<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>


</head>
<body>

	<center>
		<form action="LoginPage" method="post">
			<h2>Login page</h2>
			<div class="container">

				<%
				if (request.getAttribute("message") != null) {
				%>

				<%=request.getAttribute("message")%>

				<%
				}
				%>

				<div class="form-group col-md-4">
					<label>E mail</label>
				</div>
				<div class="form-group col-md-4">
					<input type="text" name="email" class="form-control">
				</div>

				<div class="form-group col-md-4">
					<label>Password</label>
				</div>
				<div class="form-group col-md-4">
					<input type="password" name="password" class="form-control">
				</div>


				<center>
					<input type="submit" value="Submit" name="login"
						class="btn btn-primary">
				</center>
			</div>
		</form>
		<li class="nav-item"><a class="nav-link" href="ForgotPass.jsp">Forgot
				password?</a></li>

		<li class="nav-item"><a class="nav-link" href="Registration.jsp">Need
				to register ?</a></li>

	</center>
</body>
</html>