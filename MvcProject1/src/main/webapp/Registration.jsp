<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
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
		<form action="registerPage" method="post">
			<h2>Registration page</h2>
			<div class="container">

				<%
				if (request.getAttribute("message") != null) {
				%>

				<%=request.getAttribute("message")%>

				<%
				}
				%>
				<div class="form-group col-md-4">
					<label>Name</label>
				</div>
				<div class="form-group col-md-4">
					<input type="text" name="name" class="form-control">
				</div>
				<div class="form-group col-md-4">
					<label>E mail</label>
				</div>
				<div class="form-group col-md-4">
					<input type="text" name="email" class="form-control">
				</div>
				<div class="form-group col-md-4">
					<label>Phone number</label>
				</div>
				<div class="form-group col-md-4">
					<input type="number" name="phone" class="form-control">
				</div>
				<div class="form-group col-md-4">
					<label>Password</label>
				</div>
				<div class="form-group col-md-4">
					<input type="password" name="password" class="form-control">
				</div>
				<div class="form-group col-md-4">
					<label>Confirm Password</label>
				</div>
				<div class="form-group col-md-4">
					<input type="password" name="conpassword" class="form-control">
				</div>

				<center>
					<input type="submit" value="Submit" class="btn btn-primary">
				</center>
			</div>
		</form>
		<li class="nav-item"><a class="nav-link" href="Login.jsp">ALready
				have account ?</a></li> <br>
	</center>
</body>
</html>