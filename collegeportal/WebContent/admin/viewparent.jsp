<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="collegeportal.student.*,java.util.*,collegeportal.beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Parents</title>
<%@include file="/html/commonheaders.html" %>
</head>
<body>
<%@include file="/admin/commonsession.jsp" %>
<%@include file="/WEB-INF/headers/adminheader.html" %>
<%
AdminTask task=new AdminTask();
ArrayList<Parent>parentlist=task.viewParents();
%>
<form action="/collegeportal/DeleteParents" method="post">
<table class="table table-striped table-dark">
  <thead>
    <tr>
      <th scope="col">Select</th>
      <th scope="col">Name</th>
      <th scope="col">City</th>
      <th scope="col">Phone</th>
    </tr>
  </thead><%
for(Parent p:parentlist)
{

%>
<tr><th><input type="checkbox" name="chkdelete" value="<%=p.getId()%>">
</th>
<th><%=p.getName()%></th>
<th><%=p.getCity() %></th>
<th><%=p.getPhone() %>
</th></tr>

<%} %>

</table>
<button type="submit"  style="margin-left: 600px; margin-top: 20px;">Delete</button>
</form>
<%@include file="/html/commonfooters.html" %>
</body>
</html>