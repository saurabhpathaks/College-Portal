<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="collegeportal.student.*,collegeportal.beans.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DISPLAY NEWS</title>
<%@include file="/html/commonheaders.html" %>
<%@include file="/html/commonfooters.html" %>
</head>
<body style="background-color: yellow;">

<div style="background-color: grey; width: 100%; height: 60px">
		<span
			style="font-size: 20px; margin-left:100px; font-family: Chiller; color: black; font-weight: bold; text-transform: capitalize; margin-left: 40%">
			College Portal Welcomes you 
			<%
			String slogan=application.getInitParameter("Tagline");
			String year=application.getInitParameter("Year");
			
			College clg=(College)application.getAttribute("collegedetails");
			
			%>
			<%=slogan %>
			<%=year %>
			</span>
		<div style="width: 100px; height: 100%; float: right">
			<img alt="images" id="logo" src="/collegeportal/images/logo.png"
				style="width: 100%; height: 100%;" onmouseover="changeImage()" onmouseout="rollImage()">
		</div>
	</div>
	<%@include file="/WEB-INF/headers/adminheader.html" %>
	
<%
String id=request.getParameter("news_id");
if(id!=null)
{
	int id_int=Integer.parseInt(id);
	AdminTask task=new AdminTask();
	News_bean news=task.viewnews(id_int);
%>
<div class="container bg-primary w-50" style="margin-top: 40px; height: 700px;">
<h2>One of the finest News Paper</h2>
<h1><%=news.getSubject() %></h1>
<p>  <%=news.getContent() %></p>

</div>
<%} %>

</body>
</html>