<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*,java.sql.*" %>
    <%@page import="java.net.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>demo</title>
</head>
<body>
<h1>We are learning Jsp</h1>
<%

String name="Scott";
%>
<h2 style="color:red;text-align:cemtre;">
Hello <%=name %></h2>
<%
int age=20;
String email="scott@gmail.com";
%>

<p>
<%=age %>
<%=email %>
</p>
</body>
</html>