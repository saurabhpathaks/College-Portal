<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feedback Form</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


<link rel="stylesheet" type="text/css"
	href="/collegeportal/css/style.css">
<link rel="shortcut icon" href="/collegeportal/images/favicon.ico" type="image/x-icon">
<link rel="icon" href="/collegeportal/images/favicon.ico" type="image/x-icon">

<script src="/collegeportal/js/validation.js"></script>
<script>
function main(){
	var status=true
	var fname=document.getElementById("fname").value
	var emailid=document.getElementById("email").value
	var phone=document.getElementById("contactno").value
	
	if(checkData(name)==false){
		document.getElementById("msgname").innerText="Mention Your Name"
		status=false
		
	}
	if(checkData(emailid)==false){
		document.getElementById("msgemail").innerText="Mention Your EmailId"
			document.getElementById("email").after("gjdvfjdsb")
		status=false
		
	}
	if(checkData(phone)==false){
		document.getElementById("msgphone").innerText="Mention Your ContactNo"
		status=false
		
	}
	
	return status
}
</script>
<style >
.input{
	content: '';
	position: absolute;
	bottom: -2px;
	width: 0%;
	height: 2px;
	background-color: #38d39f;
	transition: .4s;
}
.hff{
	
	padding: 0 0 10px;
	text-align: center;
	font-size: 15px;
}
</style>
</head>
<body class="bgimg">

<%
String msg=(String)request.getAttribute("ms");
System.out.println(msg);

%>

<form action="/collegeportal/Feedback" method="post" onsubmit="return main()">
<div  class="ffdiv">

<img src="/collegeportal/images/feedlogo.png" alt="feedlogo" width="200" height="70" style="margin-left: 90px;"><br>
<span style="margin-left: 80px;">Your Feedback is Important for us...</span>


<table class="ffdetails">
  <tr>
    <th>Name:</th>
    <td>
    <input type="text" id="name" name="fname" placeholder="Enter your name here">
    </td>
  </tr>
  <tr>
    <th>Email:</th>  
    <td><input type="text" id="email" name="emailid" placeholder="feedback@gmail.com"></td>      
  </tr>  
  <tr>
    <th>Phone:</th>
    <td><input type="text" id="contactno" name="phone" placeholder="942XXXXX01"></td>
  </tr>
  <tr>
    <th>Feedback:</th>
    <td> <input type="text" id="feedback" name="feedback" placeholder="Write your feedback">
    </td>
    </tr>
 <tr>
				<th>Rating:</th>
				<th><select name="rating" style="width:200px; height: 30px; margin-right: 150px;">
						<option value="default">Select</option>
						<option value="one">1</option>
						<option value="two">2</option>
						<option value="three">3</option>
						<option value="four">4</option>
				</select></th>
			</tr>
</table>
<button class="button"  >
 Submit
 </button>
 <ul style="list-style-type: none">
    <li>
    <small id="msgname" style="color: red"></small>
    </li>
    <li>
    <small id="msgemail" style="color: red"></small>
    </li>
    <li>
    <small id="msgphone" style="color: red"></small>
    </li>
    
    </ul>
    
</div>
</form>
<% if(msg!=null)
{
%>
<span style="color: red;font-size: 100px;text-align: center;"><%=msg %></span>
 <%
}
%>

<%-- <div class="alert alert-info alert-dismissible fade show" role="alert">
  <strong><%=feedbackmsg %></strong> 
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
  </div> --%>







</body>
</html>