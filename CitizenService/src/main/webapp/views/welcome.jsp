<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


<script>
  $( function() {
    $( "#from" ).datepicker({
      changeMonth: true,
      changeYear: true
    });
  } );
  
  
  $( function() {
	    $( "#to" ).datepicker({
	      changeMonth: true,
	      changeYear: true
	    });
	  } );
  
  </script>  

</head>
<body>
          
            <h1 class="text-center">Welcome To Citizen Dashboard </h1>
            <div class="container">
         
        <div class="row">
         <div class="col-sm-4">
         
  <h2>Citizen Service</h2>
  
  <div class="panel-group" id="accordion">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">Payments</a>
        </h4>
      </div>
      <div id="collapse1" class="panel-collapse collapse in">
        <div class="panel-body">
        
        <a href="/SBFormApp/citizen/payment" class="btn btn-info btn-block" role="button">Contract Bill Payment</a>
        <a href="/SBFormApp/citizen/payment" class="btn btn-info btn-block" role="button">LOI Bill Payment</a>
        <a href="/SBFormApp/citizen/payment" class="btn btn-info btn-block" role="button">Rent Bill Payment</a>
        
        </div>
      </div>
    </div>
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">View Citizen</a>
        </h4>
      </div>
      <div id="collapse2" class="panel-collapse collapse">
        <div class="panel-body">
        
         <a href="/SBFormApp/citizen/viewcitizen" class="btn btn-info btn-block" role="button">View </a>
         <a href="/SBFormApp/citizen/viewCitizentbl" class="btn btn-info btn-block" role="button">View In Paging Form </a>
       
        
        </div>
      </div>
    </div>
    
    
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">Property Tax</a>
        </h4>
      </div>
      <div id="collapse2" class="panel-collapse collapse">
        <div class="panel-body">
        
         <a href="#" class="btn btn-info btn-block" role="button">View Property Status</a>
        <a href="#" class="btn btn-info btn-block" role="button">Extract of Property</a>
        <a href="#" class="btn btn-info btn-block" role="button">Tax Pay  for Property</a>
        
        </div>
      </div>
    </div>
    
    
    
    
    
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">RTI</a>
        </h4>
      </div>
      <div id="collapse3" class="panel-collapse collapse">
        <div class="panel-body">
        
        <a href="#" class="btn btn-info btn-block" role="button">RTI Entry</a>
        <a href="#" class="btn btn-info btn-block" role="button">First Appeal Entry</a>
        <a href="#" class="btn btn-info btn-block" role="button">Transfer Service Through other payment mode</a>
        
        
        </div>
      </div>
    
  </div> 
</div>
    
         
         
          </div>
          
          
    <div class="col-sm-8">
      
     
  <form class="form-horizontal" action="/SBFormApp/citizen/payment" method="post">
  <h2>Advertisment bill payment</h2>
    <div class="form-group">
      <label class="control-label col-sm-2" for="contratno">Contact Number:</label>
      <div class="col-sm-10">
        <input type="email" class="form-control" id="contratno" placeholder="Enter contract no" name="contratno">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="applicationno">Application Number:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="applicationno" placeholder="Enter application no" name="applicationno">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="applicantname">Applicant Name:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="applicantname" placeholder="Enter applicant name" name="applicantname">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="applicantname">From due:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="from"  name="from">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="to">To due:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="to"  name="to">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="amount">To due:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="amount"  name="amount">
      </div>
    </div>
   
   <div class="form-group">
   
    <label class="radio-inline">
      <input type="radio" name="optradio">Online
    </label>
    <label class="radio-inline">
      <input type="radio" name="optradio">Offline
    </label>
   
   </div>
   
     <input type="submit" value="pay" >
     <input type="reset" value="replane">
  </form>
                       
    </div>
  </div>
</div>
           
</body>
</html>