package com.gaya.citizen.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.gaya.citizen.bean.Citizen;
import com.gaya.citizen.service.CitizenService;




/**
 * @author Asif
 * this is a rest controller 
 * here we have explained how to perform all crud operation
 * as well as how to deal will custom query method
 */
@RestController
@RequestMapping("/restcitizen")
public class CitizenRestController {

	   /**
	    *  injecting CitizenService object
	    */
	 
	    @Autowired
	  private CitizenService citizenService;
	    
	    
	    
	    /**
	     *   to find all citizen detail
	     * @return
	     */
	    
	    @GetMapping("/findAll")
	    
	    public List<Citizen> getAllCitizen()
	    {
	    	    
	    	  return   citizenService.getAllCitizenList();
	    	  
	    }
	    
	
    /**
     *  This method method will find alll the citizen detail based on a perticular 
     *   id 	    
     * @param id
     * @return
     */
	    
	       
	       @GetMapping("/findCitizen/{id}")
	    public Citizen getSingleCitizenById(@PathVariable("id") Integer id)
	    {
	      return 	 citizenService.getCitizenById(id);
	    }
	    
	          
	           /**
	            * This method to  stote the ciitzen detail in the databswe 
	            * 
	            * @param citizen
	            * @return
	            */
               @PostMapping("/savecitizen")       
	         public Citizen saveCitizen(@RequestBody Citizen citizen)
	         {
            	return citizenService.saveCitizen(citizen);
	       
	         }
	       
            /**
             * This method is used to delete the citizen based on the id 
             * if the id exits it will delete the record 
             * other send it will return null
             * @param id
             */
            
            @DeleteMapping("/delete/{id}") 
           public void deleteCitizen( @PathVariable("id") Integer id)
           {
        	       citizenService.deleteCitizenById(id);
           }
            
             /**
              *  this method  is for the update of the exiting data in the database
              * @param citizen
              * @return
              */
              @PutMapping("/update")
            public Citizen updateCitizen(@RequestBody Citizen citizen)
            {
            	   // System.out.println(id );
               return 	citizenService.saveCitizen(citizen);
            }
            
            
            
}
