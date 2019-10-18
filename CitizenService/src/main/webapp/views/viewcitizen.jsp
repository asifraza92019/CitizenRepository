<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
 <script>
   function deleteConfirm()
   {
	      return confirm("Are you sure ? your data will no longer available with us");
   }
 
 
 </script>


</head>
<body>
 
  <div class="container">
  
        <h2 class= "text-center"> All Registered Citizen Detail </h2>
        <br/>
        
        
   <table class="table table-dark table-striped">
 <thead>
    <tr>
       <th>Sno</th>
       <th>Title</th>
       <th>FirstName</th>
       <th>LastName</th>
       <th>gender</th>
       <th>DOB</th>
       <th>Email</th> 
       <th>Mobile</th>
       <th>Permanent Address</th>
       <th>ZipCode</th>
       <th>Action</th> 
   </tr>
   </thead>
    <tbody>
        <c:forEach items="${citizenList}" var="citizen" varStatus="index" >
        
           <tr>
           <td> ${index.count}</td>
           <td>${citizen.title }</td>
           <td>${citizen.firstName }</td> 
           <td>${citizen.firstName }</td>
           <td>${citizen.gender }</td>
           <td>${citizen.dateOfBirth }</td>
           <td>${citizen.email }</td>
           <td>${citizen.mobile }</td>
           <td>${citizen.permanentAddress }</td>
           <td>${citizen.pincode }</td>
           <td>
            
           <a href = "/SBFormApp/citizen/delete?id=${citizen.id}" onclick = "return deleteConfirm()">DELETE</a>&nbsp;&nbsp;|&nbsp;&nbsp;
           <a href ="/SBFormApp/citizen/editCitizen?id=${citizen.id}" >UPDATE</a>
           
           
           </td>
           
           </tr>
        
        </c:forEach>

   </tbody>
</table> 
 </div> 
        
        
        
</body>
</html>