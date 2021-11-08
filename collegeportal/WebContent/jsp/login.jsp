<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="shortcut icon" href="/collegeportal/images/favicon.ico" type="image/x-icon">
<link rel="icon" href="/collegeportal/images/favicon.ico" type="image/x-icon">
<script src="/collegeportal/js/validation.js"></script>
<script >
function main()
{
	var status=true
	var userid=document.getElementById("userid").value
	var userpass=document.getElementById("userpass").value
	//alert(userid+userpass)
	if(checkData(userid)==false){
		document.getElementById("msguserid").innerText="UserId Required"
		status=false
		
	}
	if(checkData(userpass)==false)
		{
		document.getElementById("msguserpass").innerText="Password Required"
			
		status=false
		
		}
	else{
		document.getElementById("msguserpass").innerText=""
			if(checkLength(userpass)==false)
			{
			document.getElementById("msguserpass").innerText="PAssword atleast 9 character"
			}
		
	}
	return status
	}
</script>
<style>
input[type=text], input[type=password] {
  padding: 12px 20px;
  margin: 8px 0;
  background: transparent; 
  border: none;
  outline: none;
  border-bottom: 2px solid black ;
  font-size: 10px;
}
button {
  background-color: black;
  color: white;
  padding: 14px 20px;
  margin-top: 15px;
  margin-left: 25px;
  border: none;
  border-radius: 100px;
  cursor: pointer;
  width: 250px;
}
button1 {
  background-color: black;
  color: white;
  padding: 14px 20px;
  margin-top: 15px;
  margin-left: 25px;
  border: none;
  border-radius: 100px;
  cursor: pointer;
  width: 250px;
}
.button2 {
  background-color: blue;
  color: white;
  padding: 10px 10px;
  margin-top:0px;
  border: none;
  border-radius: 100px;
  cursor: pointer;
  width: 500px;
}
h1{
margin-left: 90px;
}
p{
margin-left: 40px;
}
</style>
</head>
<body style="background-image: url('/collegeportal/images/background.jpg')">

<%
String errormsg=(String)request.getAttribute("msg");
System.out.println(errormsg);

%>
<div >

<div style="background-color: grey; width: 300px; height: 400px; margin-top: 80px; margin-left: 110px;">
<form action="/collegeportal/Login" method="post" onsubmit="return main()">

<h1>
Login

</h1>
<p>
Welcome Back! We Missed You
</p>
  <label for="uname" style="margin-left: 10px;"><b>Username:</b></label>
    <input type="text" placeholder="example@gmail.com" name="userid" id="userid">

    <label for="psw" style="margin-left: 10px;"><b>Password:</b></label>
    <input type="password" placeholder="********" name="userpass" id="userpass">

    <button type="submit">Login</button>
    <!-- <label><br>
      <input type="checkbox" checked="checked" name="remember" style="margin-left: 70px; margin-top: 10px;"> Remember me
    </label> -->
    <ul style="list-style-type: none">
    <li>
    <small id="msguserid" style="color: red"></small>
    </li>
    <li>
    <small id="msguserpass" style="color: red"></small>
    </li>
    
    
    </ul>
</form>
<%if(errormsg!=null)
{
%>
<span style="color:red"><%=errormsg %>
</span>
<%} %>


<%-- <div class="alert alert-info alert-dismissible fade show" role="alert">
  <strong><%=errormsg %></strong> 
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
  </div> --%>



<!-- <img alt="logo" src="/collegeportal/images/180ae7a0bcf7.png" style="width: 90px; height: 40px; margin-left: 40px; margin-top: 30px;">
<img alt="logo" src="/collegeportal/images/e9cd846dc748.png" style="width: 90px; height: 40px; margin-left: 40px;">
 --></div>
</div>
<button type="submit" style=" width: 290px; margin-left: 110px;">Forgot Password</button>
<div>
<button type="submit" style=" width: 290px; margin-left: 110px;">Create an Account</button>

</div>
</body>
</html>