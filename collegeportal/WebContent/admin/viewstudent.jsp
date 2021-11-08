<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="collegeportal.student.*,java.util.*,collegeportal.beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Student</title>
<%@include file="/html/commonheaders.html" %>
</head>
<body>
<%@include file="/admin/commonsession.jsp" %>
<%@include file="/WEB-INF/headers/adminheader.html" %>
<% 
AdminTask task=new AdminTask();
ArrayList<Student_bean>studentlist=task.viewstudent();
%>
<form action="/collegeportal/DeleteStudent" method="post">
<table class="table table-striped table-dark">
  <thead>
    <tr>
      <th scope="col">Select</th>
      <th scope="col">Name</th>
      <th scope="col">E-Mail</th>
      <th scope="col">Phone</th>
    </tr>
  </thead>
  <%
for(Student_bean sb:studentlist)
{
%>
  <tbody>
    <tr>
      <th scope="row"><input type="checkbox" name="chk" value="<%=sb.getStudentid()%>"></th>
      <td><%=sb.getName() %></td>
      <td><%=sb.getEmail() %></td>
      <td><%=sb.getPhone() %></td>
    </tr>
    
    <%} %>
  </tbody>
</table>

<div><button type="submit">Delete</button></div>
</form>
</body>
</html>