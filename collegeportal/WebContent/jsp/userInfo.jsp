<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Info</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <style>
  .container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
  
  
  
  
}
  
  </style>
  
</head>
<body>
<form action="/collegeportal/Userdetail" method="post" onsubmit="return main()">
<div class="container">
  <h2>User Info</h2>
  


<div class="form-group">
      <label for="id"> Id:</label>
    <input type="text" class="form-control"  name="id"  placeholder="Enter your Id Here....">
    </div>
    
    <div class="form-group">
    <label for="Password">Password</label>
    <input type="password" class="form-control" name="password" placeholder="Password">
  </div>
  
  <div class="form-group">
    <label for="Select">Type</label>
    <select class="form-control" name="type">
      <option>Student</option>
      <option>Admin</option>
      <option>Faculty</option>
     
    </select>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
  </div>
  </form>
</body>
</html>