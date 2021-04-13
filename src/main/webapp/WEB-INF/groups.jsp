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

	<h2>${groupId} Group Report</h2>
	
	
	<a href="group?action=AB">AB</a>
	<a href="group?action=DC">DC</a>
	<a href="group?action=EF">EF</a>
	<a href="group?action=GG">GG</a>
	<a href="group?action=HK">HK</a>
	<a href="group?action=LM">LM</a>
	<a href="group?action=NN">NN</a>
	<a href="group?action=OP">OP</a>
	<a href="group?action=QR">QR</a>
	<a href="group?action=ST">ST</a>
	<a href="group?action=UV">UV</a>
	<a href="group?action=WX">WX</a>
	<table class="pure-table pure-table-horizontal">
		<thead>
			<tr>
				<th>group</th>
				<th>name</th>
				<th>city</th>
				<th>month</th>
				<th>pricePaid</th>
				<th>vendorPrice</th>
				<th>income</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${groupList}" var='group'>
			
				<tr>
					<td><c:out value="${group.groupId}" /></td>
					<td id><c:out value="${group.name}" /></td>
					<td id><c:out value="${group.cityId}" /></td>
					<td id><c:out value="${group.purchaseMonth}" /></td>
					<td id="money"><c:out value="${group.pricePaid}" /></td>
					<td id="money"><c:out value="${group.vendorPrice}" /></td>
					<td id="money"><c:out value="${group.income}" /></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			
			<tr>
				<td colspan='4'>Total: </td>
				<td id="money"><c:out value="${total}" /></td>
			</tr>
			<tr>
				<td colspan='4'>Average: </td>
				<td id="money"><c:out value="${average}" /></td>
			</tr>

		</tfoot>
	</table>
	<jsp:include page="inc-common-menu.jsp" />
	<ex:security id="securityTag" />
</body>
</html>