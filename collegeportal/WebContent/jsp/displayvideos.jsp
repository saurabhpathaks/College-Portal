<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
	
	<%@page import="collegeportal.beans.*" %>
	<%@page import="collegeportal.parent.*,java.io.*" %>
	
<%-- 	<%@page import="java.sql.*" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="/WEB-INF/headers/parentheader.html" %>  
<META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE">
		<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
		<META HTTP-EQUIV="EXPIRES" CONTENT="0">
<title>Display Videos</title>
<%-- <% 
response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);%> --%>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" >
    
    
<link href="/collegeportal/css/style.css" type="text/css" rel="stylesheet">
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

</head>
<body style="margin: 0px">
<div>
<form action="/collegeportal/VideoPost" method="post">
  <div class="form-group container-fluid" style="width: 300px">
    <label for="exampleFormControlFile1">Share Ur Link here</label>
    <input type="text" name="videoname" placeholder="Enter Your Video Name">
    <input type="text" class="form-control-file" id="exampleFormControlFile1" name="links" placeholder="Share Ur Link Here">
    
    
    <button type="submit" class="btn btn-primary">Share</button>
  </div>
</form></div>

<%

HttpSession hs=request.getSession(false);
System.out.println(hs.getId()); 

String uid=	(String)hs.getAttribute("session_userid");
if(uid==null||hs.isNew())//return true if session is new
{
request.setAttribute("msg", Message.INVALID_ACCESS);
RequestDispatcher dispatcher=request.getRequestDispatcher("/jsp/login.jsp");
dispatcher.forward(request, response);

%>
<%}

else{
	ParentTask task=new ParentTask();

	Videos video=task.viewVideos(1);
	
String videoname=video.getVideoname();
String linkpath=video.getVideolink();
String path=request.getContextPath();
System.out.println("path is "+path);
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
System.out.print("basepath is "+basePath);
String videopath="";
if(videoname==null)
{
	videopath="/collegeportal/images/default.jpg";

}
else{
	
	videopath=basePath+uid+File.separator+videoname;
	System.out.print("imagepath is "+videopath);
}
 
%> 
<div class="conatiner-fluid bg-warning">

</div>
<div class="container w-50">

<span class="text-primary"> <%=uid%> </span>

<%

String watchlink=linkpath;
String embedlink=watchlink.replace("watch", "embed");
System.out.println(embedlink);
 embedlink=embedlink.replace("?v=", "/");
 System.out.println(embedlink);
%>
<iframe width="600" height="200" src="<%=embedlink%>" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
<br>
<a href="<%=watchlink%>"><%=linkpath%></a>
</div>

<%
/* String data=request.getParameter("ms");
System.out.println(data);
} */ 
}
%>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
</body>
</html>
