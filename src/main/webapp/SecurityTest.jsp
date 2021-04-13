<%@ taglib prefix = "ex" uri = "WEB-INF/security.tld"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	P: <p id="security"> paragraph </p>
	<hr/>
	<ex:security id="securityTag" minutes=".15" />

</body>
</html>