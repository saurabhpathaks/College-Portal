<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bootstrap Validation</title>
<%@include file="/html/commonheaders.html" %>
</head>
<body>
<div class="container-fluid" style="width: 400px; height:300px; margin-top: 90px; background-color: yellow;">
<form class="needs-validation" novalidate="novalidate">
  <div class="form-group">
    <label for="exampleInputEmail1">Name</label>
    <input type="email" class="form-control" id="txtname" name="txtname" >
    <!-- <div class="valid-feedback">
    Id Verified 
    </div>
   <div class="invalid-feedback">Name Required</div> -->
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control" id="txtemail" name="txtemail" required="required" >
    <div class="valid-feedback">
    Id Verified 
    </div>
   <div class="invalid-feedback">Email Required</div>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="txtpass" name="txtpass" required="required">
    <div class="valid-feedback">Password Verified</div>
    <div class="invalid-feedback">Password Required</div>
  </div>
  <div class="container-fluid " style="width: 200px; ">
  <button type="submit" class="btn btn-primary">Submit</button></div>
</form>
</div>
<%@include file="/html/commonfooters.html" %>
<script type="text/javascript" src="/collegeportal/js/bootstrap.js"></script>


</body>
</html>