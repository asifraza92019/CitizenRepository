<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    
    <script type="text/javascript" src="//s7.addthis.com/js/300/addthis_widget.js#pubid=ra-5d99df9be75d1b7b">
</script>

   <style>
           
   </style>
      ${msg}
      
      <br>
      
            <form action ="/SBFormApp/citizen/forget" method="post">   
                <table  align="center">
                     <tr>
                       <td>Email</td>
                       <td>
                           <input type="text" name="email">
                       </td>
                     </tr> 
                     <tr>
                     <td></td>
                      <td>
                        <input type="submit" value="Submit">
                      </td>
                     </tr>
                </table>   
            </form>
      
           
            <form action ="/SBFormApp/citizen/verify" method="post">   
                <table align="center">
                     <tr>
                      
                       <td>Enter OTP</td>  
                       <td>
                           <input type="text" name="otp">
                       </td>
                     </tr> 
                     <tr>
                     <td></td>
                      <td>
                        <input type="submit" value="Verify">
                      </td>
                     </tr>
                </table>   
            </form>
      
          <p style= "text-align: center; color: green;">or</p>
            
            <form action ="/SBFormApp/citizen/forget" method="post">   
                <table align="center">
                     <tr>
                       <td>Phone</td>
                       <td>
                           <input type="text" name="phone">
                       </td>
                     </tr> 
                     <tr>
                      <td>
                        <input type="submit" value="Submit">
                      </td>
                     </tr>
                </table>   
            </form>
      
       
              
            <form action ="/SBFormApp/citizen/verify" method="post">   
                <table align="center">
                     <tr>
                        <td>Enter OTP</td>
                       <td>
                           <input type="text" name="otp">
                       </td>
                     </tr> 
                     <tr>
                     <td>
                     
                     </td>
                      <td>
                        <input type="submit" value="Verify">
                      </td>
                     </tr>
                </table>   
            </form>
         
</body>
</html>