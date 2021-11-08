<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="collegeportal.beans.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload Pic</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" >
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css">
<link rel="shortcut icon" href="/collegeportal/images/favicon.ico" type="image/x-icon">
<link rel="icon" href="/collegeportal/images/favicon.ico" type="image/x-icon">
</head>
<body>
<%@include file="/WEB-INF/headers/parentheader.html" %>

<div class="container" style="background-color: red; width: 500px; height: 600px; margin-top: 20px;">
<%
HttpSession hs=request.getSession(false);
System.out.println(hs.getId());
String uid=(String)hs.getAttribute("session_userid");
if(uid==null||hs.isNew())
{
	request.setAttribute("msg", Message.INVALID_ACCESS);
	RequestDispatcher dispatcher=request.getRequestDispatcher("/jsp/login.jsp");
	dispatcher.forward(request, response);
%>
<%}
else{
	
%>



<span class="text-primary">Hello<%=uid %></span>
<form action="/collegeportal/Upload" method="post" enctype="multipart/form-data">
<input type="file" name="uploadctrl" multiple>
<button type="submit">Upload Pic</button>
</form>

</div>



<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
 <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
<%} %>
</body>
</html>
