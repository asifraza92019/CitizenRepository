package com.gaya.citizen.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.gaya.citizen.bean.Citizen;
import java.lang.String;

@Repository
public interface CitizenRepository  extends JpaRepository<Citizen, Integer>{

	
	List<Citizen>  findAll();
	
	 
	 List<Citizen>  findByEmail(String email);
	 
	 
	 List<Citizen>  findByMobile(String mobile);
}
