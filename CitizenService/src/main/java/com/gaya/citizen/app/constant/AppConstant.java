package com.gaya.citizen.app.constant;

/**
 *   this interface will store all constant value
 */

public interface AppConstant {
            

	     /**
	      *   this is variable is declare to show she view of cancel  
	      */
	       public static final String CANCEL_FORM= "cancel";
	       
	       /**
	        *    when you have forgotten the password it will display a page for
	        *    recovering your password
	        */
	       
	       public static final String FORGET_FORM= "forget";
	       
	       /**
	        *  this page will display the home page
	        */
	       public static final String HOME_PAGE= "home";
	       
	       /**
	        * this page is for login of admin
	        */
	       public static final String  LOGIN_FORM= "login";
	       
	       
	       /**
	        *    this is for making the payment through payment gateway by using rupeepay 
	        *    
	        */
	       public static final String PAYMENT_FORM= "payment";
	       
	       
	       /**
	        *  Registration of citizen 
	        */
	       public static final String REGISTRATION_FORM= "registration";
	       
	       
	       /**
	        *  after successfully registering this page will displayed
	        */
	       public static final String SUCCESS_FORM = "success";
	       
	       
	       /**
	        *  This page will verify your otp that you will get on email
	        */
	       public static final String VERIFY_FORM= "verify";
	       
	       /**
	        * This is warn welcome page for citizen
	        */
	       public static final String  WELCOME_PAGE = "welcome";
	       
	       /**
	        * for successfull payment 
	        */
	       
	   	   public static final String SUCCESS_URL = "pay/success";
	   	
	   	   /**
	   	    * for canceling the payment on payment Gateway
	   	    */
	   	   
		   public static final String CANCEL_URL = "pay/cancel";
	    
		   
		      /**
		       * To see all the Citizen in the table format
		       */
	       public static final String VIEW_CITIZEN= "viewcitizen";
	       
	       
	       /**
	        *  To Edit the citizen detail or simply you can can say that,
	        *  this is for updatin the existing citizen detail
	        */
	       public static final String EDIT_CITIZEN= "editCitizen";
	       
	       /**
	        *  After Updating you will get tracking number to you mail 
	        *  and you you can check you status of the registration form after updating
	        */
	       public static final String TRACT_UPDATE= "track";
	       
	       /**
	        *  After updating your form will migrate to this page
	        */
	       
	       public static final String CITIZEN_UPDATED_PAGE= "citizenUpdate"; 
	       
	       /**
	        *   Here we have seprately implement to see citizen 
	        *   in the form of page not all but, you will chunk of data that you 
	        *   have already asigned
	        */
	       
	       public static final String    SERVER_SIDE_PAGINATION_VIEW ="serverSidePaginationView";
	       
	       /**
	        * this will show you after deletion of citizen by id 
	        * here we have perform hard deletion
	        */
	       public static final String 	DELETE_PAGE= "delete";
	       
}
