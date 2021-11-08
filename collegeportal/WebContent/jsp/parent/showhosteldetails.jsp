<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="collegeportal.beans.*" %>
    <%@page import="collegeportal.parent.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SHD</title>
</head>
<body>
<%
String cityid=request.getParameter("cid");
//String strsql="select * from hostel where cityid=?"; 
System.out.println(cityid);
ParentTask task=new ParentTask();
ArrayList<Hostel> hostellist=task.viewHostel(cityid);

%>
<h1>Hostel Details are AS Follows</h1>
<table>
<%
for(Hostel hostel:hostellist){
%>	
<tr><th><%=hostel.getName() %></th><th>
<%=hostel.getAddress() %></th></tr>

<%} %>

</table>

</body>
</html>