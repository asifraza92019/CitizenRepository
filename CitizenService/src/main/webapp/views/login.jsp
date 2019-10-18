<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 <%@page isELIgnored="false" %>   
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script>
	$(function() {
		$('form[id="userRegForm"]').validate({
			rules : {
				mobile : 'required',
				password : 'required',
				
			},
			messages : {
				username : 'Please enter username',
				password : 'please enter password',
				
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
</script>



<style>
   .error
    {
      color : red;
     }

</style>



</head>
<body>

          <script type="text/javascript" src="//s7.addthis.com/js/300/addthis_widget.js#pubid=ra-5d99df9be75d1b7b">
</script>  
            <font color='green'>${success}</font>
         <form action ="/SBFormApp/citizen/submit" method = "POST"
             id="userRegForm">
          
                  <table align = "center">
                       
                         <tr>
                         <td>Enter your Id</td>
                         <td> <input type="text" name= "mobile" class="error"></td>
                         </tr>
                         
                         <tr>
                              <td> Password </td>
                              <td> <input type="password" name="password" class="error"></td>
                         </tr>
                         
                         <tr>
                         <td><input type="reset" value="Reset"></td>
                         <td><input type="submit" value="Login"> </td>
                         
                         </tr>
                  
                  </table>
               
                     
                      
         </form>
                     
                     <p style="text-align: center;">
                      <a href="/SBFormApp/citizen/register" style="text-align: center;color: red;">Register</a> <br>
                      <a href="/SBFormApp/citizen/forget" style="text-align: center;color:red;">Recover Password?</a>
                     
                     </p>
                       
</body>
</html>