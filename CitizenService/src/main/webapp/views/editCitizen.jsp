<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

     
     
     <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
     
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
     
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js">
	 </script>
	 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  
  
 
     <style>
       .error {
	color: #FF0000
      }
      
      .container
      {
           font-size: 14px;
           margin : 10px;
           padding : 10px;
      }
      
       
     </style>

   <script>
   
   
   $(function() {
	    $( "#datepicker" ).datepicker({
	        changeMonth: true,
	        changeYear: true
	      });

	    $('form[id="userRegForm"]').validate({
			rules : {
				title : 'required',
				firstName : 'required',
				lastName : 'required',
				gender  : 'required',
				dateOfBirth : 'required',
				email : {
					required : true,
					email : true
				},
				mobile : 'required',
				alias  : 'required',
				permanentAddress : 'required',
				pincode  : 'required'
				
			},
			messages : {
				
				title : 'please select your title',
				firstName : 'please enter your first name',
				lastName : 'please enter your last name',
				gender  : 'select your gender',
				dateOfBirth: 'enter your date of birth',
				email : 'enter your email address',
				mobile: 'enter your mobile number',
				alias : 'enter your alias name',
				permanentAddress : 'enter your permanent address',
				pincode   : 'enter your pincode'
				
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
   
   
   $(document).ready(function(){
		$("#email").blur(function(){
			var val=$("#email").val();
			if(val!=''){
				$.ajax({
					url:'/SBFormApp/citizen/check',
					data:{'email':val},
					success:function(reTxt){
						$("#enameErr").html(reTxt);
					}
				});
				
			}
		});
	});

   
   
   $(document).ready(function(){
		$("#mobile").blur(function(){
			var val=$("#mobile").val();
			if(val!=''){
				$.ajax({
					url:'/SBFormApp/citizen/checkmobileno',
					data:{'mobile':val},
					success:function(reTxt){
						$("#cmobileErr").html(reTxt);
					}
				});
				
			}
		});
	});


   
   </script>

     <script>
     
             function cofirmStatus()
             {
            	   return confirm(" Do You Want To Upadate ??");
             }
     
     
     </script>
     
     
     

</head>
<body>

<script type="text/javascript" src="//s7.addthis.com/js/300/addthis_widget.js#pubid=ra-5d99df9be75d1b7b">
</script>

                 <font color='green'>${msg}</font>
         <h2 style="text-align: center"> Citizen Update Form-8 </h2>
         
         <hr/>
               
                   
         <div class="container">
             <form:form action="/SBFormApp/citizen/citizenUpdate" method="post" id="userRegForm" modelAttribute="citizen">
              
               <table align="center" width="600px">
                       
                       <tr>
                        <td>
                        <form:hidden path ="id"></form:hidden>
                        
                        </td>
                       
                       </tr>
                       
                    <tr>
                       <td>Title</td>
                       <td>
                         <form:select path ="title">
                          <form:option value=""> -select-</form:option>
                          <form:option value="MR">Mr.</form:option>
                          <form:option value="MRS">Mrs.</form:option>
                          <form:option value="MISS">Miss.</form:option>
                          <form:option value="MD">Md.</form:option>
                          <form:option value="SHRI">Shri.</form:option>
                          </form:select>
                       </td>
                    </tr>
                    
                    <tr>
                    <td>First Name</td>
                    <td>
                      <form:input path="firstName"></form:input>
                    </td>
                    </tr>
               
                    <tr>
                    <td>Last Name</td>
                    <td>
                      <form:input path="lastName"></form:input>
                    </td>
                    </tr>
                         
                         <tr>
                          <td>Gender</td>
                          <td>
                           <form:select path="gender">
                           <form:option value="male">Male</form:option>
                           <form:option value="female">female</form:option> 
                           </form:select>
                          </td>
                        </tr>
                        
                        
                        <tr>
                          <td>Date of Birth</td>
                          <td>
                            <form:input path="dateOfBirth" id="datepicker"></form:input>
                          </td>
                        </tr>
                        
                        
                        <tr>
                        <td>Email Address</td>
                        <td>
                          <form:input path="email" id = "email"></form:input>
                          <span id="enameErr"></span>
                        </td>
                       </tr>
                       
                       <tr>
                       <td>Mobile</td>
                       <td>
                          <form:input path="mobile" id="mobile"></form:input>
                           <span id="cmobileErr"></span>
                       </td>
                       
                       </tr>
                       
                       <tr>
                        <td>Alias</td>
                       <td>
                          <form:input path="alias"></form:input>
                       </td>
                       </tr>
                       
                       <tr>
                        <td>Permanent Address</td>
                        <td>
                        
                          <form:textarea path="permanentAddress"></form:textarea>
                        </td>
                       
                       </tr>
                       
                       <tr>
                          <td>Pincode</td>
                          <td>
                           <form:input path="pincode"></form:input>
                          </td>
                       
                       </tr>
                       <tr>
                       <td><input type="reset" value="Cancel"  /></td>
		         		<td><input type="submit" value="Update"  onclick = "return cofirmStatus()"/></td>                 
                       </tr>
                       
               </table>
             </form:form>
         
                        
         
          </div>
</body>

</html>