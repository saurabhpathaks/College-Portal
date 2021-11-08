<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="collegeportal.student.*,collegeportal.beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit student Profile</title>
<%@include file="/html/commonheaders.html"%>
</head>
<body>
<%@include file="/WEB-INF/headers/studentheader.html" %>
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
else
{
	AdminTask at=new AdminTask();
	at.viewprofile(uid);
	Student_bean sb=at.viewprofile(uid);

%>
<div style="width: 100%; height: auto;">
	<form action="/collegeportal/Editstudentprofile" method="post" onsubmit="return main()">
		<table class="details" >
			<tr>
				<th>Email:</th>
				<th><input type="text" placeholder="Enter Your Name" 
					name="email" id="txtusername" value="<%=sb.getEmail() %>" ></th>
			</tr>
			<tr>
				<th>Phone:</th>
				<th><input type="number" placeholder="Enter Your Phone No"
					name="phone" id="txtuserphone" value="<%=sb.getPhone()%>" ></th>
			
					
				<th><button type="submit">Update</button></th>
			</tr>

		</table>
</form>
	</div>
	<%@include file="/html/commonfooters.html"%>
<%} %>





</body>
</html>