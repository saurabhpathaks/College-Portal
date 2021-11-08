<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Creation</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div style="background-color: grey; width: 400px; height: 100%; margin-left: 400px;">
<form action="/collegeportal/Accountcreation" class="was-validated" method="post">
  <div class="form-group">
    <label for="uname">Student Id</label>
    <input type="text" class="form-control" id="studentid" placeholder="Enter username" name="stdid" required>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password" required>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>
  <div class="form-group">
    <label for="name">Name:</label>
    <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name" required>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>
   <div class="form-group">
    <label for="email">Email:</label>
    <input type="text" class="form-control" id="emailid" placeholder="Enter Email" name="email" required>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>
   <div class="form-group">
    <label for="name">Phone:</label>
    <input type="text" class="form-control" id="phoneno" placeholder="Enter Phone" name="phone" required>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>
</body>
</html>