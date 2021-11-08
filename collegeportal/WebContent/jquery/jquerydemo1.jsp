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
	
	$("#topdiv").click(function()
			{
		//alert("Button is clicked")
		$("#bottomdiv").slideDown();
		$("#bottomdiv").show();
		
		}
	)
        

    $("#bottomdiv").slide(function()
		{
	//alert("Button is clicked")
	
	}
   )
    }

);


</script>
</head>
<body>
<div id="topdiv" class=" container bg-warning">
Hello


</div>
<div id="bottomdiv" style="display: none;" class=" container bg-success">

Hello


</div>

<%@ include file="/html/commonfooters.html" %>
</body>
</html>