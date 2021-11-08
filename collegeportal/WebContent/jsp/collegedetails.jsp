<!DOCTYPE html>
<html lang="en">
<head>
  <title>College Details</title>
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

<div class="container">
  <h2>Form</h2>
  <form action="/collegeportal/College_details" method="post" onsubmit="return main()">
    
    <div class="form-group">
      <label for="id"> Id:</label>
    <input type="text" class="form-control"  id="id"  placeholder="Enter your Id Here....">
    </div>
   <div class="form-group">
      <label for="name">Name:</label>
      <input type="text"  class="form-control" id="name" placeholder="Enter Your Name" name="Lame">
    </div>
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email"  class="form-control" id="email" placeholder="Enter email" name="email">
    </div>
    <div class="form-group">
      <label for="phone">Phone:</label>
      <input type="number"  class="form-control" id="phone" placeholder="Enter Your Phone Number" name="phone">
    </div>
    <div>
    <label for="address">Address:</label>
    <textarea class="form-control" id="address" name="address" placeholder="Enter Your Address" style="height:100px"></textarea>
       </div>
    <button type="submit"  class="btn btn-primary">Submit</button>
  </form>
</div>

</body>
</html>
