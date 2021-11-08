<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<%@include file="/WEB-INF/headers/adminheader.html" %>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="/collegeportal/css/style.css">
<script src="/collegeportal/js/validation.js"></script>
<script >
$(document).ready(function()	
		{
	$("#txtuserid").blur(function() {
		//alert(this.value)
		
		var userid=this.value;
		$.get("/collegeportal/Registration", {
		uid: userid	
		
			
		},
			function(data, status){
		$("#spanmsg").text(data)
		      //alert("Data: " + data + "\nStatus: " + status);
		    });
		 
		 
	/* 	$.post("/ecollege/jsp/demoajax.jsp",
				  {
				    name: "Scott",
				    city: "Lucknow"
				  },
				  function(data, status){
				    alert("Data: " + data + "\nStatus: " + status);
				  }); */
 
	});
	
	
		}
		)



</script>
<script >
function showCity(city)
{
	//alert(city)
	if(city=="others")
		document.getElementById("txtothers").style.display="block"
		else
			document.getElementById("txtothers").style.display="none"	
}
function main(){
	var status=true
	var cityname=document.getElementById("cmbcity").value
	if(checkCombo(cityname)==false){
		document.getElementById("cmbcity").after("Please select the city")
		status=false
		
	}
	var checkboxArray=document.getElementsByName("chklanguage")
	if(checkBox_Radio(checkboxArray)==false)
		{
		document.getElementById("chkhindi").after("Select atleast one language")
		status=false
		
		}
	
	
	
	return status
	
	
}

</script>
	
	
	
</head>
<body style="background-color: black;">
	<div style="width: 100%; height: 500px; background-color: black;">
	<div style="width: 100%; height: 10%; background-color: black;" ><span style="font-size: 30px; margin-left: 35%; color: white;">PARENT REGISTRATION</span></div>
	<form action="/collegeportal/Registration" method="post" onsubmit="return main()" >
		<table class="details container" style="background-color: grey; height: 400px; width: 600px; margin-left: 30%; margin-top: 20px;">

			<tr>
				<th>UserID</th>
				<th><input type="text" placeholder="Username" name="txtuserid" id="txtuserid" >
				<span id="spanmsg" style="color: red"></span>
				</th>
				
			</tr>
			<tr>
				<th>Password</th>
				<th><input type="text" placeholder="Password" name="txtuserpass" id="txtuserpass" ></th>
			</tr>
			<tr>
				<th>Name:</th>
				<th><input type="text" placeholder="Enter Your Name" name="txtusername" id="txtusername" ></th>
			</tr>
			<tr>
				<th>Phone:</th>
				<th><input type="number" placeholder="Enter Your Phone No" name="txtuserphone" id="txtuserphone" ></th>
			</tr>
			<tr>
				<th>Male<input type="radio" value="M" id="rdmale" name="gender">	
			
				<th>Female<input type="radio" value="F" id="rdfemale" name="gender"></th></tr>
			<tr>
				<th>Hindi<input type="checkbox" name="chklanguage"
					value="hindi" id="chkhindi" >
			
				<th>English<input type="checkbox" name="chklanguage"
					value="english" id="chkenglish" >
			<tr>
				<th>City</th>
				<th><select name="cmbcity" id="cmbcity" onchange="showCity(this.value)">
						<option value="default">Select City</option>
						<option value="lko">Lucknow</option>
						<option value="vns">Varanasi</option>
						<option value="Del">Delhi</option>
						<option value="Mum">Mumbai</option>
						<option value="others">Others</option>
				</select>
				<input type="text" name="txtothers" id ="txtothers" style="display: none">
				</th>
			</tr>
			<tr>
				<th></th>
			<th><button type="reset" style="border-radius: 10px; background-color: red; margin-left: 100px;">Clear</button>
		<button type="submit" style="border-radius: 10px; background-color: green; margin-left: 100px;">Submit</button>	
		
</th>
		</table>
		
		</form>
		
	</div>
	
	
	<%@include file="/jsp/message.jsp" %>
	

</body>
</html>