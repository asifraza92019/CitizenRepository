package com.gaya.citizen.service;

import java.util.List;

import org.springframework.data.domain.jaxb.SpringDataJaxb.PageDto;

import com.gaya.citizen.bean.Citizen;

public interface CitizenService {

	   public Citizen saveCitizen(Citizen citizen);
	   
	   public  List<Citizen> getAllCitizenList();
	   
	   public Citizen getCitizenById(Integer id);
	   
	   public void   deleteCitizenById(Integer id);
	   
	   
	   public List<Citizen> findByEmail(String email);
	   
	   public  List<Citizen>  findByMobile(String mobile);
	   
	   
	   
	   
}
