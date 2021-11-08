<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="collegeportal.beans.*" %>
	<%@page import="collegeportal.student.*" %>
	<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="/collegeportal/css/style.css">
<link href="/collegeportal/css/style.css" type="text/css" rel="stylesheet">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" >
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="shortcut icon" href="/collegeportal/images/favicon.ico" type="image/x-icon">
<link rel="icon" href="/collegeportal/images/favicon.ico" type="image/x-icon">
<style>
li.items {
	display: inline;
	font-family: "Comic Sans Ms";
	font-size: 20px;
	margin-left: 20px;
}

ul.listitems {
	list-style-type: none;
}

a {
	text-decoration: none;
}
</style>
<script >
function changeImage()
{
	var tagref=document.getElementById("logo")
	tagref.src="/collegeportal/images/log1.png"
	tagref.style.width= "300"
	}
function rollImage()
{
	document.getElementById("logo").src="/collegeportal/images/spring.png"
	
	}
</script>
</head>
<body style="margin: 0px">

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
	<!-- <div  style="background-color: brown; width: 15%; height: 900px; float: left">
	
		<div  style=" width: 100%; height: 300px; float: left">
			<img alt="images" src="/collegeportal/images/college.jpg" style="width: 100%; height: 100%;">
		</div>
		</div> -->
	<div style="background-color: yellow; width: 100%; height: 900px; float: left">
<!-- <marquee direction="down" scrolldelay="350" onmouseover="this.stop()" onmouseout="this.start()"> -->
		<div class="container" style="background-color: white; width: 250px; height: 900px; float: left;">
		<ul style="list-style-type: number">
		<%
		AdminTask task=new AdminTask();
		ArrayList<News_bean> newslist=task.viewnews();
		for(News_bean news:newslist)
		{
			System.out.print(news.getSubject());
			/* Here we have to pass query string */
		%>
		<ol>
		<li style="float: left;"><a href="/collegeportal/jsp/displaynews.jsp?news_id=<%=news.getNewsid() %>"><%=news.getSubject() %></a></li>
		</ol>
		<%} %>
		
		</ul>
		<!-- </marquee> -->
		
		</div>
	</div>
	<div style="background-color: lightgreen; width: 100%; height: 40px; float: left">
		<%
		if(clg!=null)
		{%>
			
		
		<span>
		<%=clg.getName() %>
		<%=clg.getEmail() %>
		<%=clg.getPhone() %>
		</span>
		
		<%}%>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
	
</body>
</html>