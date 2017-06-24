<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>


  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">


  <form class="form-horizontal" method="get" action="/addFeedback" >
    <div class="form-group">
      <label class="control-label col-sm-2">Name:</label>
      <div class="col-sm-4">
        <input type="text" class="form-control"  placeholder="Enter Name" >
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" >Email:</label>
      <div class="col-sm-4">          
        <input type="email" class="form-control" placeholder= "Enter Email" >
      </div>
    </div>
    
     <div class="form-group">
      <label class="control-label col-sm-2" >Message:</label>
      <div class="col-sm-4">          
        <input type="text" class="form-control" placeholder= "Enter Message" >
      </div>
    </div>
    
     <div class="form-group">
      <label class="control-label col-sm-2" >Regarding:</label>
      <div class="col-sm-4">          
        <input type="number" class="form-control" placeholder= "Enter Regarding" >
        
      </div>
    </div>	
     <div class="form-group">
      <label class="control-label col-sm-2" >Code:</label>
      <div class="col-sm-4">          
        <input type="Text" class="form-control" placeholder= "Enter Code" >
      </div>
    </div>
    
    
    
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
    </div>
  
  </form>
</div>

</body>
</html>
