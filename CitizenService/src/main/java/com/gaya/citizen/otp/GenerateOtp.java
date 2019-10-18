package com.gaya.citizen.otp;


/**
 * @author Asif
 *  this class will generate random number
 */
public class GenerateOtp {

	   /**
	    * method for generating random number
	    * @return
	    */
	       public String generateOtp()
	       {
	    	   java.util.Random r=new java.util.Random();
	            int otp = r.nextInt(1000000); // no. of zeros depends on the OTP digit
	             
	             return  Integer.toString(otp);
	      
	       }
}
