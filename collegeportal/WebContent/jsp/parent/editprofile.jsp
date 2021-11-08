<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="collegeportal.parent.*,collegeportal.beans.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Profile</title>
<%@include file="/html/commonheaders.html"%>
</head>
<body>
<%@include file="/WEB-INF/headers/parentheader.html" %>
<%
HttpSession hs=request.getSession(false);
String uid=(String)hs.getAttribute("session_userid");
if(uid==null||hs.isNew())
{
	request.setAttribute("msg", Message.INVALID_ACCESS);
	RequestDispatcher dispatcher=request.getRequestDispatcher("/jsp/login.jsp");
	dispatcher.forward(request, response);
%>
<%}
else{
ParentTask pt=new ParentTask();
pt.viewProfile(uid);
Parent p=pt.viewProfile(uid);
%>
<div style="width: 100%; height: auto;">
	<form action="/collegeportal/Editprofile" method="post" onsubmit="return main()">
		<table class="details" >
			<tr>
				<th>Name:</th>
				<th><input type="text" placeholder="Enter Your Name" readonly="readonly"
					name="txtname" id="txtusername" value="<%=p.getName()%>" ></th>
			</tr>
			<tr>
				<th>Phone:</th>
				<th><input type="number" placeholder="Enter Your Phone No"
					name="txtphone" id="txtuserphone" value="<%=p.getPhone()%>" ></th>
			<th>City</th>
				<th><input type="text" placeholder="Enter Your City"
					name="txtcity" id="txtuserphone"  value="<%=p.getCity() %>">
					<input type="hidden" name="txthidden" value="<%=uid%>">
					</th>
					
				<th><button type="submit">Update</button></th>
			</tr>

		</table>
</form>
	</div>




<%} %>
</body>
</html>