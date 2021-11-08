<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add News</title>
<%@include file="/html/commonheaders.html" %>
<link href="/collegeportal/css/style.css" type="text/css" rel="stylesheet">
</head>
<body>
<%@include file="/WEB-INF/headers/adminheader.html" %>
<%@include file="/html/commonfooters.html" %>
<div class="container">
  <form action="/collegeportal/Addnews" method="post">
    <label for="subject">Subject</label>
    <input type="text" id="txtsubject" name="subject" placeholder="Write Your Subject">


    
    <label for="subject">Content</label>
    <textarea id="txtcontent" name="content" placeholder="Write something.." style="height:200px"></textarea>
<label for="subject">Date</label>
    <input type="text" id="txtdate" name="date" placeholder="DD/MM/YYYY">
    <input type="submit" value="Submit">
  </form>
</div>

</body>
</html>