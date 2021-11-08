<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jquery Demo</title>
<%@ include file="/html/commonheaders.html" %>
<%@ include file="/html/commonfooters.html" %>
<script >
$(document).ready(function()
		{
//alert("function")
	
	$("#btnshow").click(function()
			{
		//alert("Button is clicked")
		$("#p1").show();
		}
	)
        

    $("#btnhide").click(function()
		{
	//alert("Button is clicked")
	$("#p1").hide();
	}
   )
    }

);


</script>
</head>
<body>
<button id="btnshow">Show</button>
<button id="btnhide">Hide</button>
<p id="p1" style="display: none;">hello world</p>
<%@ include file="/html/commonfooters.html" %>
</body>
</html>