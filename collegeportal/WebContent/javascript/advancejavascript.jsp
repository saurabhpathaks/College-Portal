<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Advance Javascript</title>
<%@ include file="/html/commonheaders.html" %>
</head>
<body>

<button id="btn" >ClickMe</button>
<p id="p1"></p>
<script >
var bt=document.getElementById("btn");
var para=document.getElementById("p1");
bt.addEventListener("click",function()
		{
	para.innerText="Hello"
	}
	
	
	);



</script>


<%@ include file="/html/commonfooters.html" %>
</body>
</html>