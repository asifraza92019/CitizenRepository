package com.gaya.citizen.controller;

import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gaya.citizen.app.constant.AppConstant;
import com.gaya.citizen.bean.Citizen;
import com.gaya.citizen.bean.OtpBean;
import com.gaya.citizen.otp.GenerateOtp;
import com.gaya.citizen.paypal.order.Order;
import com.gaya.citizen.paypal.service.PaypalService;
import com.gaya.citizen.repositories.CitizenRepository;
import com.gaya.citizen.service.CitizenService;
import com.gaya.citizen.service.OtpService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

/**
 *  Citizen Controller or main controller in our application to controll the flow of page
 *  
 */



@Controller
@RequestMapping("/citizen")
public class CitizenController {
	
	  /**
	   * @Param eamilSender 
	   *  this param is specified for getting the object of JavaMailSend 
	   */
	
	    @Autowired
	    public JavaMailSender emailSender;
	
	    
	    /**
	     * this is for payment service 
	     *   This class will communicate will paypal
	     */
	    
	    @Autowired
		PaypalService service;
	  
	      /**
	       *  Citizen Service  
	       */
	    
	       @Autowired
	     private CitizenService citizenService;
	       
	       /**
	        *   Here we have directly injected citizenRepositry but you can go with 
	        *   Service layer too.
	        *   This is only for testing of serverSidePagging checking
	        *   Not recommend in realtime
	        */
	       @Autowired
	       private CitizenRepository citizenRepository;
	    
	       /**
	        *  for Registring the citizen 
	        *  this method will display a registration form for citizen
	        */
	       
	       
	       
	       @Autowired
	       private OtpService otpService;
	       
	       @RequestMapping("/register")
	  public String showRegistrationForm(Model model)
	  {
		   Citizen citizenObj = new Citizen();
		   model.addAttribute("citizen", citizenObj);
		    return  AppConstant.REGISTRATION_FORM;
		    		
	  
	  }
	        /**
	         * 
	         * @param citizen
	         * @param model
	         * @return
	         * 
	         * After registering the citizen again it will display the citizen registration page 
	         * you can also redirect to other view too
	         * 
	         */
	       
	
	         @RequestMapping(value="/citizenRegister", method = RequestMethod.POST)
	       public String citizenRegister(@ModelAttribute("citizen") Citizen citizen, Model model)
	       {
	    	      System.out.println(citizen);
	    	      
	    	     Citizen ct= citizenService.saveCitizen(citizen);
	    	      
	    	      System.out.println(ct);
	    	      model.addAttribute("msg", "you are succesfully registered");
	    	        
	    	   //   List<Citizen>  citizentList=   citizenService.getAllCitizenList();
	    	      
	    	     // System.out.println(citizentList.get(0));
	              Citizen c = new Citizen();
	              model.addAttribute("ct", c);
	            //  model.addAttribute("citizen" ,citizentList);
	    	   return  AppConstant.REGISTRATION_FORM;
	       }
	         
	         
	         /**
	          * 
	          * @param request
	          * @param model
	          * @return
	          * 
	          * for login of admin 
	          * which is hard coded
	          */
	         
	                   
	                   @RequestMapping(value="/login")
	         public String  loginForm(ServletRequest request, Model model)
	         {
	                	    
	        	           return AppConstant.LOGIN_FORM;
	         }
	             
	                   
	                   @RequestMapping(value="/submit" , method = RequestMethod.POST)
	      	         public String  login(ServletRequest request, Model model)
	      	         {
	      	                	   String mobile= request.getParameter("mobile");
	      	                	   
	      	                	//   String encoded = pwdEncoder.encode(request.getParameter("password"));
	      	                	   String password = request.getParameter("password"); 
	      	                	   
	      	                	   System.out.println(mobile  +  " "  + password);
	      	                	     
	      	                	    Citizen ct = new Citizen();
	      	                	    ct.setMobile(mobile);
	      	                	       
	      	                	    model.addAttribute("success", ct);
	      	                	    if(mobile.equals("9262869002") &&  password.equals("asifraza"))
	      	                	    {
	      	                	    	return AppConstant.WELCOME_PAGE;
	      	                	    }
	      	                	    
	      	                	    
	      	        	           return "redirect:"+AppConstant.REGISTRATION_FORM;
	      	         }
	      	          
	                   /**
	                    * 
	                    * @param email
	                    * @return
	                    * this is will ajax call while registration the citizen 
	                    * wheather citizen email already exist or not 
	                    */
	
	                   @RequestMapping("/check")
	               	public @ResponseBody String executeAjax(
	               			@RequestParam String email) 
	               	{
	               		String message="";
	               		//data base logic 
	               		System.out.println(email);
	               		
	               		  List<Citizen> citizenList = citizenService.findByEmail(email);
	               		  
	               		  
	               		  
	               		  if(!citizenList.isEmpty())
	               		  {
	               			  Citizen citizen = citizenList.get(0);
	               			  System.out.println(citizen);
	               			  String mail = citizen.getEmail();
	               			  System.out.println(mail);
	               			  if(email!=null && email.equalsIgnoreCase(mail))
	               			  {
	               				message="email already exit";
		               			return message;
	               			  }
	               			  
	               			  
	               		  }
	               		  
	               		return  message;
	               		
	               	}
	
	                /**
	                 * 
	                 * @param mobile
	                 * @return
	                 * 
	                 * ajax call for citizen mobile number exists or not 
	                 */
	                   
	               	
	                   @RequestMapping("/checkmobileno")
	               	public @ResponseBody String executeAjaxForMobile(
	               			@RequestParam String mobile) 
	               	{
	               		String message="";
	               		//data base logic 
	               		System.out.println(mobile);
	               		
	               		  List<Citizen> citizenList = citizenService.findByMobile(mobile);
	               		  if(!citizenList.isEmpty())
	               		  {
	               			   Citizen citizen = citizenList.get(0);
	               			   System.out.println(citizen);
	               			   String mobileno = citizen.getMobile();
	               			   System.out.println(mobileno);
	               			   if(mobile!=null && mobile.equals(mobileno))
	               			   {
	               				    message = "already exit";
	               				    return message;
	               			   }
	               		  }
	               		  
	               		  return message;
	               		  
	               		
	               	}
	
	                   
	
	                   /**
	                    *   if you have forgotten the password got to recovery page 
	                    *   select option how you want to recover 
	                    *   
	                    * @return
	                    */
	                   
	                   
	                    @RequestMapping("/forget")
	                   public String getForgetPage()
	                   {
	                	   return  AppConstant.FORGET_FORM;
	                   }
	                   
	                    
	                    /**
	                     * for the otp generation and it will send to your mobile number if 
	                       or to you email address accord to your choice 
	                     * @param request
	                     * @param model
	                     * @return
	                     */
	                   
	                   @RequestMapping(value= "/forget", method = RequestMethod.POST)
	                   public String forgetEmail(ServletRequest request, Model model, @RequestBody String mail)
	                   {
	                	   System.out.println(mail);
		
		                   String email = request.getParameter("email");  
		                   System.out.println(email);
		    GenerateOtp myotp = new GenerateOtp();
		     String otp=   myotp.generateOtp();
		  String subject = "Sending Email To Demostrate email example"; 
		  String text="Hi from my java application" ; 
		  SimpleMailMessage msg = new SimpleMailMessage();
		  msg.setFrom("asifraza4101995@gmail.com");
		  msg.setTo(email);
		  msg.setSubject("Verify your account"); 
		  msg.setText("Namaskar!! "+ otp  + " is One Time Password for verification");
		  
		  emailSender.send(msg);
		  
		  
		            OtpBean otpBean = new OtpBean();
		            otpBean.setOtp(otp);
		            
		       OtpBean ob=     otpService.saveOtp(otpBean);
	                	  System.out.println(ob); 
	                	   
		
		/*
		 * MySMS sms = new MySMS(); String msg= sms.sendSms(); System.out.println(msg);
		 */
		 	                	   
		              return  AppConstant.FORGET_FORM;
	                   }
	                   
	                   
	                   
	                   /**
	                    * verify your otp
	                    * @param model
	                    * @param request
	                    * @return
	                    */
	                   @RequestMapping(value="/verify" , method = RequestMethod.POST)
	                   public String verifyPassword(Model model, ServletRequest request)
	                   {
	                	    
	                	   String   otp = request.getParameter("otp");
	                	   System.out.println(otp);
	                	   
	                	List<OtpBean>  listOfOtp=  otpService.getAllOtp();
	                	
	                	   int size=   listOfOtp.size();
	                	    String otpverififiable = listOfOtp.get(size-1).getOtp(); 
	                	         if(otp!=null && otp.equals(otpverififiable))
	                	         {
	                	        	 return AppConstant.VERIFY_FORM;
	                	         }
	                	
	                	         return AppConstant.FORGET_FORM;
	                   }
	                   
	                   
	                   /**
	                    *  It will show the payment form
	                    */
                        @RequestMapping(value="/payment", method= RequestMethod.POST)
	                   public String paymentForm()
	                   {
	                	   return  AppConstant.HOME_PAGE;
	                   }
                        
                        
                        /**
                         * After payment it will show you the  Welcome page
                         * your payment succussfully done
                         * @return
                         */
	                   
                        @RequestMapping(value="/payment", method= RequestMethod.GET)
 	                   public String paymentFormGet()
 	                   {
 	                	   return  AppConstant.WELCOME_PAGE;
 	                   }
                        

                        /**
                         * home page of the application
                         * @return
                         */

                    	@GetMapping("/")
                    	public String home() {
                    		return  AppConstant.HOME_PAGE;
                    	}

                    	/**
                    	 * form for the payment 
                    	 * @param order
                    	 * @return
                    	 */
                    	@PostMapping("/pay")
                    	public String payment(@ModelAttribute("order") Order order) {
                    		try {
                    			Payment payment = service.createPayment(order.getPrice(), order.getCurrency(), order.getMethod(),
                    					order.getIntent(), order.getDescription(), "http://localhost:9090/SBFormApp/citizen/" + AppConstant.CANCEL_URL,
                    					"http://localhost:9090/SBFormApp/citizen/" +AppConstant.SUCCESS_URL);
                    			for(Links link:payment.getLinks()) {
                    				if(link.getRel().equals("approval_url")) {
                    					return "redirect:"+link.getHref();
                    				}
                    			}
                    			
                    		} catch (PayPalRESTException e) {
                    		
                    			e.printStackTrace();
                    		}
                    		return "redirect:/";
                    	}
                    	
                    	/** 
                    	 * if you cancel the payment at the end 
                    	 * this page will be displayed
                    	 * 
                    	 */
                    	 @GetMapping(value = AppConstant.CANCEL_URL)
                    	    public String cancelPay() {
                    	        return "cancel";
                    	    }

                    	 /**
                    	  * after successfully payment this page will display
                    	  * @param paymentId
                    	  * @param payerId
                    	  * @return
                    	  */
                    	    @GetMapping(value = AppConstant.SUCCESS_URL)
                    	    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
                    	        try {
                    	            Payment payment = service.executePayment(paymentId, payerId);
                    	            System.out.println(payment.toJSON());
                    	            if (payment.getState().equals("approved")) {
                    	                return "success";
                    	            }
                    	        } catch (PayPalRESTException e) {
                    	         System.out.println(e.getMessage());
                    	        }
                    	        return "redirect:/";
                    	    }
               
                    	    /**
                    	     *  This will open a from to edit the citizen detail
                    	     * @param model
                    	     * @param id
                    	     * @return
                    	     */
                    	    
                    	    @RequestMapping(value="/editCitizen" , method= RequestMethod.GET)
                    	    public String editCitizenForm(Model model, @RequestParam("id") Integer id)
                    	    {
                    	    	
                    	       Citizen citizenDb=  citizenService.getCitizenById(id);
                    	           citizenDb.setId(id);
                    	    	   model.addAttribute("citizen", citizenDb);
                    	    	   System.out.println(id);
                    	    	return   AppConstant.EDIT_CITIZEN;
                    	    }
                    	    
                    	    
                    	    /**
                    	     * after submitting the updated form
                    	     * this page will display based on the condition 
                    	     * wheather successfully updated or not 
                    	     */
                    	    @RequestMapping(value="/citizenUpdate", method = RequestMethod.POST)
                    	   
                    	    public String citizenUpdateForm(Model model, @ModelAttribute ("citizen") Citizen citizen
                    	    		
                    	    		)
                    	    {
                    	    	//System.out.println(id);
                    	    	
                    	    	 Integer id= citizen.getId();
                    	    	 System.out.println(id);
                    	    	
                    	    Citizen  citizan=	citizenService.saveCitizen(citizen);
                    	    	if(citizan!=null)
                    	    	{
                    	    		  System.out.println(citizan);
                    	    		 model.addAttribute("msg", "successfull update track your status");
                    	    		 return AppConstant.CITIZEN_UPDATED_PAGE; 
                    	    	}
                                 return AppConstant.EDIT_CITIZEN;                   	    	   
                    	    }
                    	    
                        /**
                         * For view or the citizen detail
                         * @param model
                         * @return
                         */

                    	    @RequestMapping(value ="/viewcitizen", method = RequestMethod.GET)
                    	    public String viewCitizenPage(Model model)
                    	    {
                    	    	
                    	    	List<Citizen> listCitizen = citizenService.getAllCitizenList();
                    	    	
                    	    	System.out.println(listCitizen);
                    	    	 
                    	    	model.addAttribute("citizenList", listCitizen);
                    	    	
                    	    	   return AppConstant.VIEW_CITIZEN;
                    	    			   
                    	    }
                    	    
                    	    /**
                    	     * here we have perform deletion operation based on 
                    	     * citizen id and redirecting the page of deletion
                    	     *   
                    	     */
                    	  
                    	     
                    	        @RequestMapping("/delete")
                    	    public String deleteCitizen(@RequestParam("id") Integer id)
                    	    {
                    	        	 citizenService.deleteCitizenById(id);
                    	    	  return AppConstant.DELETE_PAGE;
                    	    }
                    	    
                    	    
                    	    /**
                    	     * Viewing all the citizen in the form of pagination 
                    	     * @param model
                    	     * @param currPageNo
                    	     * @return
                    	     */
                    	      @RequestMapping(value="/viewCitizentbl", method= RequestMethod.GET)
                    	    public String viewCitizenInPageForm(Model model, @RequestParam("pn") Integer currPageNo)
                    	    { 
                    	    	   int pageSize = 5;
                    	    	     PageRequest pageRequest = PageRequest.of(currPageNo-1, pageSize);
                    	    	 Page<Citizen>  citizenPage=       citizenRepository.findAll(pageRequest);
                    	    	  List<Citizen>  citizenList=   citizenPage.getContent();
                    	    	  int totalPage= citizenPage.getTotalPages();
                    	    	  model.addAttribute("cp", currPageNo);
                    	    	  model.addAttribute("tp", totalPage);
                    	    	  model.addAttribute("citizenList", citizenList);
                    	    	  return AppConstant.SERVER_SIDE_PAGINATION_VIEW;
                    	    	 
                    	    }
                    	      
	/*
	 * @RequestMapping("/pagination") public String getDataInpagination(Model
	 * model,@RequestParam("pn") Integer currpage) { int pagesize=4; PageDto pageDto
	 * = service.serverSidepagination(currpage, pagesize); List<User>
	 * usersList=pageDto.getList(); Integer currPage= pageDto.getCurrPage(); Integer
	 * totPage=pageDto.getTotalPage();
	 * 
	 * model.addAttribute(AppConstants.CURRENT_PAGE, currPage);
	 * model.addAttribute(AppConstants.TOTAL_PAGE, totPage);
	 * model.addAttribute(AppConstants.ALL_USERS_KEY, usersList); return
	 * AppConstants.LOGIC_FOR_PAGINATION_VIEW; }
	 */
                    	      
                    	      
                    	      
                    	      
}
