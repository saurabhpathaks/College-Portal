<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="collegeportal.student.*,collegeportal.beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Profile</title>
<%@include file="/html/commonheaders.html"%>
</head>
<body>
<%
HttpSession hs=request.getSession(false);
String uid=(String)hs.getAttribute("session_userid");
if(uid==null||hs.isNew())
{
	request.setAttribute("msg", Message.INVALID_ACCESS);
	RequestDispatcher dispatcher=request.getRequestDispatcher("/jsp/login.jsp");
	dispatcher.forward(request, response);
}
else{
AdminTask at=new AdminTask();
Student_bean sb=at.viewprofile(uid);
%>
<div class="card" style="width: 200px;">
<div>
<p class="card-text text danger">
<%=sb.getStudentid() %>
<p class="card-text text danger">
<%=sb.getPassword() %>
<p class="card-text text danger">
<%=sb.getName() %>
<p class="card-text text danger">
<%=sb.getEmail() %>
<p class="card-text text danger">
<%=sb.getPhone() %>
</div>
</div>
<%} %>
</body>
</html>