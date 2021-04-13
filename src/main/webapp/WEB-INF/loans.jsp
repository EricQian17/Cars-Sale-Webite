<%@ taglib prefix = "ex" uri = "./security.tld"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Car Loan for Year 2k</title>

<link rel="stylesheet" href="./css/format.css">

</head>
<body>
 <h1>Loan Scenarios / Car Payments</h1>
    <form action="./listloans" method="post"> 
	    S: Scenario <input type="text" name="times" value= "${times}"/>
	    L: Loan Amount <input type="text" name="amount" value= "${value1}" /> 
	    I: Interest Rate <input class="interest" name="interest" type="text" value="${value2}" /> % 
	    M: Monthly Payments <input type="submit" class="calculate" value="calculate" />
    </form> 
    <hr />
	<div class="divBody">
		<h1>Loan Scenarios / Car Payments</h1>
		<c:forEach items="${loanlist}" var='loan'>
		<div class='divScenario'>
			<span>S:</span>${loan.times} <br/> 
			<span>L:</span>${loan.amount} <br/> 
			<span>M:</span>${loan.payment} <br/> 
			<c:choose>
				<c:when test="${loan.payment-first >= 100}">
  				<img class="moneyimg" src="./images/100Bucks.jpg" />
  				</c:when>
  				<c:when test="${loan.payment-first >= 50}">
  				<img class="moneyimg" src="./images/money.png" />
  				</c:when>
  				<c:otherwise>
  				<img class="moneyimg" src="./images/placeholder.png" />
  				</c:otherwise>
				</c:choose>
		</div>	
		</c:forEach>
	</div>
<jsp:include page="inc-common-menu.jsp" />
<ex:security id="securityTag" />
</body>
</html>