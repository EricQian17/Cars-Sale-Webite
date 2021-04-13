<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<style>
		
	label {
		width: 1in;
		display: inline-block;
		padding-bottom: 6px;
	
	}

	
</style>
</head>
<body>
	<h1>Login Page</h1>

	<form method="post" action="./login">
		<label>user id: </label><input type="text" name="userId" /> <br/>
		<label>password: </label><input type="text" name="password" /> <br/>
		<br/>
		<input type="submit" />
	
	</form>

</body>
</html>