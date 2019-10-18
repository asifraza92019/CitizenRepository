package com.gaya.citizen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 *  main class and main method from here our boot applicatio  execution start
 *  
 * @author Asif
 *
 *  here we have also configure swagger api as well as actuator api
 *  to see swagger ui page 
 *   http://localhost:9090/SBFormApp/swagger-ui.html
 *   to see swagger docutmetnation
 *   http://localhost:9090/SBFormApp/v2/api-docs
 *   to see actuator consider base path as 'http:localhost:9090/SBFormApp/actuator/....'
 *   we have also perform thread dump and heap dum for this connect with jconsole, jmap or
 *   use MAT pulgin
 */

@SpringBootApplication
@EnableSwagger2
public class CitizenServiceApplication {

	  /**
	   * Main method to give the instruct to jvm to start the execution 
	   * 
	   * @param args
	   */
	
	public static void main(String[] args) {
		SpringApplication.run(CitizenServiceApplication.class, args);
	}

	    
}
