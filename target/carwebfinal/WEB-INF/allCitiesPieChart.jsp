<%@ taglib prefix = "ex" uri = "./security.tld"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
 
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
window.onload = function() { 
	
	/*
		${dataPoints}
	
	
	*/
	
	let data = 
	[{exploded: true, y: 235, label: "Health"}
	,{exploded: false, y: 20, label: "Finance"}
	,{exploded: false, y: 18, label: "Career"}
	,{exploded: false, y: 15, label: "Education"}
	,{exploded: false, y: 5, label: "Family"}
	,{exploded: false, y: 7, label: "Real Estate"}];
 
	var chart = new CanvasJS.Chart("chartContainer", {
		theme: "light2",
		animationEnabled: true,
		exportFileName: "New Year Resolutions",
		exportEnabled: true,
		title:{
			text: "${title}"
		},
		data: [{
			type: "pie",
			showInLegend: true,
			legendText: "{label}",
			toolTipContent: "{label}: <strong>{y}%</strong>",
			indexLabel: "{label} {y}",
			dataPoints : ${dataPoints} 
		}]
	});
	 
	chart.render();
 
}

</script>	

</head>
<body>
<div id="chartContainer" style="height: 370px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<jsp:include page="inc-common-menu.jsp" />
<ex:security id="securityTag" />
</body>
</html>  