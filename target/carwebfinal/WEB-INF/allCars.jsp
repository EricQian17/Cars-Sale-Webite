<%@ taglib prefix = "ex" uri = "./security.tld"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Cars</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css"
	integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="money.css">

<style>
body {
	padding: 1em
}

nav {
	margin-top: 2em
}
</style>
</head>
<body>

	<h2>All Cars</h2>

	<table class="pure-table pure-table-horizontal">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Price</th>
				<th>Vendor</th>
				<th>Profit</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${carList}" var='car'>
				<tr>
					<td><c:out value="${car.id}" /></td>
					<td id><c:out value="${car.name}" /></td>
					<td id="money"><c:out value="${car.price}" /></td>
					<td id="money"><c:out value="${car.vendorprice}" /></td>
					<td id="money"><c:out value="${car.profit}" /></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan='4'>Average: </td>
				<td id="money"><c:out value="${average}" /></td>
			</tr>
			<tr>
				<td colspan='4'>Total: </td>
				<td id="money"><c:out value="${total}" /></td>
			</tr>

		</tfoot>
	</table>

<jsp:include page="inc-common-menu.jsp" />
<ex:security id="securityTag" />
</body>
</html>