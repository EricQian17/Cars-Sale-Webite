<%@ taglib prefix = "ex" uri = "./security.tld"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Cities</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css"
	integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w"
	crossorigin="anonymous">

<style>
body {
	padding: 1em
}

nav {
	margin-top: 2em
}
</style>
<script type="text/javascript">
	function save() {
		document.forms[0].submit();
	}
</script>


</head>
<body>

	<h2>Cities - ${cityId}</h2>
	<form method="post" action="./cities">
		<table class="pure-table pure-table-horizontal">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Income</th>
				</tr>
			</thead>

			<c:forEach items="${cities}" var='city'>


				<c:if test="${cityId == city.cityId }">
					<tr>
						<td><input type="button" value="modify" onclick="save()" /></td>
						<td>
						<input type="text" value="${city.regionName}" name="regionName"/>
						<input type="hidden" value="${city.cityId}" name="cityId"/>
						</td>
						<td><c:out value="${city.income}" /></td>
					</tr>
				</c:if>

				<c:if test="${cityId != city.cityId }">
					<tr>
						<td><a href="./cities?action=update&id=${city.cityId}">Edit
						</a>${city.cityId}</td>
						<td><c:out value="${city.regionName}" /></td>
						<td><c:out value="${city.income}" /></td>
					</tr>
				</c:if>


			</c:forEach>

		</table>
	</form>
	<jsp:include page="inc-common-menu.jsp" />
	<ex:security id="securityTag" />
</body>
</html>