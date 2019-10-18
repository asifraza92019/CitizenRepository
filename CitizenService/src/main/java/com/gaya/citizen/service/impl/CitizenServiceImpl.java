package com.gaya.citizen.service.impl;

import java.util.List;
import java.util.Optional;

import javax.servlet.jsp.tagext.PageData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.jaxb.SpringDataJaxb.PageDto;
import org.springframework.stereotype.Service;

import com.gaya.citizen.bean.Citizen;
import com.gaya.citizen.repositories.CitizenRepository;
import com.gaya.citizen.service.CitizenService;

@Service
public class CitizenServiceImpl  implements CitizenService{
         
	  @Autowired
	private CitizenRepository citizenRepository;
	
	     
	     @Override
	public Citizen saveCitizen(Citizen citizen) {
	 
		    
		return  citizenRepository.save(citizen);
		
	}

	@Override
	public List<Citizen> getAllCitizenList() {
		
		  List<Citizen>  citizenList= citizenRepository.findAll();
		  return  citizenList;
	}

	@Override
	public Citizen getCitizenById(Integer id) {
		
		      Optional<Citizen> optional = citizenRepository.findById(id);
		      if(optional.isPresent())
		      {
		    	  return optional.get();
		      }
		      return new Citizen();
	}

	@Override
	public void deleteCitizenById(Integer id) {

            citizenRepository.deleteById(id);
		
	}

	
	
	public List<Citizen> findByEmail(String email)
	{
		return citizenRepository.findByEmail(email);
	}
	
	public  List<Citizen>  findByMobile(String mobile)
	{
		return citizenRepository.findByMobile(mobile);
	}
	
}
