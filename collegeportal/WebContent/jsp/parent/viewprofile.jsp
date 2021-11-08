<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%>
<%@page import="collegeportal.parent.*,collegeportal.beans.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Profile</title>
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
<div class="card" style="width: 100px; ">
<img src="https://source.unsplash.com/100x100/?baby" class="card-img-top">
<div>
<p class="card-text text danger">
<%=p.getName() %>
<p class="card-text text danger">
<%=p.getPhone() %>
<p class="card-text text danger">
<%=p.getCity() %>
<%-- <p class="card-text text danger">
<%=p.getGender() %>
<p class="card-text text danger">
<%=p.getLanguage() %> --%>
</div>
</div>
<%@include file="/html/commonfooters.html"%>
<%} %>
</body>
</html>