<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="collegeportal.beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show College Details</title>
</head>
<body>
<%
College clg=(College)application.getAttribute("collegedetails");
%>
<div class="card" style="width: 18rem;">
  <img src="/collegeportal/images/card2.jpg" class="card-img-top" alt="..." style="width: 100px; height: 100px;">
  <div class="card-body">
    <p class="card-text"><%=clg.getName() %></p>
    <p class="card-text"><%=clg.getEmail() %></p>
    <p class="card-text"><%=clg.getAddress()%></p>
  </div>
</div>



</body>
</html>