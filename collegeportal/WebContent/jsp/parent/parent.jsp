<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="collegeportal.beans.*" %>
    <%@page import="collegeportal.parent.*,java.io.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Parent Login</title>
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
	ParentTask task=new ParentTask();
	Parent p=task.viewProfile(uid);
	String imgname=p.getPicname();
	String path=request.getContextPath();
	System.out.println("path is" +path);
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	System.out.println("basepath is"+basePath);

	String imagepath="";
	if(imgname==null)
	{
	imagepath="/collegeportal/images/default.jpg";
	
	}
	else{
	
	imagepath=basePath+uid+File.separator+imgname;
	System.out.println("image path is" +imagepath);
	}
	
%>



<span class="text-primary" style="font-size: 20px;"><i class="fas fa-user-tie fa-2x"></i>Hello<%=uid %></span>
<div class="container w-50">
<img alt="Profile Pic" src="<%=imagepath%>" class="card img-fluid" >


</div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
 <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
<% } %>
</body>
</html>
